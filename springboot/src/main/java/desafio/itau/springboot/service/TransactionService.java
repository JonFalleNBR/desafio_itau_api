package desafio.itau.springboot.service;


import desafio.itau.springboot.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransactionService {

    private final Queue<Transaction> transactions = new ConcurrentLinkedDeque<>();


    // Adiciona uma nova transação
    public void addTransaction(Transaction transaction){

        transactions.add(transaction);

    }

    // Exclui transações
    public void clearTransaction(){
        transactions.clear();
    }

    // Metodo que pega as estatisticas do valor das transações feitas nos ultimos 60 segundos
    public DoubleSummaryStatistics getStatistics(){
        OffsetDateTime now = OffsetDateTime.now();
        return transactions.stream()
                //.filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction :: getValor)
                .summaryStatistics();
    }

}
