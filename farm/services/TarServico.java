package com.farm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.entities.Tarefa;
import com.farm.repository.TarRepository;

@Service
public class TarServico {
    private final TarRepository tarRepository;
    
    @Autowired
    public TarServico(TarRepository tarRepository) {
        this.tarRepository = tarRepository;
    }

    public List<Tarefa> getAllTarefas() {
        return tarRepository.findAll();
    }

    public Tarefa getTarefaById(Long id) {
        Optional<Tarefa> tarefa = tarRepository.findById(id);
        return tarefa.orElse(null);
    }

    public Tarefa salvarTarefa(Tarefa tarefa) {
        return tarRepository.save(tarefa);
    }

    public Tarefa updateTarefa(Long id, Tarefa updatedTarefa) {
        Optional<Tarefa> existingTarefa = tarRepository.findById(id);
        if (existingTarefa.isPresent()) {
            updatedTarefa.setId(id);
            return tarRepository.save(updatedTarefa);
        }
        return null;
    }

    public boolean deleteTarefa(Long id) {
        Optional<Tarefa> existingTarefa = tarRepository.findById(id);
        if (existingTarefa.isPresent()) {
            tarRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
