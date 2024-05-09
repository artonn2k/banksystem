package org.linkplus.banksystem.bank;

import org.linkplus.banksystem.account.AccountEntity;

import java.util.List;

public interface BankService {
    BankEntity create(BankEntity bank);

    BankEntity findById(Long id);

    BankEntity update(Long id, BankEntity bank);

    void delete(Long id);

    List<AccountEntity> getAllAccountsOfBank();
}
