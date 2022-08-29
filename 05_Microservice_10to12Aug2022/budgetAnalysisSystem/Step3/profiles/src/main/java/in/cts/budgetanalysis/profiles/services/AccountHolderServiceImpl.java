package in.cts.budgetanalysis.profiles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cts.budgetanalysis.profiles.entities.AccountHolder;
import in.cts.budgetanalysis.profiles.exceptions.BadProfileException;
import in.cts.budgetanalysis.profiles.repos.AccountHolderRepo;

@Service
public class AccountHolderServiceImpl implements AccountHolderService{

	@Autowired
	private AccountHolderRepo ahRepo;

	@Override
	public List<AccountHolder> getAll() {
		return ahRepo.findAll();
	}
	
	@Override
	public boolean existsById(Long id) throws BadProfileException {
		return ahRepo.existsById(id);
	}

	@Override
	public AccountHolder getById(Long id) throws BadProfileException {
		return ahRepo.findById(id).orElse(null);
	}

	@Override
	public AccountHolder add(AccountHolder accountHolder) throws BadProfileException {
		if(accountHolder.getAhId()!=null && ahRepo.existsById(accountHolder.getAhId()))
			throw new BadProfileException("Record Exists Already");
		return ahRepo.save(accountHolder);
	}

	@Override
	public AccountHolder modify(AccountHolder accountHolder) throws BadProfileException {
		if(accountHolder.getAhId()==null || !ahRepo.existsById(accountHolder.getAhId()))
			throw new BadProfileException("Record Does Not Exists Hence Can Not Be Modified");
		return ahRepo.save(accountHolder);
	}


}
