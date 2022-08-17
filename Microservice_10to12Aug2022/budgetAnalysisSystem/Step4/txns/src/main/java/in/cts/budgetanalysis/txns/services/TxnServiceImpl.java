package in.cts.budgetanalysis.txns.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cts.budgetanalysis.txns.entities.AccountHolder;
import in.cts.budgetanalysis.txns.entities.Txn;
import in.cts.budgetanalysis.txns.entities.TxnType;
import in.cts.budgetanalysis.txns.exceptions.BadTxnException;
import in.cts.budgetanalysis.txns.repos.TxnRepo;

@Service
public class TxnServiceImpl implements TxnService{

	@Autowired
	private AccountHolderService ahService;
	
	@Autowired
	private TxnRepo txnRepo;
	
	@Override
	public Txn save(Txn txn) throws BadTxnException {
		long ahId = txn.getHolder().getAhId();
		AccountHolder ah = ahService.getById(ahId);
		
		if(ah==null)
			throw new BadTxnException("Txn can not be attached to an account that does not exist");
		
		txn.setHolder(ah);
		
		ah.setCurrentBalance(txn.getType()==TxnType.CREDIT?
				ah.getCurrentBalance()+txn.getAmount():ah.getCurrentBalance()-txn.getAmount());
		
		ahService.save(ah);
		txn = txnRepo.save(txn);
		return txn;
	}

	@Override
	public void deleteById(long txnId) throws BadTxnException {
		Txn txn = txnRepo.findById(txnId).orElse(null);
		if(txn==null)
			throw new BadTxnException("No Such Txn To Delete");
				
		AccountHolder ah = txn.getHolder();
		
		ah.setCurrentBalance(txn.getType()==TxnType.CREDIT?
				ah.getCurrentBalance()-txn.getAmount():ah.getCurrentBalance()+txn.getAmount());
		
		ahService.save(ah);
		txnRepo.delete(txn);
	}

	@Override
	public List<Txn> getAllTxns(long ahId, LocalDate from, LocalDate to) {
		return txnRepo.getAllTxns(ahId, from, to);
	}

}
