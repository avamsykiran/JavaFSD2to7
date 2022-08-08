package com.cts.sbwrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbwrd.entity.Txn;
import com.cts.sbwrd.entity.TxnType;
import com.cts.sbwrd.exception.NotInsertableTxnException;
import com.cts.sbwrd.exception.NotUpdatableTxnException;
import com.cts.sbwrd.exception.TxnNotFoundException;
import com.cts.sbwrd.repo.TxnRepo;

@Service
public class TxnServiceImpl implements TxnService {

	@Autowired
	private TxnRepo txnRepo;

	@Override
	public Txn add(Txn txn) throws NotInsertableTxnException {
		if (txn == null || txn.getTxnId() != null)
			throw new NotInsertableTxnException();

		return txnRepo.save(txn);
	}

	@Override
	public Txn update(Txn txn) throws NotUpdatableTxnException, TxnNotFoundException {
		if (txn == null || txn.getTxnId() == null)
			throw new NotUpdatableTxnException();

		if (!txnRepo.existsById(txn.getTxnId()))
			throw new TxnNotFoundException();

		return txnRepo.save(txn);
	}

	@Override
	public Txn getById(Long id) throws TxnNotFoundException {
		Txn txn = txnRepo.findById(id).orElse(null);

		if (txn == null)
			throw new TxnNotFoundException();

		return txn;
	}

	@Override
	public List<Txn> getAll() {
		return txnRepo.findAll();
	}

	@Override
	public double getTotalValue(List<Txn> txns, TxnType type) {
		double value=0;
		
		if(txns!=null && !txns.isEmpty()) {
			value = txns.stream().filter(t -> t.getType()==type).mapToDouble(Txn::getAmount).sum();
		}
		
		return value;
	}

	@Override
	public void deleteById(Long id) throws TxnNotFoundException {
		if (!txnRepo.existsById(id))
			throw new TxnNotFoundException();

		txnRepo.deleteById(id);
	}

}
