package com.cts.sbwmd.service;

import java.util.List;

import com.cts.sbwmd.entity.Txn;
import com.cts.sbwmd.entity.TxnType;
import com.cts.sbwmd.exception.NotInsertableTxnException;
import com.cts.sbwmd.exception.NotUpdatableTxnException;
import com.cts.sbwmd.exception.TxnNotFoundException;

public interface TxnService {

	Txn add(Txn txn) throws NotInsertableTxnException;
	Txn update(Txn txn) throws NotUpdatableTxnException, TxnNotFoundException;
	Txn getById(Long id) throws TxnNotFoundException;
	void deleteById(Long id) throws TxnNotFoundException;
	List<Txn> getAll();
	double getTotalValue(List<Txn> txns,TxnType type);
}
