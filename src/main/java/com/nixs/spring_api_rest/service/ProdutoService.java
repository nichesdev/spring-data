package com.nixs.spring_api_rest.service;

import com.nixs.spring_api_rest.database.model.ProdutoModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static final List<ProdutoModel> PRODUTOS = List.of(
            ProdutoModel.builder()
                    .id(1)
                    .nome("Notebook")
                    .preco(new BigDecimal(5500))
                    .quantidade(10)
                    .build(),
            ProdutoModel.builder()
                    .id(2)
                    .nome("Iphone")
                    .preco(new BigDecimal(7000))
                    .quantidade(10)
                    .build(),
            ProdutoModel.builder()
                    .id(3)
                    .nome("Teclado")
                    .preco(new BigDecimal(500))
                    .quantidade(10)
                    .build()
    );

    public static List<ProdutoModel> findAll() {
        return new ArrayList<>(PRODUTOS);
    }

    

}
