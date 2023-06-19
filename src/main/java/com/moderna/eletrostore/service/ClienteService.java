package com.moderna.eletrostore.service;

import com.moderna.eletrostore.model.Cliente;
import com.moderna.eletrostore.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

    ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) throws Exception {
        Optional<Cliente> clienteRetorno = clienteRepository.findByDocumento(cliente.getDocumento());

        if (clienteRetorno.isEmpty()) {
            return clienteRepository.save(cliente);
        } else {
            throw new Exception("cliente existente");
        }
    }

    @Transactional
    public ResponseEntity<Void> deletarPorDoc(String documento) throws Exception {
        Optional<Cliente> clienteSalvo = clienteRepository.findByDocumento(documento);
        if (clienteSalvo.isPresent()) {
            clienteRepository.deleteByDocumento(documento);
        }else {
            throw new Exception("Documento não existe no banco de dados");
        }
        return null;
    }


}


