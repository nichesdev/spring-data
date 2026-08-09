package com.nixs.spring_data.database.repository;

import com.nixs.spring_data.database.model.ExcerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IExerciciosRepository extends JpaRepository<ExcerciciosEntity, Integer> {

    List<ExcerciciosEntity> findAllByGrupoMuscular(String grupoMuscular);

    // Em JPQL
    @Query(value = """
        SELECT e
        FROM ExerciciosEntity e
        WHERE UPPER(e.grupoMuscular) = UPPER(:grupoMuscular)
""")
    List<ExcerciciosEntity> findAllByGrupoMusucularJpql(@Param("grupoMuscular") String grupoMuscular);

    // Em Native Query
    @NativeQuery(value = """
        SELECT e
        FROM exercicios e
        WHERE UPPER(e.grupo_muscular) = UPPER(:grupoMuscular)
""")
    List<ExcerciciosEntity> findAllByGrupoMusucularNative(@Param("grupoMuscular") String grupoMuscular);

}
