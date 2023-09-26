package com.farm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farm.entities.Tarefa;

@Repository
public interface TarRepository extends JpaRepository<Tarefa, Long> {
    // Métodos personalizados podem ser adicionados aqui
}

