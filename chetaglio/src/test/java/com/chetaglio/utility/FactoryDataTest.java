package com.chetaglio.utility;

import java.util.ArrayList;
import java.util.List;

import com.chetaglio.model.entity.Categoria;
import com.chetaglio.model.entity.Citta;
import com.chetaglio.model.entity.Commento;
import com.chetaglio.model.entity.Immagine;
import com.chetaglio.model.entity.Negozio;
import com.chetaglio.model.entity.Servizio;
import com.chetaglio.service.dto.CategoriaDTO;
import com.chetaglio.service.dto.CittaDTO;
import com.chetaglio.service.dto.ImmagineDTO;
import com.chetaglio.service.dto.NegozioDTO;
import com.chetaglio.service.dto.ServizioDTO;

public class FactoryDataTest {

	public static Negozio getNegozio(){
		Citta citta = new Citta();
		citta.setNome("Milano");
		citta.setProvincia("MI");
		citta.setRegione("Lombardia");
		citta.setId(1l);

		Immagine i = new Immagine();
		i.setUrl("http://url");

		Negozio negozio = new Negozio();
		negozio.setCitta(citta);
		negozio.setCognome("Cognome");
		negozio.setNome("Nome");
		negozio.addImmagine(i);
		negozio.addServizio(getServizio());
		negozio.setInsegna("Insegna");
		negozio.addCommento(getCommento());

		return negozio;
	}

	public static NegozioDTO getNegozioDTO(){
		CittaDTO citta = new CittaDTO();
		citta.setNome("nome");
		citta.setId(1l);

		List<ImmagineDTO> immagini = new ArrayList<ImmagineDTO>();
		ImmagineDTO i = new ImmagineDTO();
		i.setUrl("url");
		immagini.add(i);
		
		
		List<ServizioDTO> servizi = new ArrayList<ServizioDTO>();
		servizi.add(getServizioDTO());

		NegozioDTO negozio = new NegozioDTO();
		negozio.setId(1l);
		negozio.setCitta(citta);
		negozio.setCognome("cognome");
		negozio.setImmagini(immagini);
		negozio.setServizi(servizi);

		return negozio;
	}

	public static Categoria getCategoria(){
		Categoria c = new Categoria();
		c.setDescrizione("Taglio");
		c.setNome("Taglio");
		c.setId(1L);
		return c;
	}

	public static CategoriaDTO getCategoriaDTO(){
		CategoriaDTO c = new CategoriaDTO();
		c.setDescrizione("descrizione");
		c.setId(1l);
		c.setNome("nome");

		return c;
	}


	public static Servizio getServizio(){
		Categoria c = getCategoria();
		Servizio s = new Servizio();
		s.setCosto(100D);
		s.setDurata("100 minuti");
		s.setNome("taglio capelli lungo");
		s.setCategoria(c);
		return s;
	}


	public static ServizioDTO getServizioDTO(){

		CategoriaDTO c = getCategoriaDTO();
		ServizioDTO s = new ServizioDTO();
		s.setCosto(100D);
		s.setDurata("100 minuti");
		s.setNome("taglio capelli lungo");
		s.setCategoria(c);
		return s;
	}


	public static Commento getCommento(){
		Commento c = new Commento();
		c.setCommento("Fa cacare");
		return c;
	}

}
