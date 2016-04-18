package com.chetaglio.service.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chetaglio.model.dao.NegozioDAO;
import com.chetaglio.model.dao.utility.ORDINAMENTO;
import com.chetaglio.model.dao.utility.Pagination;
import com.chetaglio.model.entity.Negozio;
import com.chetaglio.service.adapter.NegozioAdapter;
import com.chetaglio.service.dto.NegozioDTO;
import com.chetaglio.service.service.NegozioService;
import com.chetaglio.utility.csv.CSVReader;

@Service
public class NegozioServiceImpl implements NegozioService {
	
	@Autowired
	private NegozioDAO negozioDAO;
	
	@Autowired
	private NegozioAdapter negozioAdapter;
	
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public void create(NegozioDTO negozio){
		negozioDAO.create(negozioAdapter.fromDtoToEntity(negozio));
	}
	
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public void update(NegozioDTO negozio) {
		negozioDAO.update(negozioAdapter.fromDtoToEntity(negozio));
	}


	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public void delete(NegozioDTO negozio) {
		negozioDAO.delete(negozioAdapter.fromDtoToEntity(negozio));
	}

	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public NegozioDTO findById(Long id) {
		return negozioAdapter.fromEntityToDto(negozioDAO.findById(id));
	}

	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<NegozioDTO> findAll(int pagina, int numeroRisultatiPagina) {
		int firstResult = numeroRisultatiPagina * (pagina - 1);
		List<ORDINAMENTO> versoOrdine = new ArrayList<ORDINAMENTO>();
		versoOrdine.add(ORDINAMENTO.DESC);
		List<String> paramOrdine = new ArrayList<String>();
		paramOrdine.add("id");
		
		Pagination pagination = new Pagination(numeroRisultatiPagina, firstResult, paramOrdine, versoOrdine);
		List<Negozio> listNegozio = negozioDAO.findAll(pagination);
		List<NegozioDTO> listNegozioDTO = new ArrayList<NegozioDTO>();
		for(Negozio negozio: listNegozio){
			listNegozioDTO.add(negozioAdapter.fromEntityToDto(negozio));
		}
		return listNegozioDTO;
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<NegozioDTO> findByCittaCategoriaInsegna(Long idCitta, Long idCategoria, String insegna, int pagina, int numeroRisultatiPagina) {
		String regex = "'";
		String insegnaBonificata = "";

		if(insegna != null){
			String[] array = insegna.split(regex);
			for(String val: array){
				if(val.trim().length() >= insegnaBonificata.trim().length()){
					insegnaBonificata = val.trim();
				}
			}
		}
	
		int firstResult = numeroRisultatiPagina * (pagina - 1);
		List<ORDINAMENTO> versoOrdine = new ArrayList<ORDINAMENTO>();
		versoOrdine.add(ORDINAMENTO.DESC);
		List<String> paramOrdine = new ArrayList<String>();
		paramOrdine.add("id");
		
		Pagination pagination = new Pagination(numeroRisultatiPagina, firstResult, paramOrdine, versoOrdine);
		List<Negozio> listNegozio = negozioDAO.findByCittaCategoriaInsegna(idCitta, idCategoria, insegnaBonificata, pagination);
		List<NegozioDTO> listNegozioDTO = new ArrayList<NegozioDTO>();
		for(Negozio negozio: listNegozio){
			listNegozioDTO.add(negozioAdapter.fromEntityToDto(negozio));
		}
		return listNegozioDTO;
	}
	
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public void saveFromCSV(InputStream stream){
		String[] nomiColonne = new String[]{"nome","cognome","eta"};
		List<CSVRecord> list = null;
		try {
			list = CSVReader.parser(stream, nomiColonne);
			for(CSVRecord record: list){
				NegozioDTO negozioDTO = new NegozioDTO();
				Negozio negozio = negozioAdapter.fromDtoToEntity(negozioDTO);
				negozioDAO.create(negozio);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}