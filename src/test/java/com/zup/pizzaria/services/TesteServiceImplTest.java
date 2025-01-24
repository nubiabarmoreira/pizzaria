package com.zup.pizzaria.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TesteServiceImplTest {

    @Autowired
    private TesteServiceImpl testeService;

    @Test
    public void testCreated() {
        String result = testeService.criar();

        assertEquals("criado", result);
    }

    @Test
    public void testById() {
        String result = testeService.obterPorId(1L);

        assertEquals("retornado " + 1, result);
    }


}
