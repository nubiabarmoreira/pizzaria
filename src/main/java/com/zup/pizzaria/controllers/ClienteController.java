package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.dtos.ClienteRequestDTO;
import com.zup.pizzaria.dtos.ClienteResponseDTO;
import com.zup.pizzaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criarCliente (@RequestBody ClienteRequestDTO requestDTO){
        ClienteResponseDTO responseDTO = clienteService.criarCliente(requestDTO.getNome(), requestDTO.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public List<ClienteResponseDTO> listarTodosClientes() {
        return clienteService.listarTodosClientes();
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteDTO> buscarClientePorId (Long id) {
        ClienteDTO clienteDTO = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok(clienteDTO);
    }
}
