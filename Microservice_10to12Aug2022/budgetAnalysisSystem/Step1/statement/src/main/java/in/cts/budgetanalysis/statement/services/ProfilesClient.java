package in.cts.budgetanalysis.statement.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.cts.budgetanalysis.statement.models.AccountHolderProfile;

@FeignClient(name="profiles",url="http://localhost:9100")
public interface ProfilesClient {

	@GetMapping("/{ahid}")
	public AccountHolderProfile getAccountHolderById(@PathVariable("ahid") Long ahid);
	
	@GetMapping("/{ahid}/exists")
	public boolean doesAccountHolderExists(@PathVariable("ahid") Long ahid);
		
}
