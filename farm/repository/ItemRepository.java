package com.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farm.entities.ItemExecucao;

@Repository
public interface ItemRepository extends JpaRepository<ItemExecucao, Long> {
    // Métodos personalizados podem ser adicionados aqui
}
