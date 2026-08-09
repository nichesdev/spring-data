package com.nixs.spring_api_rest.database.repository;

import com.nixs.spring_api_rest.database.model.ExcerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExerciciosRepository extends JpaRepository<ExcerciciosEntity, Integer> {
}
