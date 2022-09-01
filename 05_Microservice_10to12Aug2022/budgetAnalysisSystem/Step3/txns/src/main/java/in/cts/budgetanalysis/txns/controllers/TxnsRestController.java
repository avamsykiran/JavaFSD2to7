package in.cts.budgetanalysis.txns.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cts.budgetanalysis.txns.entities.Txn;
import in.cts.budgetanalysis.txns.exceptions.BadTxnException;
import in.cts.budgetanalysis.txns.services.AccountHolderService;
import in.cts.budgetanalysis.txns.services.TxnService;

@RestController
@CrossOrigin
@RequestMapping("/")
public class TxnsRestController {

	@Autowired
	private AccountHolderService ahService;
	
	@Autowired
	private TxnService txnService;
	
	@GetMapping("/{ahId}/balance")
	public ResponseEntity<Double> getCurrentBalance(@PathVariable("ahId")long ahId){
		return ResponseEntity.ok(ahService.getCurrentBalance(ahId));
	}
	
	@GetMapping("/{ahId}/{from}/{to}")
	public ResponseEntity<List<Txn>> getAllTxns(
				@PathVariable("ahId") long ahId,
				@PathVariable("from") @DateTimeFormat(iso=ISO.DATE) LocalDate from,
				@PathVariable("to") @DateTimeFormat(iso=ISO.DATE) LocalDate to
			){
		return ResponseEntity.ok(txnService.getAllTxns(ahId, from, to));
	}
	/*
	@PostMapping
	public ResponseEntity<Txn> addTxn(@RequestBody Txn txn) throws BadTxnException{
		return new ResponseEntity<Txn>(txnService.save(txn),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Txn> modifyTxn(@RequestBody Txn txn) throws BadTxnException{
		return new ResponseEntity<Txn>(txnService.save(txn),HttpStatus.ACCEPTED);
	}*/
	
	@PostMapping
	@PutMapping
	public ResponseEntity<Txn> saveTxn(@RequestBody Txn txn,HttpServletRequest req) throws BadTxnException{
		return new ResponseEntity<Txn>(txnService.save(txn),
				req.getMethod().equalsIgnoreCase("POST")? HttpStatus.CREATED:HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{txnId}")
	public ResponseEntity<Void> deleteTxn(@PathVariable("txnId") long txnId) throws BadTxnException{
		txnService.deleteById(txnId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
