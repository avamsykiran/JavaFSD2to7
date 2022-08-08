package com.cts.sbwrd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.sbwrd.exception.NotInsertableTxnException;
import com.cts.sbwrd.exception.NotUpdatableTxnException;
import com.cts.sbwrd.exception.TxnNotFoundException;

@RestControllerAdvice
public class GlobalExceptionsAdvice {

	private Logger logger;
	
	public GlobalExceptionsAdvice(){
		this.logger=LoggerFactory.getLogger(this.getClass());
	}
	
	@ExceptionHandler(TxnNotFoundException.class)
	public ResponseEntity<String> handleTxnNotFoundException(TxnNotFoundException exp){
		logger.error("", exp);
		return new ResponseEntity<String>("Transaction not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({NotInsertableTxnException.class,NotUpdatableTxnException.class})
	public ResponseEntity<String> handleInvalidTxn(Throwable exp){
		logger.error(exp.getMessage(), exp);
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAllOtherExceptions(Throwable exp){
		logger.error(exp.getMessage(), exp);
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
