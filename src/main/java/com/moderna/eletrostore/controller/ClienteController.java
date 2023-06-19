package com.moderna.eletrostore.controller;

import com.moderna.eletrostore.model.Cliente;
import com.moderna.eletrostore.repository.ClienteRepository;
import com.moderna.eletrostore.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    @PostMapping("/salvar")
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) throws Exception { // um json de pessoa via body
        try {
           return new ResponseEntity<>(clienteService.salvar(cliente), HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @PutMapping ("/atualizar")
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente){
       return new ResponseEntity<Cliente>(clienteRepository.save(cliente), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<Cliente> listarClientes () {
        return clienteRepository.findAll();
    }

    @GetMapping ("/listarPorDoc/{documento}")
    public Optional<Cliente> listarPorDoc (@PathVariable String documento){
        return clienteRepository.findByDocumento(documento);
    }
    @GetMapping ("/buscar/{id}")
    public Optional<Cliente> buscarPorId (@PathVariable Long id){
        return clienteRepository.findById(id);
    }

    @DeleteMapping ("/delete/{id}")
    public void deletePorId (@PathVariable Long id){
        clienteRepository.deleteById(id);
    }

    @DeleteMapping ("/deletePorDoc/{documento}")
    public ResponseEntity<Void> deletePorDoc(@PathVariable String documento) throws Exception{
        try {
            return new ResponseEntity(clienteService.deletarPorDoc(documento), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            }

        @DeleteMapping("/delete-todos")
            public void deleteTodos () {
                clienteRepository.deleteAll();
            }

    }
