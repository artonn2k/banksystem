package org.linkplus.banksystem.bank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.linkplus.banksystem.account.AccountEntity;
import org.linkplus.banksystem.commons.BaseEntity;

import java.util.List;

@Entity
@Table(name = "bank")
public class BankEntity extends BaseEntity {

    private String bankName;

    private Double totalTransactionFeeAmount;

    private Double totalTransferAmount;

    private Double transactionFlatFeeAmount;

    private Double transactionPercentFeeValue;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("bank")
    private List<AccountEntity> accounts;

    public List<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountEntity> accounts) {
        this.accounts = accounts;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getTotalTransactionFeeAmount() {
        return totalTransactionFeeAmount;
    }

    public void setTotalTransactionFeeAmount(Double totalTransactionFeeAmount) {
        this.totalTransactionFeeAmount = totalTransactionFeeAmount;
    }

    public Double getTotalTransferAmount() {
        return totalTransferAmount;
    }

    public void setTotalTransferAmount(Double totalTransferAmount) {
        this.totalTransferAmount = totalTransferAmount;
    }

    public Double getTransactionFlatFeeAmount() {
        return transactionFlatFeeAmount;
    }

    public void setTransactionFlatFeeAmount(Double transactionFlatFeeAmount) {
        this.transactionFlatFeeAmount = transactionFlatFeeAmount;
    }

    public Double getTransactionPercentFeeValue() {
        return transactionPercentFeeValue;
    }

    public void setTransactionPercentFeeValue(Double transactionPercentFeeValue) {
        this.transactionPercentFeeValue = transactionPercentFeeValue;
    }
}
