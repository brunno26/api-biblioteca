package com.bruno.api_biblioteca.repositories;

import com.bruno.api_biblioteca.models.EmprestimoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<EmprestimoModel, Integer> {

}
