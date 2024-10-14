package com.bruno.api_biblioteca.repositories;

import com.bruno.api_biblioteca.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Integer> {
}
