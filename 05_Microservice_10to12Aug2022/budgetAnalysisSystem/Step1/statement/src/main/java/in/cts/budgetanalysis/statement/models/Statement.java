package in.cts.budgetanalysis.statement.models;

import java.time.LocalDate;
import java.util.Set;

public class Statement {
	private AccountHolderProfile profile;
    private Set<Txn> txns;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Double totalCredit;
    private Double totalDebit;
    private Double statementBalance;
    
    public Statement() {
		// TODO Auto-generated constructor stub
	}

	public Statement(AccountHolderProfile profile, Set<Txn> txns, LocalDate fromDate, LocalDate toDate,
			Double totalCredit, Double totalDebit, Double statementBalance) {
		super();
		this.profile = profile;
		this.txns = txns;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.totalCredit = totalCredit;
		this.totalDebit = totalDebit;
		this.statementBalance = statementBalance;
	}

	public AccountHolderProfile getProfile() {
		return profile;
	}

	public void setProfile(AccountHolderProfile profile) {
		this.profile = profile;
	}

	public Set<Txn> getTxns() {
		return txns;
	}

	public void setTxns(Set<Txn> txns) {
		this.txns = txns;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public Double getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(Double totalCredit) {
		this.totalCredit = totalCredit;
	}

	public Double getTotalDebit() {
		return totalDebit;
	}

	public void setTotalDebit(Double totalDebit) {
		this.totalDebit = totalDebit;
	}

	public Double getStatementBalance() {
		return statementBalance;
	}

	public void setStatementBalance(Double statementBalance) {
		this.statementBalance = statementBalance;
	}
}
