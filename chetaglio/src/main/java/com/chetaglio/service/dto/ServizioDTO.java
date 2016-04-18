package com.chetaglio.service.dto;


public class ServizioDTO {

	private Long id; 
	private String nome;
	private Double costo;
	private String durata;
	private NegozioDTO negozio;
	private CategoriaDTO categoria;

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

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getDurata() {
		return durata;
	}

	public void setDurata(String durata) {
		this.durata = durata;
	}

	public NegozioDTO getNegozio() {
		return negozio;
	}

	public void setNegozio(NegozioDTO negozio) {
		this.negozio = negozio;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

}