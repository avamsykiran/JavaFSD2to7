package com.cts.incomestatement.service;

import java.util.List;

import com.cts.incomestatement.exception.InvalidTxnException;
import com.cts.incomestatement.exception.OperationFailedException;
import com.cts.incomestatement.model.Txn;
import com.cts.incomestatement.model.TxnType;

public interface TxnService {
	Txn save(Txn txn) throws OperationFailedException,InvalidTxnException;
	Txn getById(int txnId) throws OperationFailedException;
	List<Txn> getAll() throws OperationFailedException;
	void deleteById(int txnId) throws OperationFailedException;
	double getTotalAmount(List<Txn> txns,TxnType type);
}
