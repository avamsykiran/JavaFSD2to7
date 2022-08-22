package in.cts.budgetanalysis.txns.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.cts.budgetanalysis.txns.entities.Txn;

public interface TxnRepo extends JpaRepository<Txn,Long> {
	
	@Query("SELECT t FROM Txn t WHERE t.holder.ahId=:ahId AND t.dateOfTransaction BETWEEN :from AND :to")
	List<Txn> getAllTxns(Long ahId,LocalDate from,LocalDate to);
}
