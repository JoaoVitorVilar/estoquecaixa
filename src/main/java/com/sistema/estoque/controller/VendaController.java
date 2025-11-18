package com.sistema.estoque.controller;

import com.sistema.estoque.entity.Venda;
import com.sistema.estoque.service.VendaServico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaServico servico;

    public VendaController(VendaServico servico) { this.servico = servico; }

    @PostMapping
    public Venda registrar(@RequestBody Venda v) {
        return servico.registrar(v);
    }
}
