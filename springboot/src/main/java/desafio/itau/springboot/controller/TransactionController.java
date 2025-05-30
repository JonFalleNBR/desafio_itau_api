package desafio.itau.springboot.controller;


import desafio.itau.springboot.dto.TransactionDTO;
import desafio.itau.springboot.model.Transaction;
import desafio.itau.springboot.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionDTO requestDto){
        if(requestDto.getDataHora().isAfter(OffsetDateTime.now()) || requestDto.getValor() <= 0){
                return ResponseEntity.unprocessableEntity().build();
        }
        transactionService.addTransaction(new Transaction(requestDto.getValor(), requestDto.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


    @DeleteMapping
    public ResponseEntity<Void> clearTransactions(){
        transactionService.clearTransaction();
        return ResponseEntity.ok().build();


    }
}
