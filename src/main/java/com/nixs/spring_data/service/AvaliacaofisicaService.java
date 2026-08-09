package com.nixs.spring_data.service;


import com.nixs.spring_data.database.model.AlunosEntity;
import com.nixs.spring_data.database.model.AvaliacoesFisicasEntity;
import com.nixs.spring_data.database.repository.IAlunosRepository;
import com.nixs.spring_data.database.repository.IAvaliacoesFisicasRepository;
import com.nixs.spring_data.dto.AvaliacaoFisicaDto;
import com.nixs.spring_data.dto.AvaliacoesFisicasProjection;
import com.nixs.spring_data.exception.BadRequestException;
import com.nixs.spring_data.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaofisicaService {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;

    public void criarAvaliacaoFisica(AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Alunos não encontrado"));

        AvaliacoesFisicasEntity avaliacoesFisica = aluno.getAvaliacoesFisica();
        if (avaliacoesFisica != null) {
            throw new BadRequestException("Avaliação Fisica já criada para este aluno!");
        }

        avaliacoesFisica = AvaliacoesFisicasEntity.builder()
                .peso(avaliacaoFisicaDto.getPeso())
                .altura(avaliacaoFisicaDto.getAltura())
                .porcentagemGorduraCorporal(avaliacaoFisicaDto.getPercentualGorduraCorporal())
                .build();

        aluno.setAvaliacoesFisica(avaliacoesFisica);
        alunosRepository.save(aluno);
    }

    public List<AvaliacoesFisicasProjection> getAllAvaliacoes(){
        return avaliacoesFisicasRepository.getAllAvaliacoes();
    }
}
