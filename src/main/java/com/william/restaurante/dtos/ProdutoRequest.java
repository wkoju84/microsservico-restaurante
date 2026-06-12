package com.william.restaurante.dtos;

import java.math.BigDecimal;

public record ProdutoRequest(
        Long categoriaId,
        String nome,
        String descricao,
        BigDecimal preco,
        Boolean disponivel,
        Integer tempoPreparoMinutos
) {
}
