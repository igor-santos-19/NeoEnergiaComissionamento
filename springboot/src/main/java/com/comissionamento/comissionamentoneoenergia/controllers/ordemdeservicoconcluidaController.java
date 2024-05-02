package com.comissionamento.comissionamentoneoenergia.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.comissionamento.comissionamentoneoenergia.models.ordemdeservicoconcluida;
import com.comissionamento.comissionamentoneoenergia.services.ordemdeservicoconcluidaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/ordemdeservicoconcluida")
public class ordemdeservicoconcluidaController {
    @Autowired
    private ordemdeservicoconcluidaService ordemdeservicoconcluidaService;

    @GetMapping("/{id}")
    public ResponseEntity<ordemdeservicoconcluida> findById(@PathVariable Long id){
        ordemdeservicoconcluida obj = this.ordemdeservicoconcluidaService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<ordemdeservicoconcluida> create(@RequestBody ordemdeservicoconcluida obj){
        this.ordemdeservicoconcluidaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody ordemdeservicoconcluida obj, @PathVariable Long id){
        obj.setId(id);
        this.ordemdeservicoconcluidaService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.ordemdeservicoconcluidaService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
