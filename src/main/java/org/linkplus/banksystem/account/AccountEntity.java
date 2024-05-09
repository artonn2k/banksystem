package org.linkplus.banksystem.account;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.linkplus.banksystem.bank.BankEntity;
import org.linkplus.banksystem.commons.BaseEntity;

@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {

    private String username;

    private Double balance;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankEntity bank;

    public BankEntity getBank() {
        return bank;
    }

    public void setBank(BankEntity bank) {
        this.bank = bank;
    }

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
