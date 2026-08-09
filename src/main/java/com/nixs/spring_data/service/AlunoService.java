package com.nixs.spring_data.service;

import com.nixs.spring_data.database.model.AlunosEntity;
import com.nixs.spring_data.database.model.AvaliacoesFisicasEntity;
import com.nixs.spring_data.database.model.TreinosEntity;
import com.nixs.spring_data.database.repository.IAlunosRepository;
import com.nixs.spring_data.database.repository.IAvaliacoesFisicasRepository;
import com.nixs.spring_data.database.repository.ITreinosRepository;
import com.nixs.spring_data.dto.AlunoDto;
import com.nixs.spring_data.exception.BadRequestException;
import com.nixs.spring_data.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;
    private final ITreinosRepository treinosRepository;
    private final IAlunosRepository alunosRepository;

    public void criarAluno(AlunoDto alunoDto) throws BadRequestException {
        AlunosEntity aluno = alunosRepository.findByEmail(alunoDto.getEmail())
                .orElse(null);
        if(aluno != null){
            throw new BadRequestException("Alunos já cadastrado com este Email.");
        }

        alunosRepository.save(AlunosEntity.builder()
                .nome(alunoDto.getNome())
                .email(alunoDto.getEmail())
                .build());
    }
    public AvaliacoesFisicasEntity getAlunoAvaliacao (Integer alunoId) throws NotFoundException {
        AlunosEntity aluno = alunosRepository.findByIdFetch(alunoId)
                .orElseThrow(() -> new NotFoundException("Alunos não encontrado"));

        AvaliacoesFisicasEntity avaliacao = aluno.getAvaliacoesFisica();
        if (avaliacao == null){
            throw new NotFoundException("Avaliação Fisica não encontrada para este aluno");
        }
        return avaliacao;
    }
    @Transactional
    public void deletarAluno(Integer alunoId) throws NotFoundException {

        // Transação Begin
        AlunosEntity aluno = alunosRepository.findByIdFetch(alunoId)
                .orElseThrow(() -> new NotFoundException("Alunos não encontrado"));

        // Deletar todos treinos
        List<Integer> treinosAlunoIds = aluno.getTreinos().stream()
                .map(TreinosEntity::getId)
                .toList();

        treinosRepository.deleteAllById(treinosAlunoIds);
        // Deletar o aluno
        alunosRepository.deleteById(alunoId);
        // Deletar avaliacao fisica
        avaliacoesFisicasRepository.deleteById(aluno.getAvaliacoesFisica().getId());

        // Transação Commit (Transactional garante que todos deletes sejam feitos de uma vez)
    }
}
