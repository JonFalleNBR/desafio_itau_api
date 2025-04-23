package desafio.itau.springboot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class TransactionDTO {

    // Esse pacote guarda as mesmas variaveis do model, porem, uma vez que existe o spring validation , aqui ele irá definir os valores nulos ou zeros a partir da anotação

    @NotNull
    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;



    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
