package org.linkplus.banksystem.account;

import jakarta.persistence.*;
import org.linkplus.banksystem.bank.BankEntity;
import org.linkplus.banksystem.commons.BaseEntity;
import org.linkplus.banksystem.transaction.TransactionEntity;

import java.util.List;

@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {

    private String username;

    private Double balance;

    @Column(name = "bank_id", insertable = false, updatable = false)
    private Long bankId;

    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private BankEntity bank;

    @ManyToMany(mappedBy = "accounts")
    private List<TransactionEntity> transactions;

    public List<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionEntity> transactions) {
        this.transactions = transactions;
    }

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

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }
}
