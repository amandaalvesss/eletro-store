package com.moderna.eletrostore.repository;

import com.moderna.eletrostore.model.Categoria;
import com.moderna.eletrostore.model.Cliente;
import com.moderna.eletrostore.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long>  {
    Optional <List<Categoria>> findByNome (String nome);
}
