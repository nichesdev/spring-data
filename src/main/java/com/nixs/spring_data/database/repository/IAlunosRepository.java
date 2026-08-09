package com.nixs.spring_data.database.repository;

import com.nixs.spring_data.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IAlunosRepository extends JpaRepository<AlunosEntity, Integer> {
    Optional<AlunosEntity> findByEmail(String email);

    @Query(value = "SELECT a FROM AlunosEntity a JOIN FETCH a.avaliacoesFisica WHERE a.id = :alunoId")
    Optional<AlunosEntity> findByIdFetch(@Param("alunoId") Integer id);

}
