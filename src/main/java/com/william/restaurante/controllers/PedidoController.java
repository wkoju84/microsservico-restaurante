package com.william.restaurante.controllers;

import com.william.restaurante.dtos.PedidoRequest;
import com.william.restaurante.dtos.PedidoResponse;
import com.william.restaurante.services.PedidoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoResponse abrirPedido(@RequestBody PedidoRequest pedidoRequest){
        return pedidoService.abrirPedido(pedidoRequest);
    }

    @GetMapping
    public Page<PedidoResponse> listar(Pageable pageable){
        return pedidoService.listar(pageable);
    }

    @GetMapping("/{id}")
    public PedidoResponse buscarPorId(@PathVariable Long id){
        return pedidoService.buscarPorId(id);
    }
}
