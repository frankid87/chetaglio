package com.chetaglio.service.dto;


public class ImmagineDTO {

	private Long id;
	private String url;
	private NegozioDTO negozio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public NegozioDTO getNegozio() {
		return negozio;
	}

	public void setNegozio(NegozioDTO negozio) {
		this.negozio = negozio;
	}

}