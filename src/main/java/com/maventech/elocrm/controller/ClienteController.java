package com.maventech.elocrm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maventech.elocrm.model.Cliente;
import com.maventech.elocrm.repository.ClienteRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Listar todos
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar por nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Cliente>> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(clienteRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    // Criar cliente
    @PostMapping
    public ResponseEntity<Cliente> post(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteRepository.save(cliente));
    }

    // Atualizar cliente
    @PutMapping
    public ResponseEntity<Cliente> put(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.findById(cliente.getId())
                .map(resposta -> ResponseEntity.ok(clienteRepository.save(cliente)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Deletar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(registro -> {
                    clienteRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
