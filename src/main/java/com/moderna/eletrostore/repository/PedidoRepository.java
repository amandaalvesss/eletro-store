package com.moderna.eletrostore.repository;

import com.moderna.eletrostore.model.Cliente;
import com.moderna.eletrostore.model.Pedido;
import com.moderna.eletrostore.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido,Long>{

    Optional<Pedido> findByClienteId (Long id);


}
