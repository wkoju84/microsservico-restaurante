package com.william.restaurante.dtos;

import java.math.BigDecimal;

public record FechamentoContaRequest(
        BigDecimal taxaServico,
        BigDecimal desconto
) {
}
