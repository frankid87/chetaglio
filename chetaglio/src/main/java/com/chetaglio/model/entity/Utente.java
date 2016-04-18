package com.chetaglio.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="UTENTI")
public class Utente {

	private Long id; 
	private String	nome; 
	private String cognome;
	private String username;
	private String password;
	private boolean disabilitato = true;
	private boolean accountNonScaduto = true;
	private boolean credenzialiNonScadute = true;
	private boolean accountNonBloccato = true;
	
	private List<Commento> commenti = new ArrayList<Commento>();
	private List<RuoloUtente> ruoli = new ArrayList<RuoloUtente>();
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="NOME", length=20)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="COGNOME", length=20)
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	@Column(name="USERNAME", length=20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="PASSWORD", length=20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="DISABILITATO")
	public boolean isDisabilitato() {
		return disabilitato;
	}

	public void setDisabilitato(boolean disabilitato) {
		this.disabilitato = disabilitato;
	}

	@Column(name="ACCOUNT_NON_SCADUTO")
	public boolean isAccountNonScaduto() {
		return accountNonScaduto;
	}

	public void setAccountNonScaduto(boolean accountNonScaduto) {
		this.accountNonScaduto = accountNonScaduto;
	}
	
	@Column(name="CREDENZIALI_NON_SCADUTE")
	public boolean isCredenzialiNonScadute() {
		return credenzialiNonScadute;
	}

	public void setCredenzialiNonScadute(boolean credenzialiNonScadute) {
		this.credenzialiNonScadute = credenzialiNonScadute;
	}

	@Column(name="ACCOUNT_NON_BLOCCATO")
	public boolean isAccountNonBloccato() {
		return accountNonBloccato;
	}

	public void setAccountNonBloccato(boolean accountNonBloccato) {
		this.accountNonBloccato = accountNonBloccato;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utente")
	public List<Commento> getCommenti() {
		return commenti;
	}

	public void setCommenti(List<Commento> commenti) {
		this.commenti = commenti;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "utente", cascade=CascadeType.ALL)
	public List<RuoloUtente> getRuoli() {
		return ruoli;
	}

	public void addRuolo(RuoloUtente ruolo) {
		ruolo.setUtente(this);
		this.ruoli.add(ruolo);
	}

	public void setRuoli(List<RuoloUtente> ruoli) {
		this.ruoli = ruoli;
	}
	
}