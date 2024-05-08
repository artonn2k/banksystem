package org.linkplus.banksystem.exceptions;

public class BankNotFoundException extends RuntimeException{

    public BankNotFoundException(String message){
        super(message);
    }
}
