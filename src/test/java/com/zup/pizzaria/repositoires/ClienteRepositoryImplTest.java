package com.zup.pizzaria.repositoires;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.repositories.ClienteRepositoryImpl;
import com.zup.pizzaria.repositories.JpaClienteRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(ClienteRepositoryImpl.class)
public class ClienteRepositoryImplTest {

    @Autowired
    private JpaClienteRepository jpaClienteRepository;

    @Autowired
    private ClienteRepositoryImpl clienteRepository;

    @Test
    public void testSaveCliente() {
        // Arrange
        ClienteDTO clienteDTO = new ClienteDTO(null, "João Silva", "joao.silva@email.com");

        // Act
        ClienteDTO clienteSalvo = clienteRepository.save(clienteDTO);

        // Assert
        assertNotNull(clienteSalvo.getId());
        assertEquals("João Silva", clienteSalvo.getNome());
        assertEquals("joao.silva@email.com", clienteSalvo.getEmail());
    }

    @Test
    public void testFindByIdCliente() {
        // Arrange
        Cliente cliente = new Cliente("Maria Oliveira", "maria.oliveira@email.com");
        Cliente clienteSalvo = jpaClienteRepository.save(cliente);

        // Act
        ClienteDTO clienteEncontrado = clienteRepository.findById(clienteSalvo.getId());

        // Assert
        assertNotNull(clienteEncontrado);
        assertEquals(clienteSalvo.getId(), clienteEncontrado.getId());
        assertEquals("Maria Oliveira", clienteEncontrado.getNome());
        assertEquals("maria.oliveira@email.com", clienteEncontrado.getEmail());
    }

    @Test
    public void testFindByIdClienteNotFound() {
        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            clienteRepository.findById(999L); // ID inexistente
        });

        assertEquals("Cliente não encontrado", exception.getMessage());
    }
}