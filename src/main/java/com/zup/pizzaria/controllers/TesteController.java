package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.TesteResponseDTO;
import com.zup.pizzaria.exceptions.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Operation(summary = "Endpoint para testar exemplos de como personalizar a documentação swagger.")
    @ApiResponses(value = @ApiResponse(
            responseCode = "201",
            description = " Recurso salvo com sucesso.",
            content = @Content(schema = @Schema(implementation = TesteResponseDTO.class))))
    @GetMapping()
    ResponseEntity<String> create() {
        URI location = URI.create("/teste");
        return ResponseEntity.created(location).body("Criado");
    }

    @Operation(summary = "Endpoint para buscar um recurso pelo id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recurso encontrado.", content = @Content(schema = @Schema(implementation = TesteResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{id}")
    ResponseEntity<String> testByPath(@PathVariable @Parameter(
            required = true,
            description = "id para teste") Long id) {

        return ResponseEntity.ok().body("Criado");
    }
}
