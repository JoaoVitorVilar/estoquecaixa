package com.sistema.estoque.service;

import com.sistema.estoque.entity.*;
import com.sistema.estoque.repository.ProdutoRepositorio;
import com.sistema.estoque.repository.UsuarioRepositorio;
import com.sistema.estoque.repository.VendaRepositorio;
import org.springframework.stereotype.Service;

@Service
public class VendaServico {

    private final VendaRepositorio repo;
    private final ProdutoRepositorio produtoRepo;
    private final UsuarioRepositorio usuarioRepo;

    public VendaServico(VendaRepositorio repo, ProdutoRepositorio produtoRepo, UsuarioRepositorio usuarioRepo) {
        this.repo = repo;
        this.produtoRepo = produtoRepo;
        this.usuarioRepo = usuarioRepo;
    }

    public Venda registrar(Venda venda) {

        double total = 0.0;

        for (ItemVenda item : venda.getItens()) {

            Produto p = produtoRepo.findById(item.getProduto().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

            if (item.getQuantidade() > p.getQuantidadeEstoque())
                throw new IllegalArgumentException("Quantidade excede estoque");

            item.setSubtotal(item.getQuantidade() * p.getPrecoUnitario());
            total += item.getSubtotal();

            p.setQuantidadeEstoque(p.getQuantidadeEstoque() - item.getQuantidade());
            produtoRepo.save(p);
        }

        venda.setValorTotal(total);

        if (venda.getValorRecebido() < total)
            throw new IllegalArgumentException("Valor recebido é menor que o total");

        venda.setTroco(venda.getValorRecebido() - total);

        return repo.save(venda);
    }
}
