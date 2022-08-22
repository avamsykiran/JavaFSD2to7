package in.cts.budgetanalysis.txns.services;

import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cts.budgetanalysis.txns.entities.AccountHolder;
import in.cts.budgetanalysis.txns.repos.AccountHolderRepo;

@Service
public class AccountHolderServiceImpl implements AccountHolderService{

	@Autowired
	private AccountHolderRepo ahRepo;
	
	@Autowired
	private ProfilesClient profiles;
	
	@Override
	public AccountHolder getById(long ahId) {
		AccountHolder ah = ahRepo.findById(ahId).orElse(null);
		if(ah==null && profiles.checkForAccountHolderById(ahId)) {
			ah = new AccountHolder(ahId, 0.0, new TreeSet<>());
		}
		return ah;
	}
	
	@Override
	public AccountHolder save(AccountHolder accountHolder) {
		return ahRepo.save(accountHolder);
	}
	
	@Override
	public double getCurrentBalance(long ahId) {
		AccountHolder ah = ahRepo.findById(ahId).orElse(null);
		return ah==null?0:ah.getCurrentBalance();
	}


}
