package com.itb.inf2am.pizzaria.services;

import com.itb.inf2am.pizzaria.exceptions.NotFound;
import com.itb.inf2am.pizzaria.model.Pedido;
import com.itb.inf2am.pizzaria.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    @Transactional
    public Pedido criarPedido(Pedido pedido) {
        // Aqui você pode validar o pedido se quiser
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listarPedidosPorEmail(String emailSolicitante) {
        return pedidoRepository.findByEmailSolicitante(emailSolicitante);
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new NotFound("Pedido não encontrado com id " + id));
    }

    @Override
    @Transactional
    public Pedido atualizarPedido(Pedido pedido, Long id) {
        Pedido pedidoExistente = buscarPedidoPorId(id);
        pedidoExistente.setEmailSolicitante(pedido.getEmailSolicitante());
        pedidoExistente.setLivroId(pedido.getLivroId());
        pedidoExistente.setStatus(pedido.getStatus());
        return pedidoRepository.save(pedidoExistente);
    }

    @Override
    @Transactional
    public boolean deletarPedido(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        throw new NotFound("Pedido não encontrado com id " + id);
    }
}
