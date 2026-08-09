package com.nixs.spring_data.service;

import com.nixs.spring_data.database.model.AlunosEntity;
import com.nixs.spring_data.database.repository.IAlunosRepository;
import com.nixs.spring_data.dto.AlunoDto;
import com.nixs.spring_data.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {
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
}
