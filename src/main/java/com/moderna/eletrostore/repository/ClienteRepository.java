package com.moderna.eletrostore.repository;

import com.moderna.eletrostore.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente,Long> {

  Optional<Cliente> findByDocumento (String documento);

  void deleteByDocumento (String documentoIdentificado);

    Optional<Cliente> findById(Long id);


  }
