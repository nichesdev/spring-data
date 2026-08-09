package com.nixs.spring_data.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name= "avaliacoes_fisicas")
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacoesFisicasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false)
    private BigDecimal peso;
    @Column(nullable = false)
    private BigDecimal altura;
    @Column(name = "porcentagem_gordura_corporal", nullable = false )
    private BigDecimal porcentagemGorduraCorporal;
}
