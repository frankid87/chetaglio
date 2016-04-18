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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="NEGOZI")
public class Negozio {
	
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
	private Long contatore = new Long(0);
	private Utente utente;
	private Citta citta;
	
	private List<Immagine> immagini = new ArrayList<Immagine>();
	private List<Servizio> servizi = new ArrayList<Servizio>();
	private List<Commento> commenti = new ArrayList<Commento>();
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="INSEGNA", length=50, nullable=false)
	public String getInsegna() {
		return insegna;
	}
	
	public void setInsegna(String insegna) {
		this.insegna = insegna;
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
	
	@Column(name="DESCRIZIONE", length=200)
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	@Column(name="TELEFONO", length=20)
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Column(name="MAIL", length=50)
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Column(name="INDIRIZZO", length=50)
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	@Column(name="LATITUDINE")
	public Integer getLatitudine() {
		return latitudine;
	}
	
	public void setLatitudine(Integer latitudine) {
		this.latitudine = latitudine;
	}
	
	@Column(name="LONGITUDINE")
	public Integer getLongitudine() {
		return longitudine;
	}
	
	public void setLongitudine(Integer longitudine) {
		this.longitudine = longitudine;
	}
	
	@Column(name="CONTATORE")
	public Long getContatore() {
		return contatore;
	}
	
	public void setContatore(Long contatore) {
		this.contatore = contatore;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "negozio", cascade=CascadeType.ALL)
	public List<Immagine> getImmagini() {
		return immagini;
	}
	
	public void setImmagini(List<Immagine> immagini) {
		this.immagini = immagini;
	}

	public void addImmagine(Immagine immagine) {
		immagine.setNegozio(this);
		this.immagini.add(immagine);
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_utente")
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "negozio", cascade=CascadeType.ALL)
	public List<Servizio> getServizi() {
		return servizi;
	}

	public void setServizi(List<Servizio> servizi) {
		this.servizi = servizi;
	}

	public void addServizio(Servizio servizio) {
		servizio.setNegozio(this);
		this.servizi.add(servizio);
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_citta", nullable=false)
	public Citta getCitta() {
		return citta;
	}

	public void setCitta(Citta citta) {
		this.citta = citta;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "negozio", cascade=CascadeType.ALL)
	public List<Commento> getCommenti() {
		return commenti;
	}

	public void setCommenti(List<Commento> commenti) {
		this.commenti = commenti;
	}

	public void addCommento(Commento commento) {
		commento.setNegozio(this);
		this.commenti.add(commento);
	}
	
}
