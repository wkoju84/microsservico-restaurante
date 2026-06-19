package com.william.restaurante.services;

import com.william.restaurante.domain.entities.Mesa;
import com.william.restaurante.domain.entities.Pedido;
import com.william.restaurante.domain.enums.StatusMesa;
import com.william.restaurante.domain.enums.StatusPedido;
import com.william.restaurante.dtos.PedidoRequest;
import com.william.restaurante.dtos.PedidoResponse;
import com.william.restaurante.exceptions.RegraNegocioException;
import com.william.restaurante.repositories.MesaRepository;
import com.william.restaurante.repositories.PedidoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final MesaRepository mesaRepository;

    public PedidoService(PedidoRepository pedidoRepository, MesaRepository mesaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.mesaRepository = mesaRepository;
    }

    public PedidoResponse abrirPedido(PedidoRequest pedidoRequest){
        Mesa mesa = mesaRepository.findById(pedidoRequest.mesaId())
                .orElseThrow(() -> new RegraNegocioException(
                        "Mesa inexistente"
                ));

        if (mesa.getStatus() != StatusMesa.LIVRE){
            throw new RegraNegocioException("Mesa Indisponível");
        }

        Pedido pedido = new Pedido();
        pedido.setMesa(mesa);
        pedido.setStatus(StatusPedido.ABERTO);
        pedido.setObservacao(pedidoRequest.observacao());

        mesa.setStatus(StatusMesa.OCUPADA);

        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        mesaRepository.save(mesa);

        return PedidoResponse.fromEntity(pedidoSalvo);
    }

    public Page<PedidoResponse> listar(Pageable pageable){
        return pedidoRepository.findAll(pageable).map(PedidoResponse::fromEntity);
    }

    public PedidoResponse buscarPorId(Long id){
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RegraNegocioException(
                "Pedido não encontrado!"
        ));
        return PedidoResponse.fromEntity(pedido);
    }
}
