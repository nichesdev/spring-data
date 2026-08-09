package com.nixs.spring_data.service;

import com.nixs.spring_data.database.model.AlunosEntity;
import com.nixs.spring_data.database.model.ExcerciciosEntity;
import com.nixs.spring_data.database.model.TreinosEntity;
import com.nixs.spring_data.database.repository.IAlunosRepository;
import com.nixs.spring_data.database.repository.IExerciciosRepository;
import com.nixs.spring_data.database.repository.ITreinosRepository;
import com.nixs.spring_data.dto.TreinoDto;
import com.nixs.spring_data.exception.BadRequestException;
import com.nixs.spring_data.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinoService {
    private final IAlunosRepository alunosRepository;
    private final IExerciciosRepository exerciciosRepository;
    private final ITreinosRepository treinosRepository;

    public void criarTreino(TreinoDto treinoDto) throws NotFoundException, BadRequestException {
        Set<ExcerciciosEntity> exercicios = new HashSet<>();
        AlunosEntity aluno = alunosRepository.findByIdFetch(treinoDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Alunos não encontrado"));

        TreinosEntity treino = treinosRepository.findByNomeAndAlunoId(treinoDto.getNome(), treinoDto.getAlunoId())
                .orElse(null);
        if (treino != null) {
            throw new BadRequestException("Já existe um treino com este nome para esse aluno");
        }

        for (Integer exercicioId : treinoDto.getExerciciosIds()) {
            ExcerciciosEntity exercicio = exerciciosRepository.findById(exercicioId)
                    .orElseThrow(() -> new NotFoundException(String.format("Exercicio %s não encontrado", exercicioId)));

            exercicios.add(exercicio);
        }

        treino = TreinosEntity.builder()
                .nome(treinoDto.getNome())
                .aluno(aluno)
                .exercicios(exercicios)
                .build();

        treinosRepository.save(treino);
    }
}
