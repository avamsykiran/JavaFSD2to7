package in.cts.budgetanalysis.txns.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="profiles",url = "http://localhost:9100")
public interface ProfilesClient {
	@GetMapping("/{ahid}/exists")
	boolean checkForAccountHolderById(@PathVariable(name="ahid") long ahId); 
}
