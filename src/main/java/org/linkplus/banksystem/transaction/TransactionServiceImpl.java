package org.linkplus.banksystem.transaction;

import org.linkplus.banksystem.exceptions.TransactionNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService{

    private TransactionRepository transactionRepository;

    private final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionEntity create(TransactionEntity transaction) {
        logger.info("Transaction created");
        return transactionRepository.save(transaction);
    }

    @Override
    public TransactionEntity findById(Long id) {
        logger.info("Trying to find the transaction with id {}", id);
        return transactionRepository.findById(id).orElseThrow(
                () -> new TransactionNotFoundException("Transaction with this id " +id+ " is not found")
        );
    }

    @Override
    public TransactionEntity update(Long id, TransactionEntity transaction) {
        logger.info("Trying to find  and update the transaction with id {}", id);

        transactionRepository.findById(id).orElseThrow(
                () -> new TransactionNotFoundException("Transaction with this id " +id+ " is not found")
        );

        return transactionRepository.save(transaction);
    }

    @Override
    public void delete(Long id) {
        logger.info("Trying to delete transaction with id {}", id);
        transactionRepository.deleteById(id);
    }
}
