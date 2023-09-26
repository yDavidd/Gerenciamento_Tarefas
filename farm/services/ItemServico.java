package com.farm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.entities.ItemExecucao;
import com.farm.repository.ItemRepository;

@Service
public class ItemServico {
    private final ItemRepository itemRepository;
    
    @Autowired
    public ItemServico(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemExecucao> getAllItemExecucoes() {
        return itemRepository.findAll();
    }

    public ItemExecucao getItemExecucaoById(Long id) {
        Optional<ItemExecucao> itemExecucao = itemRepository.findById(id);
        return itemExecucao.orElse(null);
    }

    public ItemExecucao salvarItemExecucao(ItemExecucao itemExecucao) {
        return itemRepository.save(itemExecucao);
    }

    public ItemExecucao updateItemExecucao(Long id, ItemExecucao updatedItemExecucao) {
        Optional<ItemExecucao> existingItemExecucao = itemRepository.findById(id);
        if (existingItemExecucao.isPresent()) {
            updatedItemExecucao.setId(id);
            return itemRepository.save(updatedItemExecucao);
        }
        return null;
    }

    public boolean deleteItemExecucao(Long id) {
        Optional<ItemExecucao> existingItemExecucao = itemRepository.findById(id);
        if (existingItemExecucao.isPresent()) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}