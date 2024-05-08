package org.linkplus.banksystem.bank;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.linkplus.banksystem.commons.BaseEntity;

@Entity
@Table(name = "bank")
public class BankEntity extends BaseEntity {

    private String bankName;

    private Double totalTransactionFeeAmount;

    private Double totalTransferAmount;

    private Double transactionFlatFeeAmount;

    private Double transactionPercentFeeValue;

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
