package com.sistema.estoque.controller;

import com.sistema.estoque.entity.MovimentoDeEstoque;
import com.sistema.estoque.service.MovimentoServico;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentos")
public class MovimentoController {

    private final MovimentoServico servico;

    public MovimentoController(MovimentoServico servico) { this.servico = servico; }

    @PostMapping
    public MovimentoDeEstoque registrar(@RequestBody MovimentoDeEstoque m) {
        return servico.registrar(m);
    }

    @GetMapping
    public List<MovimentoDeEstoque> listar() { return servico.listar(); }
}
