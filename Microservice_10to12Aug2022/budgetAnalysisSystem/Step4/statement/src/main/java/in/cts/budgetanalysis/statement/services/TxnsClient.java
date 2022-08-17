package in.cts.budgetanalysis.statement.services;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.cts.budgetanalysis.statement.models.Txn;

@FeignClient(name="txns")
@LoadBalancerClient(name="txns")
public interface TxnsClient {
	
	@GetMapping("/{ahId}/balance")
	public double getCurrentBalance(@PathVariable("ahId")long ahId);
	
	@GetMapping("/{ahId}/{from}/{to}")
	public Set<Txn> getAllTxns(
				@PathVariable("ahId") long ahId,
				@PathVariable("from") @DateTimeFormat(iso=ISO.DATE) LocalDate from,
				@PathVariable("to") @DateTimeFormat(iso=ISO.DATE) LocalDate to
			);
}
