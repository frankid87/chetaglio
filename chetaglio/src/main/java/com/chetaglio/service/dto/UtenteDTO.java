package com.chetaglio.service.dto;

import java.util.List;

public class UtenteDTO {

	private Long id; 
	private String	nome; 
	private String cognome;

	private List<CommentoDTO> commenti;

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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<CommentoDTO> getCommenti() {
		return commenti;
	}

	public void setCommenti(List<CommentoDTO> commenti) {
		this.commenti = commenti;
	}

}