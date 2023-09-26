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

import com.farm.entities.ItemExecucao;
import com.farm.services.ItemServico;

@RestController
@RequestMapping("/itemservico")
public class ItemController {
    
    private final ItemServico itemServico;
    
    @Autowired
    public ItemController(ItemServico itemServico) {
        this.itemServico = itemServico;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemExecucao> getItemExecucaoById(@PathVariable Long id) {
        ItemExecucao itemExecucao = itemServico.getItemExecucaoById(id);
        if (itemExecucao != null) {
            return ResponseEntity.ok(itemExecucao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<ItemExecucao>> getAllItemExecucoes() {
        List<ItemExecucao> itemExecucao= itemServico.getAllItemExecucoes();
        return ResponseEntity.ok(itemExecucao);
    }

    @PostMapping("/")
    public ResponseEntity<ItemExecucao> criarItemExecucao(@RequestBody ItemExecucao itemExecucao) {
        ItemExecucao criarItemExecucao = itemServico.salvarItemExecucao(itemExecucao);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarItemExecucao);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<ItemExecucao> updateItemExecucao(@PathVariable Long id, @RequestBody ItemExecucao itemExecucao) {
        ItemExecucao updatedItemExecucao = itemServico.updateItemExecucao(id, itemExecucao);
        if (updatedItemExecucao != null) {
            return ResponseEntity.ok(updatedItemExecucao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItemExecucao(@PathVariable Long id) {
        boolean deleted = itemServico.deleteItemExecucao(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O item foi excluído com sucesso0201,55555353352");
        } else {
            return ResponseEntity.notFound().build();
        }
    } 
}