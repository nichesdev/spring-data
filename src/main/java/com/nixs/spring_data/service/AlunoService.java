package com.nixs.spring_data.service;

import com.nixs.spring_data.database.repository.IAlunosRepository;
import com.nixs.spring_data.dto.AlunoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final IAlunosRepository alunosRepository;

    public void criarAluno(AlunoDto alunoDto){

    }
}
