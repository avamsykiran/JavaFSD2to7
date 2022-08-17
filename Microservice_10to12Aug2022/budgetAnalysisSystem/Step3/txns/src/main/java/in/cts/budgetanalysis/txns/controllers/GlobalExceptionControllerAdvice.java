package in.cts.budgetanalysis.txns.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.cts.budgetanalysis.txns.exceptions.BadTxnException;

@RestControllerAdvice
public class GlobalExceptionControllerAdvice {

	Logger logger;
	
	public GlobalExceptionControllerAdvice() {
		logger = LoggerFactory.getLogger(this.getClass());
	}
	
	@ExceptionHandler(BadTxnException.class)
	public ResponseEntity<String> handleBadTxnException(BadTxnException exp){
		logger.info("sending bad request as response",exp);
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleUnhandledExceptions(Exception exp){
		logger.error("sending internal server error as resposne",exp);
		return new ResponseEntity<String>("Regeret Inconvinience! Please try again later!", 
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
