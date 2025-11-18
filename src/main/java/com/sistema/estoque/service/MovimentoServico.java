package com.sistema.estoque.service;

import com.sistema.estoque.entity.MovimentoDeEstoque;
import com.sistema.estoque.entity.Produto;
import com.sistema.estoque.repository.MovimentoRepositorio;
import com.sistema.estoque.repository.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentoServico {

    private final MovimentoRepositorio repo;
    private final ProdutoRepositorio produtoRepo;

    public MovimentoServico(MovimentoRepositorio repo, ProdutoRepositorio produtoRepo) {
        this.repo = repo;
        this.produtoRepo = produtoRepo;
    }

    public MovimentoDeEstoque registrar(MovimentoDeEstoque m) {
        Produto p = produtoRepo.findById(m.getProduto().getId())
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        if (m.getTipo() == MovimentoDeEstoque.TipoMovimento.ENTRADA)
            p.setQuantidadeEstoque(p.getQuantidadeEstoque() + m.getQuantidade());
        else
            p.setQuantidadeEstoque(p.getQuantidadeEstoque() + m.getQuantidade());

        produtoRepo.save(p);

        return repo.save(m);
    }

    public List<MovimentoDeEstoque> listar() { return repo.findAll(); }
}
