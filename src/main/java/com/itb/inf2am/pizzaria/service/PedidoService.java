package com.itb.inf2am.pizzaria.services;

import com.itb.inf2am.pizzaria.model.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido criarPedido(Pedido pedido);

    List<Pedido> listarPedidosPorEmail(String emailSolicitante);

    Pedido buscarPedidoPorId(Long id);

    Pedido atualizarPedido(Pedido pedido, Long id);

    boolean deletarPedido(Long id);
}
