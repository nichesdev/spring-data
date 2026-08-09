package com.nixs.spring_data.controller;

import com.nixs.spring_data.dto.AvaliacaoFisicaDto;
import com.nixs.spring_data.exception.BadRequestException;
import com.nixs.spring_data.exception.NotFoundException;
import com.nixs.spring_data.service.AvaliacaofisicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/avaliacoes")
@RequiredArgsConstructor
@Validated
public class AvaliacoesFisicasController {

    private final AvaliacaofisicaService avaliacoesFisicasService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void  criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        avaliacoesFisicasService.criarAvaliacaoFisica(avaliacaoFisicaDto);
    }
}
