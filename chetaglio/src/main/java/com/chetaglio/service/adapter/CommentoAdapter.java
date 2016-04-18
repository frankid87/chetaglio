package com.chetaglio.service.adapter;

import com.chetaglio.model.entity.Commento;
import com.chetaglio.service.adapter.utility.BaseAdapter;
import com.chetaglio.service.dto.CommentoDTO;


public class CommentoAdapter extends BaseAdapter{
	
	public Commento fromDtoToEntity(CommentoDTO dto){
		Commento entity = mapper.map(dto, Commento.class);
		return entity;
	}

	public CommentoDTO fromEntityToDto(Commento entity){
		CommentoDTO dto = mapper.map(entity, CommentoDTO.class);
		return dto;
	}
	
}