package com.moderna.eletrostore.service;

import com.moderna.eletrostore.model.Cliente;
import com.moderna.eletrostore.model.Pedido;
import com.moderna.eletrostore.model.Produto;
import com.moderna.eletrostore.repository.ClienteRepository;
import com.moderna.eletrostore.repository.PedidoRepository;
import com.moderna.eletrostore.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedidoService {

    PedidoRepository pedidoRepository;
    ClienteRepository clienteRepository;
    ProdutoRepository produtoRepository;

    public Pedido salvar(Pedido pedido) throws Exception {
        Optional<Cliente> clienteCadastrado = clienteRepository.findById(pedido.getCliente().getId());
       LocalDateTime dataPedido = LocalDateTime.now();
       pedido.setDataPedido(dataPedido);

        if (clienteCadastrado.isPresent()) {
            return pedidoRepository.save(pedido);
        } else {
            throw new Exception("Cliente não cadastrado para realizar pedido");
        }

    }




}







