package org.linkplus.banksystem.exceptions;

import org.linkplus.banksystem.account.AccountEntity;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(String message){
        super(message);
    }
}
