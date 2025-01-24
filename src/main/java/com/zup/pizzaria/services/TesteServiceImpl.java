package com.zup.pizzaria.services;

import org.springframework.stereotype.Service;

@Service
public class TesteServiceImpl implements TesteService {
    @Override
    public String criar() {
        return "criado";
    }

    @Override
    public String obterPorId(Long id) {
        return "retornado " + id;
    }
}
