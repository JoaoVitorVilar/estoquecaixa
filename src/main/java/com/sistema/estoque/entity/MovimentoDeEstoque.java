package com.sistema.estoque.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimentos_estoque")
public class MovimentoDeEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoMovimento tipo;

    private Integer quantidade;

    private String motivo;

    private LocalDateTime dataHora = LocalDateTime.now();

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Usuario usuario;

    public MovimentoDeEstoque() {}

    public MovimentoDeEstoque(Long id, TipoMovimento tipo, Integer quantidade, String motivo, Produto produto, Usuario usuario) {
        this.id = id;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.motivo = motivo;
        this.produto = produto;
        this.usuario = usuario;
        this.dataHora = LocalDateTime.now();
    }

    // Getters e setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public TipoMovimento getTipo() { return tipo; }
    public void setTipo(TipoMovimento tipo) { this.tipo = tipo; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public enum TipoMovimento { ENTRADA, AJUSTE }
}
