package com.dustore.dustore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dustore.dustore.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
	Cliente findByCpf(String cpf); 
}