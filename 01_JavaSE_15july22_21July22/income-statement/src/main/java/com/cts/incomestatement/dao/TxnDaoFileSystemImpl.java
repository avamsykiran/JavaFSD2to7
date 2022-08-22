package com.cts.incomestatement.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.incomestatement.exception.OperationFailedException;
import com.cts.incomestatement.model.Txn;

public class TxnDaoFileSystemImpl implements TxnDao {
	private static final String FILE_NAME = "txns.data";

	private Map<Integer, Txn> txns;

	public TxnDaoFileSystemImpl() throws OperationFailedException {
		Path path = Paths.get(FILE_NAME);
		if (Files.notExists(path)) {
			txns = new TreeMap<Integer, Txn>();
		} else {
			try (ObjectInputStream objin = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
				txns = (Map<Integer, Txn>) objin.readObject();
			} catch (IOException | ClassNotFoundException e) {
				//log the actual exception
				throw new OperationFailedException("Unable to load data from data source");
			}
		}
	}

	private void writeData() throws OperationFailedException{
		try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
			objOut.writeObject(txns);
		}catch (IOException e) {
			//log the actual exception
			throw new OperationFailedException("Unable to load data from data source");
		}
	}
	
	private int nextId() {
		return txns.isEmpty()?1:txns.keySet().stream().reduce(0, Math::max)+1;
	}
	
	public Txn save(Txn txn) throws OperationFailedException {
		txn.setTxnId(nextId());
		txns.put(txn.getTxnId(), txn);
		writeData();
		return txn;
	}

	public Txn getById(int txnId) throws OperationFailedException {
		return txns.get(txnId);
	}

	public List<Txn> getAll() throws OperationFailedException {
		return new ArrayList<Txn>(txns.values());
	}

	public void deleteById(int txnId) throws OperationFailedException {
		txns.remove(txnId);
		writeData();
	}

}
