package org.linkplus.banksystem.account;

public interface AccountService {
    AccountEntity create(AccountEntity account);

    AccountEntity findById(Long id);

    AccountEntity update(Long id, AccountEntity account);

    void delete(Long id);
}
