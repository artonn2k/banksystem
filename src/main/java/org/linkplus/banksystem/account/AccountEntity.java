package org.linkplus.banksystem.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.linkplus.banksystem.commons.BaseEntity;

@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {

    private String username;

    private Double balance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
