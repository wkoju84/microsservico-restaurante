package com.william.restaurante.controllers;

import com.william.restaurante.dtos.FechamentoContaRequest;
import com.william.restaurante.dtos.FechamentoContaResponse;
import com.william.restaurante.services.FechamentoContaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos/{pedidoId}/fechamento")
public class FechamentoContaController {

    private final FechamentoContaService fechamentoContaService;

    public FechamentoContaController(FechamentoContaService fechamentoContaService) {
        this.fechamentoContaService = fechamentoContaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FechamentoContaResponse fecharConta(@PathVariable Long pedidoId,
                                               @RequestBody FechamentoContaRequest request){
        return fechamentoContaService.fecharConta(pedidoId, request);
    }

    @GetMapping
    public FechamentoContaResponse fecharConta(@PathVariable Long pedidoId){
        return fechamentoContaService.buscarPorPedido(pedidoId);
    }
}
