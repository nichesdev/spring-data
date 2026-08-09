package com.nixs.spring_data.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AvaliacaoFisicaDto {

    @NotNull
    private Integer alunoId;
    @NotNull
    private BigDecimal Peso;
    @NotNull
    private BigDecimal altura;
    @NotNull
    private BigDecimal percentualGorduraCorporal;
}
