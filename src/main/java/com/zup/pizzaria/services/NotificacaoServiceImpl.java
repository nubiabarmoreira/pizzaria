package com.zup.pizzaria.services;

import org.springframework.stereotype.Service;

@Service
public class NotificacaoServiceImpl implements NotificacaoService {
    @Override
    public void notificar(Long idPedido, String contato) {
        System.out.println("Enviando notificação para o contato: " + contato);
        System.out.println("Notificação: Pedido numero: " + idPedido + " foi criado com sucesso.");
    }
}
