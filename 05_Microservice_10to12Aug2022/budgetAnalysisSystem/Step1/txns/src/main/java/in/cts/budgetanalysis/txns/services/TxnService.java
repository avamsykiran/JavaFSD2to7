package in.cts.budgetanalysis.txns.services;

import java.time.LocalDate;
import java.util.List;

import in.cts.budgetanalysis.txns.entities.Txn;
import in.cts.budgetanalysis.txns.exceptions.BadTxnException;

public interface TxnService {
	Txn save(Txn txn) throws BadTxnException;
	void deleteById(long txnId) throws BadTxnException;
	List<Txn> getAllTxns(long ahId,LocalDate from,LocalDate to);
}
