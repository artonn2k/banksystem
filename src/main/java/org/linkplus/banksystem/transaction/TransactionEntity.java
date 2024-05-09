package org.linkplus.banksystem.transaction;

import jakarta.persistence.*;
import org.linkplus.banksystem.account.AccountEntity;
import org.linkplus.banksystem.commons.BaseEntity;

import java.util.List;

@Entity
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity {

    private Double amount;

    private Long originatingAccountId;

    private Long resultingAccountId;
    private String transactionReason;
    private String transactionType;

    @ManyToMany
    @JoinTable(
            name = "transaction_account",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    private List<AccountEntity> accounts;

    public List<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountEntity> accounts) {
        this.accounts = accounts;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getOriginatingAccountId() {
        return originatingAccountId;
    }

    public void setOriginatingAccountId(Long originatingAccountId) {
        this.originatingAccountId = originatingAccountId;
    }

    public Long getResultingAccountId() {
        return resultingAccountId;
    }

    public void setResultingAccountId(Long resultingAccountId) {
        this.resultingAccountId = resultingAccountId;
    }

    public String getTransactionReason() {
        return transactionReason;
    }

    public void setTransactionReason(String transactionReason) {
        this.transactionReason = transactionReason;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
