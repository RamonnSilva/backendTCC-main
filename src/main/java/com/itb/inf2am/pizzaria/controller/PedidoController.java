package com.itb.inf2am.pizzaria.controller;

import com.itb.inf2am.pizzaria.model.Pedido;
import com.itb.inf2am.pizzaria.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // Criar novo pedido
    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido criado = pedidoService.criarPedido(pedido);
        return new ResponseEntity<>(criado, HttpStatus.CREATED);
    }

    // Listar pedidos pelo email do solicitante (query param)
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidosPorEmail(@RequestParam String email) {
        List<Pedido> pedidos = pedidoService.listarPedidosPorEmail(email);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    // Buscar pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable Long id) {
        Pedido pedido = pedidoService.buscarPedidoPorId(id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    // Atualizar pedido
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Pedido atualizado = pedidoService.atualizarPedido(pedido, id);
        return new ResponseEntity<>(atualizado, HttpStatus.OK);
    }

    // Deletar pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
