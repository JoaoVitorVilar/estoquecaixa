package com.sistema.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.estoque.entity.Venda;

public interface VendaRepositorio extends JpaRepository<Venda, Long> {
}
