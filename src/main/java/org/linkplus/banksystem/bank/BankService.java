package org.linkplus.banksystem.bank;

public interface BankService {
    BankEntity create(BankEntity bank);

    BankEntity findById(Long id);

    BankEntity update(Long id, BankEntity bank);

    void delete(Long id);
}
