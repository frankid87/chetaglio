package com.chetaglio.service.adapter;

import com.chetaglio.model.entity.Servizio;
import com.chetaglio.service.adapter.utility.BaseAdapter;
import com.chetaglio.service.dto.ServizioDTO;


public class ServizioAdapter extends BaseAdapter {

	public Servizio fromDtoToEntity(ServizioDTO dto){
		Servizio entity = mapper.map(dto, Servizio.class);
		return entity;
	}

	public ServizioDTO fromEntityToDto(Servizio entity){
		ServizioDTO dto = mapper.map(entity, ServizioDTO.class);
		return dto;
	}

}