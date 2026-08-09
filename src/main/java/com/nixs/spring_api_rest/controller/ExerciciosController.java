package com.nixs.spring_api_rest.controller;


import com.nixs.spring_api_rest.database.model.ExcerciciosEntity;
import com.nixs.spring_api_rest.dto.ExercicioDto;
import com.nixs.spring_api_rest.service.ExerciciosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
@RequiredArgsConstructor
@Validated
public class ExerciciosController {

    private final ExerciciosService exerciciosService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExcerciciosEntity> findAll(){
        return exerciciosService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveExercicio(@Valid @RequestBody ExercicioDto exercicioDto){
        exerciciosService.save(exercicioDto);
    }

}
