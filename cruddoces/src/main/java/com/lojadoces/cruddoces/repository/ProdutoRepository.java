package com.lojadoces.cruddoces.repository;

import com.lojadoces.cruddoces.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}