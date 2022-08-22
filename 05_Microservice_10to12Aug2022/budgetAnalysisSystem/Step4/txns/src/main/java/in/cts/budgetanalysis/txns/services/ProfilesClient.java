package in.cts.budgetanalysis.txns.services;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="profiles")
@LoadBalancerClient(name="profiles")
public interface ProfilesClient {
	@GetMapping("/{ahid}/exists")
	boolean checkForAccountHolderById(@PathVariable(name="ahid") long ahId); 
}
