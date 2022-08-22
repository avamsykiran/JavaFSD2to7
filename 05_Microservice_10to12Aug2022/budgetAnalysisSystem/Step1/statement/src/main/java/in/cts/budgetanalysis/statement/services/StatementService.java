package in.cts.budgetanalysis.statement.services;

import java.time.Month;

import in.cts.budgetanalysis.statement.exceptions.BadStatementException;
import in.cts.budgetanalysis.statement.models.Statement;

public interface StatementService {
	Statement generateMonthlyStatement(long ahId,Month month,int year) throws BadStatementException;
	Statement generateAnnualStatement(long ahId,int year) throws BadStatementException;
}
