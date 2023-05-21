package com.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double valor;

    private Integer quantidade;

    // construtores, getters e setters
    public Produto() {}

    public Produto(String nome, Double valor, Integer quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
	@PostPersist
	public void enviarEmailCadatro() {
		System.out.println("E-mail de atualizacao sobre o cadastramento enviado para o responsavel do banco de produtos.");
	}
	
	@PostUpdate
	public void enviarEmailAtualizacao() {
		System.out.println("E-mail de atualizacao enviado para o responsavel do banco de produtos.");
	}
	
	@PostRemove
	public void enviarEmailExclusao() {
		System.out.println("E-mail enviado ao responsavel sobre a exclusao do produto!");
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", valor=" + valor + ", quantidade=" + quantidade + "]";
	}
}
