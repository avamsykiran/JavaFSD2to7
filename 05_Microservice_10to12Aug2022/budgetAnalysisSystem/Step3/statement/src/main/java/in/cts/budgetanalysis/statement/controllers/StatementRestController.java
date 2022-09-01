package in.cts.budgetanalysis.statement.controllers;

import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cts.budgetanalysis.statement.exceptions.BadStatementException;
import in.cts.budgetanalysis.statement.models.Statement;
import in.cts.budgetanalysis.statement.services.StatementService;

@RestController
@CrossOrigin
@RequestMapping("/")
public class StatementRestController {

	@Autowired
	private StatementService service;
	
	@GetMapping("/{ahId}/{year}")
	public ResponseEntity<Statement> generateAnnualStatementAction(
			@PathVariable("ahId")long ahId,
			@PathVariable("year")int year) throws BadStatementException{
		return ResponseEntity.ok(service.generateAnnualStatement(ahId, year));
	}
	
	@GetMapping("/{ahId}/{year}/{month}")
	public ResponseEntity<Statement> generateMonthlyStatementAction(
			@PathVariable("ahId")long ahId,
			@PathVariable("year")int year,
			@PathVariable("month")Month month) throws BadStatementException{
		return ResponseEntity.ok(service.generateMonthlyStatement(ahId, month, year));
	}
}
