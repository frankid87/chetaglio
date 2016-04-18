package com.chetaglio.service.adapter;

import java.util.ArrayList;
import java.util.List;

import com.chetaglio.model.entity.Citta;
import com.chetaglio.model.entity.Commento;
import com.chetaglio.model.entity.Immagine;
import com.chetaglio.model.entity.Negozio;
import com.chetaglio.model.entity.Servizio;
import com.chetaglio.service.adapter.utility.BaseAdapter;
import com.chetaglio.service.dto.CittaDTO;
import com.chetaglio.service.dto.CommentoDTO;
import com.chetaglio.service.dto.ImmagineDTO;
import com.chetaglio.service.dto.NegozioDTO;
import com.chetaglio.service.dto.ServizioDTO;

public class NegozioAdapter extends BaseAdapter {

	public Negozio fromDtoToEntity(NegozioDTO dto){
		Negozio entity = mapper.map(dto, Negozio.class);
		if(dto.getCitta() != null){
				Citta citta = mapper.map(dto.getCitta(), Citta.class);
				entity.setCitta(citta);
		}
		if(dto.getImmagini() != null){
			for(ImmagineDTO immagineDTO: dto.getImmagini()){
				Immagine immagine = mapper.map(immagineDTO, Immagine.class);
				entity.addImmagine(immagine);
			}
		}
		if(dto.getServizi()!= null){
			for(ServizioDTO servizioDTO: dto.getServizi()){
				Servizio servizio = mapper.map(servizioDTO, Servizio.class);
				entity.addServizio(servizio);
			}
		}
		if(dto.getCommenti() != null){
			for(CommentoDTO commentoDTO: dto.getCommenti()){
				Commento commento = mapper.map(commentoDTO, Commento.class);
				entity.addCommento(commento);
			}
		}
		return entity;
	}

	public NegozioDTO fromEntityToDto(Negozio entity){
		NegozioDTO dto = mapper.map(entity, NegozioDTO.class);
		List<ImmagineDTO> listImmagineDTO = new ArrayList<ImmagineDTO>();
		List<ServizioDTO> listServizioDTO = new ArrayList<ServizioDTO>();
		List<CommentoDTO> listCommentoDTO = new ArrayList<CommentoDTO>();
		if(entity.getCitta() != null){
				CittaDTO cittaDTO = mapper.map(entity.getCitta(), CittaDTO.class);
				dto.setCitta(cittaDTO);
		}
		if(entity.getImmagini() != null){
			for(Immagine immagine: entity.getImmagini()){
				ImmagineDTO immagineDTO = mapper.map(immagine, ImmagineDTO.class);
				listImmagineDTO.add(immagineDTO);
			}
		}
		if(entity.getServizi() != null){
			for(Servizio servizio: entity.getServizi()){
				ServizioDTO servizioDTO = mapper.map(servizio, ServizioDTO.class);
				listServizioDTO.add(servizioDTO);
			}
		}
		if(entity.getCommenti() != null){
			for(Commento commento: entity.getCommenti()){
				CommentoDTO commentoDTO = mapper.map(commento, CommentoDTO.class);
				listCommentoDTO.add(commentoDTO);
			}
		}
		dto.setImmagini(listImmagineDTO);
		dto.setServizi(listServizioDTO);
		dto.setCommenti(listCommentoDTO);
		return dto;
	}

}