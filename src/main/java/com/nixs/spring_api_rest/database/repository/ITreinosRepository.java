package com.nixs.spring_api_rest.database.repository;

import com.nixs.spring_api_rest.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITreinosRepository extends JpaRepository<TreinosEntity, Integer> {
}
