package org.linkplus.banksystem.bank;

import org.linkplus.banksystem.account.AccountEntity;
import org.linkplus.banksystem.account.AccountRepository;
import org.linkplus.banksystem.account.AccountServiceImpl;
import org.linkplus.banksystem.exceptions.BankNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService{

    private BankRepository bankRepository;

    private AccountRepository accountRepository;

    private final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

    public BankServiceImpl(BankRepository bankRepository, AccountRepository accountRepository) {
        this.bankRepository = bankRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public BankEntity create(BankEntity bank) {
        logger.info("Bank created");
        return bankRepository.save(bank);
    }

    @Override
    public BankEntity findById(Long id) {
        logger.info("Trying to find the bank with id {}", id);
        return bankRepository.findById(id).orElseThrow(
                () -> new BankNotFoundException("Bank with this id "+id+" is not found!")
        );
    }

    @Override
    public BankEntity update(Long id, BankEntity bank) {
        logger.info("Trying to find  and update the bank with id {}", id);
        bankRepository.findById(id).orElseThrow(
                () -> new BankNotFoundException("Bank with this id "+id+" is not found!")
        );
        return bankRepository.save(bank);
    }

    @Override
    public void delete(Long id) {
        logger.info("Trying to delete bank with id {}", id);
        bankRepository.deleteById(id);
    }

    @Override
    public List<AccountEntity> getAllAccountsOfBank() {
        return accountRepository.findAll();
    }


}
