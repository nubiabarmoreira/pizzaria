package com.zup.pizzaria.repository;

import com.zup.pizzaria.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaClienteRepository extends JpaRepository<Cliente, Long> {
}
