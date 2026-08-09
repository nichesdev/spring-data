package com.nixs.spring_data.database.repository;

import com.nixs.spring_data.database.model.ExcerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExerciciosRepository extends JpaRepository<ExcerciciosEntity, Integer> {
}
