package com.nixs.spring_data.database.repository;

import com.nixs.spring_data.database.model.ExcerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IExerciciosRepository extends JpaRepository<ExcerciciosEntity, Integer> {

    List<ExcerciciosEntity> findAllByGrupoMuscular(String grupoMuscular);

}
