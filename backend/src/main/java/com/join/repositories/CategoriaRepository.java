package com.join.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.join.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}