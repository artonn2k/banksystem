package org.linkplus.banksystem.transaction;

public interface TransactionService {
    TransactionEntity create(TransactionEntity transaction);

    TransactionEntity findById(Long id);

    TransactionEntity update(Long id, TransactionEntity transaction);

    void delete(Long id);
}
