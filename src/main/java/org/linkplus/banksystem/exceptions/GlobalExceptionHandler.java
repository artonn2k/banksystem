package org.linkplus.banksystem.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AccountNotFoundException.class)
    ResponseEntity<ErrorResponse> handleAccountNotFoundException(AccountNotFoundException ex){

        logger.info(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(BankNotFoundException.class)
    ResponseEntity<ErrorResponse> handleBankNotFoundException(BankNotFoundException ex){

        logger.info(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    ResponseEntity<ErrorResponse> handleTransactionNotFoundException(TransactionNotFoundException ex){

        logger.info(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage()));
    }
}
