package com.chetaglio.service.adapter;

import com.chetaglio.model.entity.Utente;
import com.chetaglio.service.adapter.utility.BaseAdapter;
import com.chetaglio.service.dto.UtenteDTO;

public class UtenteAdapter extends BaseAdapter {
	
	public Utente fromDtoToEntity(UtenteDTO dto){
		Utente entity = mapper.map(dto, Utente.class);
		return entity;
	}

	public UtenteDTO fromEntityToDto(Utente entity){
		UtenteDTO dto = mapper.map(entity, UtenteDTO.class);
		return dto;
	}
	
}