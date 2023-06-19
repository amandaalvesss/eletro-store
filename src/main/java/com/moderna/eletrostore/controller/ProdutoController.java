package com.moderna.eletrostore.controller;

import com.moderna.eletrostore.model.Categoria;
import com.moderna.eletrostore.model.Cliente;
import com.moderna.eletrostore.model.Produto;
import com.moderna.eletrostore.repository.CategoriaRepository;
import com.moderna.eletrostore.repository.ProdutoRepository;
import com.moderna.eletrostore.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;
    ProdutoService produtoService;

    @PostMapping("salvar")
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoRepository.save(produto), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping ("/listarPorCategoria")
    public List<Produto> listarPorCategoria(@RequestBody Categoria categoria){
        return produtoRepository.findByCategoria(categoria);
    }

    @DeleteMapping ("/delete/{id}")
    public void deletePorId (@PathVariable Long id){
        produtoRepository.deleteById(id);
    }

}








