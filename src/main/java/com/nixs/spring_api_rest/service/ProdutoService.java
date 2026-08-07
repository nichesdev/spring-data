package com.nixs.spring_api_rest.service;

import com.nixs.spring_api_rest.database.model.ProdutoModel;
import com.nixs.spring_api_rest.dto.ProdutoDto;
import com.nixs.spring_api_rest.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static final List<ProdutoModel> PRODUTOS = new ArrayList<>();

    static {
        PRODUTOS.add(ProdutoModel.builder()
                .id(1)
                .nome("Notebook")
                .preco(new BigDecimal(5500))
                .quantidade(10)
                .build());

        PRODUTOS.add(ProdutoModel.builder()
                .id(2)
                .nome("Iphone")
                .preco(new BigDecimal(7000))
                .quantidade(10)
                .build());

        PRODUTOS.add(ProdutoModel.builder()
                .id(3)
                .nome("Notebook")
                .preco(new BigDecimal(5500))
                .quantidade(10)
                .build());
    }

    public static List<ProdutoModel> findAll() {
        return new ArrayList<>(PRODUTOS);
    }

    public ProdutoModel createProduct (ProdutoDto produtoDto) {
        Integer identificador = PRODUTOS.stream()
                .mapToInt(ProdutoModel::getId)
                .max()
                .orElse(0) + 1;

        ProdutoModel novoProduto = ProdutoModel.builder()
                .id(identificador)
                .nome(produtoDto.getNome())
                .preco(produtoDto.getPreco())
                .quantidade(produtoDto.getQuantidade())
                .build();

        PRODUTOS.add(novoProduto);

        return novoProduto;
    }

    public ProdutoModel atualizarProduto (ProdutoDto produtoDto, Integer id) throws NotFoundException {
        ProdutoModel produto = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        produto.setNome(produtoDto.getNome());
        produto.setPreco(produtoDto.getPreco());
        produto.setQuantidade(produtoDto.getQuantidade());

        return produto;
    }

    public void removerProduto (Integer id) {
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }

}
