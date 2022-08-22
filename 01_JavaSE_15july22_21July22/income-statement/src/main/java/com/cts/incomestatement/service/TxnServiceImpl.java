package com.cts.incomestatement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cts.incomestatement.dao.TxnDao;
import com.cts.incomestatement.dao.TxnDaoJdbcImpl;
import com.cts.incomestatement.exception.InvalidTxnException;
import com.cts.incomestatement.exception.OperationFailedException;
import com.cts.incomestatement.model.Txn;
import com.cts.incomestatement.model.TxnType;

public class TxnServiceImpl implements TxnService {

	private TxnDao txnDao;

	public TxnServiceImpl() throws OperationFailedException {
		//this.txnDao = new TxnDaoFileSystemImpl();
		this.txnDao = new TxnDaoJdbcImpl();
	}

	private boolean isValid(Txn txn) throws InvalidTxnException {
		List<String> errors = new ArrayList<String>();

		if (txn == null) {
			errors.add("No transaction record found");
		} else {
			if (txn.getAmount() <= 0) {
				errors.add("Amount can not be negative or zero");
			}
			if (txn.getDesp() == null || txn.getDesp().isEmpty()) {
				errors.add("Description can not be blank");
			}
			if (txn.getTxndate().isAfter(LocalDate.now())) {
				errors.add("Transaction Date can not be of future");
			}
			if (txn.getType() == null) {
				errors.add("Transaction type can not be blank");
			}
		}

		if (!errors.isEmpty()) {
			throw new InvalidTxnException(errors.toString());
		}

		return errors.isEmpty();
	}

	@Override
	public Txn save(Txn txn) throws OperationFailedException, InvalidTxnException {
		if (isValid(txn)) {
			txn = txnDao.save(txn);
		}
		return txn;
	}

	@Override
	public Txn getById(int txnId) throws OperationFailedException {
		return txnDao.getById(txnId);
	}

	@Override
	public List<Txn> getAll() throws OperationFailedException {
		return txnDao.getAll();
	}

	@Override
	public void deleteById(int txnId) throws OperationFailedException {
		txnDao.deleteById(txnId);
	}

	@Override
	public double getTotalAmount(List<Txn> txns, TxnType type) {
		return txns.stream().filter(t -> t.getType()==type).mapToDouble(Txn::getAmount).sum();
	}

}
