package com.sistema.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.estoque.entity.MovimentoDeEstoque;

public interface MovimentoRepositorio extends JpaRepository<MovimentoDeEstoque, Long> {
}
