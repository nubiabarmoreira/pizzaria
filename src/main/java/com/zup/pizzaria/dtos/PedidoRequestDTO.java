package com.zup.pizzaria.dtos;

import com.zup.pizzaria.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PedidoRequestDTO {
    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @NotNull(message = "Valor total é obrigatório")
    @Positive(message = "Valor total deve ser maior que zero")
    private Double valorTotal;

    @NotNull(message = "Status é obrigatório")
    private Status status;

    @NotNull(message = "Cliente ID é obrigatório")
    private Long clienteId;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
