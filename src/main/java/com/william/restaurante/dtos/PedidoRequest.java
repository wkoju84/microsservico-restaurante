package com.william.restaurante.dtos;

public record PedidoRequest(
        Long mesaId,
        String observacao
) {
}
