package in.cts.budgetanalysis.statement.services;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cts.budgetanalysis.statement.exceptions.BadStatementException;
import in.cts.budgetanalysis.statement.models.AccountHolderProfile;
import in.cts.budgetanalysis.statement.models.Statement;
import in.cts.budgetanalysis.statement.models.Txn;
import in.cts.budgetanalysis.statement.models.TxnType;

@Service
public class StatementServiceImpl implements StatementService {
	
	@Autowired
	private ProfilesClient profilesClient;
	
	@Autowired
	private TxnsClient txnsClient;

	private double sumOfAll(Set<Txn> txns,TxnType type) {
		return txns.stream().
				filter(t -> t.getType()==type).
				mapToDouble(Txn::getAmount).sum();
	}
	
	private Statement generateStatement(long ahId, LocalDate from, LocalDate to) throws BadStatementException {
		
		if(!profilesClient.doesAccountHolderExists(ahId)) {
			throw new BadStatementException("Statement for a non-existing account can not be generated");
		}
		
		AccountHolderProfile profile = profilesClient.getAccountHolderById(ahId);
		profile.setCurrentBalance(txnsClient.getCurrentBalance(ahId));	
		Set<Txn> txns = txnsClient.getAllTxns(ahId, from, to);
		
		double totalCredit = sumOfAll(txns, TxnType.CREDIT);
		double totalDebit = sumOfAll(txns, TxnType.DEBIT);
		double statementBalance = totalCredit-totalDebit;
		
		return new Statement(profile, txns, from, to, totalCredit, totalDebit, statementBalance);
	}
		
	@Override
	public Statement generateMonthlyStatement(long ahId, Month month, int year) throws BadStatementException {
		LocalDate from = LocalDate.of(year, month, 1);
		LocalDate to = from.with(TemporalAdjusters.lastDayOfMonth());
		return generateStatement(ahId, from, to);
	}

	@Override
	public Statement generateAnnualStatement(long ahId, int year) throws BadStatementException {
		LocalDate from = LocalDate.of(year, Month.JANUARY, 1);
		LocalDate to = from.with(TemporalAdjusters.lastDayOfYear());
		return generateStatement(ahId, from, to);
	}

}
