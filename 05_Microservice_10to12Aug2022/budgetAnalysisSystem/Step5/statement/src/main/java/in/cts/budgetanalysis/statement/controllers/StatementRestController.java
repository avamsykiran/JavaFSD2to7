package in.cts.budgetanalysis.statement.controllers;

import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cts.budgetanalysis.statement.exceptions.BadStatementException;
import in.cts.budgetanalysis.statement.exceptions.ServiceUnavailableException;
import in.cts.budgetanalysis.statement.models.Statement;
import in.cts.budgetanalysis.statement.services.StatementService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/")
public class StatementRestController {

	@Autowired
	private StatementService service;
	
	@GetMapping("/{ahId}/{year}")
	@CircuitBreaker(name="cb1",fallbackMethod = "generateAnnualStatementActionFallback")
	public ResponseEntity<Statement> generateAnnualStatementAction(
			@PathVariable("ahId")long ahId,
			@PathVariable("year")int year) throws BadStatementException{
		return ResponseEntity.ok(service.generateAnnualStatement(ahId, year));
	}
	
	public ResponseEntity<Statement> generateAnnualStatementActionFallback(long ahId,int year) throws BadStatementException{
		throw new ServiceUnavailableException("Unable to fetech requried data! please try later");
	}
	
	@GetMapping("/{ahId}/{year}/{month}")
	@CircuitBreaker(name="cb2",fallbackMethod = "generateMonthlyStatementActionFallback")
	public ResponseEntity<Statement> generateMonthlyStatementAction(
			@PathVariable("ahId")long ahId,
			@PathVariable("year")int year,
			@PathVariable("month")Month month) throws BadStatementException{
		return ResponseEntity.ok(service.generateMonthlyStatement(ahId, month, year));
	}
	
	public ResponseEntity<Statement> generateMonthlyStatementActionFallback(long ahId,int year,Month month) throws BadStatementException{
		throw new ServiceUnavailableException("Unable to fetech requried data! please try later");
	}
}
