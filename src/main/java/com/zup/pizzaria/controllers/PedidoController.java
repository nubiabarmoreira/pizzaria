package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.PedidoRequestDTO;
import com.zup.pizzaria.dtos.PedidoResponseDTO;
import com.zup.pizzaria.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criarPedido(@RequestBody PedidoRequestDTO requestDTO) {
        PedidoResponseDTO pedidoResponseDTO = pedidoService.criarPedido(requestDTO);
        return ResponseEntity.ok(pedidoResponseDTO);
    }

}
