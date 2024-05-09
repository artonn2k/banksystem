package org.linkplus.banksystem.transaction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Retention;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionEntity> createTransaction(@RequestBody TransactionEntity transaction) {

        TransactionEntity createdTransaction = transactionService.create(transaction);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionEntity> findById(@PathVariable Long id) {

        TransactionEntity foundTransaction = transactionService.findById(id);

        return ResponseEntity.ok(foundTransaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionEntity> updateTransaction(@PathVariable Long id, @RequestBody TransactionEntity transaction) {

        if (id == null || transaction == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(transactionService.update(id, transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id){
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
