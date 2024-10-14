package com.bruno.api_biblioteca.repositories;

import com.bruno.api_biblioteca.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
}
