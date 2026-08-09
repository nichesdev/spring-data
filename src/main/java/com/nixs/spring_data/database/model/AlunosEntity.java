package com.nixs.spring_data.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "alunos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AlunosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "avaliacao_fisica_id")
    private AvaliacoesFisicasEntity avaliacoesFisica;

    @OneToMany(mappedBy = "alunos")
    private Set<TreinosEntity> treinos = new HashSet<>();
}
