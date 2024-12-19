package com.join.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.join.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Page<Produto> findAllByCategoria_Id(Long categoriaId, Pageable pageable);
}