package com.zup.pizzaria.repositories;

import com.zup.pizzaria.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPedidoRepository extends JpaRepository<Pedido, Long> {
}
