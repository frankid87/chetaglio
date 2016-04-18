package com.chetaglio.service.dto;

import java.util.List;

public class NegozioDTO {
	
	private Long id;
	private String insegna;
	private String nome;
	private String cognome;
	private String descrizione;
	private String telefono;
	private String mail;
	private String indirizzo;
	private Integer latitudine; 
	private Integer longitudine; 
	private Long contatore;
	private UtenteDTO utente;
	private CittaDTO citta;
	
	private Long idCategoria;
	
	private List<ImmagineDTO> immagini;
	private List<ServizioDTO> servizi;
	private List<CommentoDTO> commenti;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getInsegna() {
		return insegna;
	}
	
	public void setInsegna(String insegna) {
		this.insegna = insegna;
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
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public Integer getLatitudine() {
		return latitudine;
	}
	
	public void setLatitudine(Integer latitudine) {
		this.latitudine = latitudine;
	}
	
	public Integer getLongitudine() {
		return longitudine;
	}
	
	public void setLongitudine(Integer longitudine) {
		this.longitudine = longitudine;
	}
	
	public Long getContatore() {
		return contatore;
	}
	
	public void setContatore(Long contatore) {
		this.contatore = contatore;
	}
	
	public List<ImmagineDTO> getImmagini() {
		return immagini;
	}

	public void setImmagini(List<ImmagineDTO> immagini) {
		this.immagini = immagini;
	}

	public UtenteDTO getUtente() {
		return utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}

	public List<ServizioDTO> getServizi() {
		return servizi;
	}

	public void setServizi(List<ServizioDTO> servizi) {
		this.servizi = servizi;
	}

	public CittaDTO getCitta() {
		return citta;
	}

	public void setCitta(CittaDTO citta) {
		this.citta = citta;
	}

	public List<CommentoDTO> getCommenti() {
		return commenti;
	}

	public void setCommenti(List<CommentoDTO> commenti) {
		this.commenti = commenti;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	
}