package org.linkplus.banksystem.transaction;

import java.util.List;

public interface TransactionService {
    TransactionEntity create(TransactionEntity transaction);

    TransactionEntity findById(Long id);

    TransactionEntity update(Long id, TransactionEntity transaction);

    void delete(Long id);

    TransactionEntity perform(Double amount, Long originatingAccountId, Long resultingAccountId, String transactionReason, String transactionType);

    List<TransactionEntity> findByAccountId(Long id);
}
