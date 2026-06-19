package com.william.restaurante.dtos;

public record PedidoItemRequest(
        Long produtoId,
        Integer quantidade,
        String observacao
) {
}
