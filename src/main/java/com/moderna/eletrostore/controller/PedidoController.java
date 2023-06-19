package com.moderna.eletrostore.controller;

import com.moderna.eletrostore.model.Cliente;
import com.moderna.eletrostore.model.Pedido;
import com.moderna.eletrostore.repository.ClienteRepository;
import com.moderna.eletrostore.repository.PedidoRepository;
import com.moderna.eletrostore.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping ("/pedidos")
public class PedidoController {

    private PedidoRepository pedidoRepository;
    private PedidoService pedidoService;
    private ClienteRepository clienteRepository;

    @PostMapping("salvar")
    public ResponseEntity<Pedido> salvar(@RequestBody Pedido pedido) throws Exception {
        try {
            return new ResponseEntity<>(pedidoService.salvar(pedido), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/listar")
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return new ResponseEntity<> (pedidoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/listarPorCliente/{id}")
    public Optional<Pedido> listarCliente (@PathVariable Long id){
        return pedidoRepository.findByClienteId(id);
    }


}
