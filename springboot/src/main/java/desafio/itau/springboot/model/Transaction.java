package desafio.itau.springboot.model;

import java.time.OffsetDateTime;

public class Transaction {

    private double valor ;
    private OffsetDateTime dataHora;
    // Não se faz necessario os sets no encapsulamento dos atributos, uma vez que ja serão passados e manipulados no Construtor
    public Transaction(final double valor, final OffsetDateTime dataHora){

        this.valor = valor;
        this.dataHora = dataHora;

    }

    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
