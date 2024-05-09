package org.linkplus.banksystem.transaction;

import org.linkplus.banksystem.account.AccountEntity;
import org.linkplus.banksystem.account.AccountService;
import org.linkplus.banksystem.exceptions.AccountNotFoundException;
import org.linkplus.banksystem.exceptions.TransactionNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    private TransactionRepository transactionRepository;
    private AccountService accountService;

    private final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
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

    @Override
    public TransactionEntity perform(Double amount, Long originatingAccountId,
                                     Long resultingAccountId, String transactionReason,
                                     String transactionType) {

        AccountEntity originatingAccount = accountService.findById(originatingAccountId);
        AccountEntity resultingAccount = accountService.findById(resultingAccountId);

        if (originatingAccount == null || resultingAccount == null) {
            throw new AccountNotFoundException("Originating or resulting account not found");
        }

        if (originatingAccount.getBalance() < amount) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough funds in the originating account");
        }

        Double feeAmount = calculateTransactionFee(amount);
        Double totalAmount = amount + feeAmount;

        originatingAccount.setBalance(originatingAccount.getBalance() - totalAmount);
        resultingAccount.setBalance(resultingAccount.getBalance() + amount);

        TransactionEntity transaction = new TransactionEntity();
        transaction.setAmount(amount);
        transaction.setOriginatingAccountId(originatingAccountId);
        transaction.setResultingAccountId(resultingAccountId);
        transaction.setTransactionReason(transactionReason);
        transaction.setTransactionType(transactionType);

        transaction = transactionRepository.save(transaction);

        accountService.update(originatingAccount.getId(), originatingAccount);
        accountService.update(resultingAccount.getId(), resultingAccount);

        return transaction;
    }




    private Double calculateTransactionFee(Double amount) {
        return 10.0;
    }

    @Override
    public List<TransactionEntity> findByAccountId(Long id) {
        // Implement the logic to retrieve transactions by account ID from the repository
        return transactionRepository.findByOriginatingAccountIdOrResultingAccountId(id, id);
    }
}
