package com.cts.sbwrd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.sbwrd.entity.Txn;
import com.cts.sbwrd.exception.NotInsertableTxnException;
import com.cts.sbwrd.exception.NotUpdatableTxnException;
import com.cts.sbwrd.exception.TxnNotFoundException;
import com.cts.sbwrd.service.TxnService;

@RestController
@RequestMapping("/txns")
public class TxnsController {

	@Autowired
	private TxnService txnService;

	@GetMapping
	public ResponseEntity<List<Txn>> getAllUrlHandler() {
		List<Txn> txns = txnService.getAll();
		return new ResponseEntity<>(txns, HttpStatus.OK);
	}	
	
	@GetMapping("/{txnId}")
	public ResponseEntity<Txn> getTxnUrlHandler(@PathVariable("txnId") Long txnId) throws TxnNotFoundException {
		return new ResponseEntity<>(txnService.getById(txnId), HttpStatus.OK);
	}

	@DeleteMapping("/{txnId}")
	public ResponseEntity<Void> deleteHandler(@PathVariable("txnId") Long txnId) throws TxnNotFoundException {
		txnService.deleteById(txnId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping
	public ResponseEntity<Txn> saveHandler(@RequestBody @Valid Txn txn, BindingResult bindingResults)
			throws NotInsertableTxnException {

		if (bindingResults.hasErrors()) {
			throw new NotInsertableTxnException(bindingResults.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce((s1,s2)->s1+","+s2).orElse(""));
		}
	
		return new ResponseEntity<>(txnService.add(txn), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Txn> updateHandler(@RequestBody @Valid Txn txn, BindingResult bindingResults)
			throws NotUpdatableTxnException, TxnNotFoundException {	

		if (bindingResults.hasErrors()) {
			throw new NotUpdatableTxnException(bindingResults.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce((s1,s2)->s1+","+s2).orElse(""));
		}
	
		return new ResponseEntity<>(txnService.update(txn) , HttpStatus.ACCEPTED);
	}

}
