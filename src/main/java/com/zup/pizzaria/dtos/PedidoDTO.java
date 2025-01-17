package com.zup.pizzaria.dtos;

public class PedidoDTO {
    private String descricao;
    private Long clienteId;

    public PedidoDTO(Long clienteId, String descricao) {
        this.clienteId = clienteId;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
