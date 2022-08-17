package in.cts.budgetanalysis.txns.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cts.budgetanalysis.txns.entities.AccountHolder;

public interface AccountHolderRepo extends JpaRepository<AccountHolder, Long> {

}
