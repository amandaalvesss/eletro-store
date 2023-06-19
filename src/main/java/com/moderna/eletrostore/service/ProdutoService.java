package com.moderna.eletrostore.service;

import com.moderna.eletrostore.model.Categoria;
import com.moderna.eletrostore.model.Cliente;
import com.moderna.eletrostore.model.Produto;
import com.moderna.eletrostore.repository.CategoriaRepository;
import com.moderna.eletrostore.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {

    CategoriaRepository categoriaRepository;
    ProdutoRepository produtoRepository;

//    public List<Produto> listarCategoria(String nome) throws Exception {
//        Optional<List<Categoria>> categoriaSalva = categoriaRepository.findByNome(nome);
//        if (categoriaSalva.isPresent()) {
//           return produtoRepository.findByCategoria(categoriaSalva);
//        }else {
//            throw new Exception("Categoria não existe no banco de dados");
//        }
//        return null;
//    }



}
