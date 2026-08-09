package com.nixs.spring_data.database.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "exercicios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExcerciciosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(name ="grupo_muscular", nullable = false)
    private String grupoMuscular;
}
