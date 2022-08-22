package in.cts.budgetanalysis.profiles.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cts.budgetanalysis.profiles.entities.AccountHolder;

public interface AccountHolderRepo extends JpaRepository<AccountHolder, Long>{

}
