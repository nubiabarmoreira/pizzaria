package com.zup.pizzaria.repository;

import com.zup.pizzaria.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPedidoRepository extends JpaRepository<Pedido, Long> {
}
