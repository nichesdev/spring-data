package com.nixs.spring_api_rest.controller;


import com.nixs.spring_api_rest.database.model.ProdutoModel;
import com.nixs.spring_api_rest.dto.ProdutoDto;
import com.nixs.spring_api_rest.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoModel> findAll() {
        return ProdutoService.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel createProduct(@RequestBody ProdutoDto produtoDto) {
        return produtoService.createProduct(produtoDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel updateProduct(@PathVariable Integer id,
                                      @RequestBody ProdutoDto produtoDto) {
        return produtoService.atualizarProduto(produtoDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) {
        produtoService.removerProduto(id);
    }

}
