package com.itb.inf2am.pizzaria.service;

import com.itb.inf2am.pizzaria.exceptions.NotFound;
import com.itb.inf2am.pizzaria.model.Pedido;
import com.itb.inf2am.pizzaria.repository.PedidoRepository;
import com.itb.inf2am.pizzaria.service.PedidoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        // Define a data do pedido como agora
        pedido.setDataPedido(LocalDateTime.now());

        // Define o status padrão se não estiver setado
        if (pedido.getStatusPedido() == null || pedido.getStatusPedido().isEmpty()) {
            pedido.setStatusPedido("Pendente");
        }

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
        Pedido existente = buscarPedidoPorId(id);

        existente.setTituloLivro(pedido.getTituloLivro());
        existente.setAutorLivro(pedido.getAutorLivro());
        existente.setGeneroLivro(pedido.getGeneroLivro());
        existente.setDescricaoLivro(pedido.getDescricaoLivro());
        existente.setImagemLivro(pedido.getImagemLivro());
        existente.setEmailSolicitante(pedido.getEmailSolicitante());
        existente.setStatusPedido(pedido.getStatusPedido());

        return pedidoRepository.save(existente);
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
