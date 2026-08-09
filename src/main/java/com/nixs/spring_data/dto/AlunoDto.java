package com.nixs.spring_data.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AlunoDto {

    @NotBlank //Nula nem vazia
    private String nome;
    @NotBlank
    private String email;
}

