package com.sistema.estoque.controller;

import com.sistema.estoque.entity.Produto;
import com.sistema.estoque.service.ProdutoServico;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoServico servico;

    public ProdutoController(ProdutoServico servico) { this.servico = servico; }

    @PostMapping
    public Produto criar(@RequestBody Produto p) { return servico.criar(p); }

    @GetMapping
    public List<Produto> listar() { return servico.listar(); }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto p) {
        return servico.atualizar(id, p);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        servico.deletar(id);
    }
}
