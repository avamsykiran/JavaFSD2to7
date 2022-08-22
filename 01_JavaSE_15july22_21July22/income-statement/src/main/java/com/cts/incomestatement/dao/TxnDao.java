package com.cts.incomestatement.dao;

import java.util.List;

import com.cts.incomestatement.exception.OperationFailedException;
import com.cts.incomestatement.model.Txn;

public interface TxnDao {
	Txn save(Txn txn) throws OperationFailedException;
	Txn getById(int txnId) throws OperationFailedException;
	List<Txn> getAll() throws OperationFailedException;
	void deleteById(int txnId) throws OperationFailedException;
}
