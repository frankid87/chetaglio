package com.chetaglio.service.adapter;

import com.chetaglio.model.entity.Citta;
import com.chetaglio.service.adapter.utility.BaseAdapter;
import com.chetaglio.service.dto.CittaDTO;


public class CittaAdapter extends BaseAdapter{

	public Citta fromDtoToEntity(CittaDTO dto){
		Citta entity = mapper.map(dto, Citta.class);
		return entity;
	}

	public CittaDTO fromEntityToDto(Citta entity){
		CittaDTO dto = mapper.map(entity, CittaDTO.class);
		return dto;
	}
	
}