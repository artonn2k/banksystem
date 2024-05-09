package org.linkplus.banksystem.account;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountEntity> createAccount(@RequestBody AccountEntity account) {

        AccountEntity createdAccount = accountService.create(account);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountEntity> findById(@PathVariable Long id) {

        AccountEntity foundAccount = accountService.findById(id);

        return ResponseEntity.ok(foundAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountEntity> updateAccount(@PathVariable Long id, @RequestBody AccountEntity account) {

        if (id == null || account == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(accountService.update(id, account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<String> withdrawFunds(@PathVariable Long id, @RequestParam Double amount) {
        try {
            accountService.withdraw(id, amount);
            return ResponseEntity.ok("Withdrawal successful");
        } catch (IllegalArgumentException iae) {
            return ResponseEntity.badRequest().body(iae.getMessage());
        }
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<String> depositFunds(@PathVariable Long id, @RequestParam Double amount) {
        try{
            accountService.deposit(id, amount);
            return ResponseEntity.ok("Deposit is successful");
        }catch (IllegalArgumentException iae){
            return ResponseEntity.badRequest().body(iae.getMessage());
        }
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<Double> getAccountBalance(@PathVariable Long id){

        Double balance = accountService.checkBalanceOfAccount(id);
        return ResponseEntity.ok(balance);
    }


}
