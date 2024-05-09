package com.comissionamento.comissionamentoneoenergia.controllers;

import java.net.URI;
import java.util.List;

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

import com.comissionamento.comissionamentoneoenergia.models.ordemdeservicopendente;
import com.comissionamento.comissionamentoneoenergia.services.ordemdeservicopendenteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/ordemdeservicopendente")
public class ordemdeservicopendenteController {
    @Autowired
    private ordemdeservicopendenteService ordemdeservicopendenteService;

    @GetMapping("/{id}")
    public ResponseEntity<ordemdeservicopendente> findById(@PathVariable Long id){
        ordemdeservicopendente obj = this.ordemdeservicopendenteService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/osependente")
    public List<ordemdeservicopendente> listaosependente(){
        return ordemdeservicopendenteService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<ordemdeservicopendente> create(@RequestBody ordemdeservicopendente obj){
        this.ordemdeservicopendenteService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody ordemdeservicopendente obj, @PathVariable Long id){
        obj.setId(id);
        this.ordemdeservicopendenteService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.ordemdeservicopendenteService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
