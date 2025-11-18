package com.sistema.estoque.service;

import com.sistema.estoque.entity.Produto;
import com.sistema.estoque.repository.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServico {

    private final ProdutoRepositorio repo;

    public ProdutoServico(ProdutoRepositorio repo) { this.repo = repo; }

    public Produto criar(Produto p) {
        if (repo.existsByCodigo(p.getCodigo())) {
            throw new IllegalArgumentException("Código já cadastrado.");
        }
        return repo.save(p);
    }

    public Produto atualizar(Long id, Produto p) {
        Produto original = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        original.setNome(p.getNome());
        original.setCategoria(p.getCategoria());
        original.setPrecoUnitario(p.getPrecoUnitario());
        original.setQuantidadeEstoque(p.getQuantidadeEstoque());

        return repo.save(original);
    }

    public List<Produto> listar() { return repo.findAll(); }

    public void deletar(Long id) { repo.deleteById(id); }
}
