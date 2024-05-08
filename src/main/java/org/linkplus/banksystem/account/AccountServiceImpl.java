package org.linkplus.banksystem.account;

import org.linkplus.banksystem.exceptions.AccountNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    private final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountEntity create(AccountEntity account) {
        logger.info("Account created");
        return accountRepository.save(account);
    }

    @Override
    public AccountEntity findById(Long id) {
        logger.info("Trying to find the account with id {}", id);
        return accountRepository.findById(id).orElseThrow(
                () -> new AccountNotFoundException("Account with this id "+id+" is not found!")
        );
    }

    @Override
    public AccountEntity update(Long id, AccountEntity account) {
        logger.info("Trying to find  and update the account with id {}", id);
        accountRepository.findById(id).orElseThrow(
                () -> new AccountNotFoundException("Account with this id "+id+" is not found!")
        );

        return accountRepository.save(account);
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
