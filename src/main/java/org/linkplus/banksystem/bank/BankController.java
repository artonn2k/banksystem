package org.linkplus.banksystem.bank;

import org.linkplus.banksystem.account.AccountEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banks")
public class BankController {

    private BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping
    public ResponseEntity<BankEntity> createBank(@RequestBody BankEntity bank){

        BankEntity createdBank = bankService.create(bank);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdBank);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankEntity> findById(@PathVariable Long id){

        BankEntity foundBank = bankService.findById(id);

        return ResponseEntity.ok(foundBank);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankEntity> updateBank(@PathVariable Long id, @RequestBody BankEntity bank){

        if (id == null || bank == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(bankService.update(id, bank));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        bankService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
