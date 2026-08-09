package com.nixs.spring_api_rest.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ExercicioDto {

    @NotBlank //Nula nem vazia
    private String nome;
    private String grupoMuscular;
}

