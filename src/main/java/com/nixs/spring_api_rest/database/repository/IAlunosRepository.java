package com.nixs.spring_api_rest.database.repository;

import com.nixs.spring_api_rest.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlunosRepository extends JpaRepository<AlunosEntity, Integer> {
}
