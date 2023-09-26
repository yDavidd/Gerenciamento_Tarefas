package com.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farm.entities.Tarefa;
import com.farm.services.TarServico;

@RestController
@RequestMapping("/tarefa")
public class TarController {
    
    private final TarServico tarServico;
    
    @Autowired
    public TarController(TarServico tarServico) {
        this.tarServico = tarServico;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getTarefaById(@PathVariable Long id) {
        Tarefa tarefa = tarServico.getTarefaById(id);
        if (tarefa != null) {
            return ResponseEntity.ok(tarefa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Tarefa>> getAllTarefas() {
        List<Tarefa> tarefa= tarServico.getAllTarefas();
        return ResponseEntity.ok(tarefa);
    }

    @PostMapping("/")
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa criarTarefa = tarServico.salvarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarTarefa);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        Tarefa updatedTarefa = tarServico.updateTarefa(id, tarefa);
        if (updatedTarefa != null) {
            return ResponseEntity.ok(updatedTarefa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTarefa(@PathVariable Long id) {
        boolean deleted = tarServico.deleteTarefa(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("A tarefa foi excluída com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    } 
}