package com.nixs.spring_data.controller;


import com.nixs.spring_data.database.model.AvaliacoesFisicasEntity;
import com.nixs.spring_data.dto.AlunoDto;
import com.nixs.spring_data.exception.BadRequestException;
import com.nixs.spring_data.exception.NotFoundException;
import com.nixs.spring_data.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/alunos")
@RequiredArgsConstructor
@Validated
public class AlunosController {

    private final AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDto alunoDto) throws BadRequestException {
        alunoService.criarAluno(alunoDto);
    }

    @GetMapping("/{alunoId}/avaliacao")
    public AvaliacoesFisicasEntity getAvaliacaoFisica(@PathVariable Integer alunoId) throws NotFoundException {
        return alunoService.getAlunoAvaliacao(alunoId);
    }
}

