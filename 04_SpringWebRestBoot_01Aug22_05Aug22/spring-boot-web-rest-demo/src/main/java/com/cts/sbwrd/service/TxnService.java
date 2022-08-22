package com.cts.sbwrd.service;

import java.util.List;

import com.cts.sbwrd.entity.Txn;
import com.cts.sbwrd.entity.TxnType;
import com.cts.sbwrd.exception.NotInsertableTxnException;
import com.cts.sbwrd.exception.NotUpdatableTxnException;
import com.cts.sbwrd.exception.TxnNotFoundException;

public interface TxnService {

	Txn add(Txn txn) throws NotInsertableTxnException;
	Txn update(Txn txn) throws NotUpdatableTxnException, TxnNotFoundException;
	Txn getById(Long id) throws TxnNotFoundException;
	void deleteById(Long id) throws TxnNotFoundException;
	List<Txn> getAll();
	double getTotalValue(List<Txn> txns,TxnType type);
}
