package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente (@RequestBody ClienteDTO requestDTO){
        ClienteDTO responseDTO = clienteService.criarCliente(requestDTO.getNome(), requestDTO.getEmail());
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public List<ClienteDTO> listarTodosClientes() {
        return clienteService.listarTodosClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarClientePorId (Long id) {
        ClienteDTO clienteDTO = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok(clienteDTO);
    }
}
