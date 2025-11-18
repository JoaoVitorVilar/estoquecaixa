package com.sistema.estoque.controller;

import com.sistema.estoque.entity.Usuario;
import com.sistema.estoque.service.UsuarioServico;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioServico servico;

    public UsuarioController(UsuarioServico servico) { this.servico = servico; }

    @PostMapping
    public Usuario criar(@RequestBody Usuario u) { return servico.criar(u); }

    @GetMapping
    public List<Usuario> listar() { return servico.listar(); }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario u) {
        return servico.atualizar(id, u);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { servico.deletar(id); }
}
