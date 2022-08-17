package in.cts.budgetanalysis.txns.services;

import in.cts.budgetanalysis.txns.entities.AccountHolder;

public interface AccountHolderService {
	AccountHolder getById(long ahId);
	AccountHolder save(AccountHolder accountHolder);
	double getCurrentBalance(long ahId);
}
