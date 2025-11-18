package com.sistema.estoque.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorTotal;
    private Double valorRecebido;
    private Double troco;

    private LocalDateTime dataHora = LocalDateTime.now();

    @ManyToOne
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "venda_id")
    private List<ItemVenda> itens = new ArrayList<>();

    public Venda() {}

    public Venda(Long id, Double valorTotal, Double valorRecebido, Double troco, Usuario usuario) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.valorRecebido = valorRecebido;
        this.troco = troco;
        this.usuario = usuario;
        this.dataHora = LocalDateTime.now();
    }

    // Getters e setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }

    public Double getValorRecebido() { return valorRecebido; }
    public void setValorRecebido(Double valorRecebido) { this.valorRecebido = valorRecebido; }

    public Double getTroco() { return troco; }
    public void setTroco(Double troco) { this.troco = troco; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<ItemVenda> getItens() { return itens; }
    public void setItens(List<ItemVenda> itens) { this.itens = itens; }
}
