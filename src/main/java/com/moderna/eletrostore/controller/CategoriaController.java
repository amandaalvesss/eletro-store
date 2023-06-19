package com.moderna.eletrostore.controller;

import com.moderna.eletrostore.model.Categoria;
import com.moderna.eletrostore.model.Cliente;
import com.moderna.eletrostore.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    CategoriaRepository categoriaRepository;

    @PostMapping("/salvar")
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
              return new ResponseEntity<>(categoriaRepository.save(categoria), HttpStatus.CREATED);
    }

}
