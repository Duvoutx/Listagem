package com.dustore.dustore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dustore.dustore.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String> {
    
}
