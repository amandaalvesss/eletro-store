package com.moderna.eletrostore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn (name ="cliente_id")
    private Cliente cliente;

    private Double valorTotal;

    private LocalDateTime dataPedido;

    @OneToMany (cascade = CascadeType.MERGE)
    @JoinColumn (name= "produto_id")
    private List<Produto> produtos;
}
