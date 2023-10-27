package com.dustore.dustore.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dustore.dustore.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
