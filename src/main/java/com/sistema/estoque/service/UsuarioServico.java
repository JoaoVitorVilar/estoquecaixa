package com.sistema.estoque.service;

import com.sistema.estoque.entity.Usuario;
import com.sistema.estoque.repository.UsuarioRepositorio;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServico {

    private final UsuarioRepositorio repo;

    public UsuarioServico(UsuarioRepositorio repo) {
        this.repo = repo;
    }

    public Usuario criar(Usuario u) {
        if (repo.existsByEmail(u.getEmail())) {
            throw new IllegalArgumentException("Email já existe.");
        }

        String hash = BCrypt.hashpw(u.getSenhaHash(), BCrypt.gensalt());
        u.setSenhaHash(hash);

        return repo.save(u);
    }

    public Usuario atualizar(Long id, Usuario u) {
        Usuario original = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        original.setNome(u.getNome());
        original.setPerfil(u.getPerfil());
        original.setAtivo(u.isAtivo());

        if (!original.getEmail().equals(u.getEmail())) {
            if (repo.existsByEmail(u.getEmail())) {
                throw new IllegalArgumentException("Email já cadastrado.");
            }
            original.setEmail(u.getEmail());
        }

        return repo.save(original);
    }

    public Usuario autenticar(String email, String senha) {
        Usuario u = repo.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Credenciais inválidas"));

        if (!BCrypt.checkpw(senha, u.getSenhaHash())) {
            throw new IllegalArgumentException("Credenciais inválidas");
        }

        u.setSenhaHash(null);
        return u;
    }

    public List<Usuario> listar() { return repo.findAll(); }

    public void deletar(Long id) { repo.deleteById(id); }
}
