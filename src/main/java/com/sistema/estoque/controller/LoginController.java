package com.sistema.estoque.controller;

import com.sistema.estoque.entity.Usuario;
import com.sistema.estoque.service.UsuarioServico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UsuarioServico servico;

    public LoginController(UsuarioServico servico) { this.servico = servico; }

    @PostMapping
    public Usuario autenticar(@RequestParam String email, @RequestParam String senha) {
        return servico.autenticar(email, senha);
    }
}
