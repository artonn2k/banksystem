package org.linkplus.banksystem.transaction;

import org.linkplus.banksystem.exceptions.AccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Retention;
import java.util.List;

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

    @PostMapping("/perform")
    public ResponseEntity<TransactionEntity> performTransaction(@RequestParam Double amount,
                                                                @RequestParam Long originatingAccountId,
                                                                @RequestParam Long resultingAccountId,
                                                                @RequestParam String transactionReason,
                                                                @RequestParam String transactionType){
        try{

            TransactionEntity createdTransaction = transactionService.perform(amount, originatingAccountId, resultingAccountId, transactionReason, transactionType);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @GetMapping("/accounts/{id}/transactions")
    public ResponseEntity<List<TransactionEntity>> getAccountTransactions(@PathVariable Long id){
        try{
            List<TransactionEntity> transactions = transactionService.findByAccountId(id);
            return ResponseEntity.ok(transactions);
        }catch (AccountNotFoundException anfe){
            return ResponseEntity.notFound().build();
        }
        //http://localhost:8085/transactions/accounts/16/transactions
    }

}
