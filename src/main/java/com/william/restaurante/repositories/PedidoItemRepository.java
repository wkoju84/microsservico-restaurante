package com.william.restaurante.repositories;

import com.william.restaurante.domain.entities.PedidoItem;
import com.william.restaurante.domain.enums.StatusItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
    List<PedidoItem> findByPedidoId(Long pedidoId);

    List<PedidoItem> findByStatusOrderByIdAsc(StatusItemPedido status);

    List<PedidoItem> findByPedidoIdAndStatusNot(Long pedidoId, StatusItemPedido status);
}
