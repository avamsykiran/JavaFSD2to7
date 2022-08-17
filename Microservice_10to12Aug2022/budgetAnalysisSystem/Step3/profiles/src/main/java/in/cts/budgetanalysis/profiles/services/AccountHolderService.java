package in.cts.budgetanalysis.profiles.services;

import in.cts.budgetanalysis.profiles.entities.AccountHolder;
import in.cts.budgetanalysis.profiles.exceptions.BadProfileException;

public interface AccountHolderService {
	boolean existsById(Long id) throws BadProfileException;
	AccountHolder getById(Long id) throws BadProfileException;
	AccountHolder add(AccountHolder accountHolder) throws BadProfileException;
	AccountHolder modify(AccountHolder accountHolder) throws BadProfileException;
}
