package com.nixs.spring_data.service;

import com.nixs.spring_data.database.model.AlunosEntity;
import com.nixs.spring_data.database.model.TreinosEntity;
import com.nixs.spring_data.database.repository.IAlunosRepository;
import com.nixs.spring_data.database.repository.IExerciciosRepository;
import com.nixs.spring_data.database.repository.ITreinosRepository;
import com.nixs.spring_data.dto.TreinoDto;
import com.nixs.spring_data.exception.BadRequestException;
import com.nixs.spring_data.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TreinoService {
    private final IAlunosRepository alunosRepository;
    private final IExerciciosRepository exerciciosRepository;
    private final ITreinosRepository treinosRepository;

    public void criarTreino(TreinoDto treinoDto) throws NotFoundException {
        AlunosEntity aluno = alunosRepository.findByIdFetch(treinoDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Alunos não encontrado"));

        TreinosEntity treino = treinosRepository.findByIdNomeAndAlunoId(treinoDto.getNome(), treinoDto.getAlunoId())
                .orElse(null);
        if (treino != null) {
            throw new BadRequestException("Já existe um treino com este nome para esse aluno");

        }
    }
}
