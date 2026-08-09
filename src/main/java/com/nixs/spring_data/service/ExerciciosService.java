package com.nixs.spring_data.service;

import com.nixs.spring_data.database.model.ExcerciciosEntity;
import com.nixs.spring_data.database.repository.IExerciciosRepository;
import com.nixs.spring_data.dto.ExercicioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciciosService {

    private final IExerciciosRepository exerciciosRepository;

    public List<ExcerciciosEntity> findAll (){
        return exerciciosRepository.findAll();
    }

    public void save(ExercicioDto exercicioDto) {
        ExcerciciosEntity exercicio = ExcerciciosEntity.builder()
                .nome(exercicioDto.getNome())
                .grupoMuscular(exercicioDto.getGrupoMuscular())
                .build();

        exerciciosRepository.save(exercicio);
    }
}
