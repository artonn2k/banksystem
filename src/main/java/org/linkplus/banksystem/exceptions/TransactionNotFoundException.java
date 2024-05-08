package org.linkplus.banksystem.exceptions;

public class TransactionNotFoundException extends RuntimeException{

    public TransactionNotFoundException(String message){
        super(message);
    }
}
