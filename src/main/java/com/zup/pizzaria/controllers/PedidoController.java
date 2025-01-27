package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.PedidoRequestDTO;
import com.zup.pizzaria.dtos.PedidoResponseDTO;
import com.zup.pizzaria.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{id}")
    public ResponseEntity<PedidoResponseDTO> buscarPedidoPorId(@PathVariable Long id) {
        PedidoResponseDTO pedidoResponseDTO = pedidoService.buscarPedidoPorId(id);
        return ResponseEntity.ok(pedidoResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> listarTodosPedidos() {
        List<PedidoResponseDTO> pedidosResponseDTO = pedidoService.listarTodosPedidos();
        return ResponseEntity.ok(pedidosResponseDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<PedidoResponseDTO> atualizarDadosDoPedido(@PathVariable long id, @Valid @RequestBody PedidoRequestDTO pedidoRequestDTO) {
        PedidoResponseDTO pedidoResponseDTO = pedidoService.atualizarDadosDoPedido(id, pedidoRequestDTO);
        return ResponseEntity.ok().body(pedidoResponseDTO);
    }

}
