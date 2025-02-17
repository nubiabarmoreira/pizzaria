package com.zup.pizzaria.dtos;

import com.zup.pizzaria.enums.Status;

public class PedidoDTO {
    private String descricao;
    private Double valorTotal;
    private Status status;
    private Long clienteId;

    public PedidoDTO(String descricao, Double valorTotal, Status status, Long clienteId) {
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.status = status;
        this.clienteId = clienteId;
    }

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
