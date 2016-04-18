package com.chetaglio.service.adapter;

import com.chetaglio.model.entity.Immagine;
import com.chetaglio.service.adapter.utility.BaseAdapter;
import com.chetaglio.service.dto.ImmagineDTO;


public class ImmagineAdapter extends BaseAdapter{

	public Immagine fromDtoToEntity(ImmagineDTO dto){
		Immagine entity = mapper.map(dto, Immagine.class);
		return entity;
	}

	public ImmagineDTO fromEntityToDto(Immagine entity){
		ImmagineDTO dto = mapper.map(entity, ImmagineDTO.class);
		return dto;
	}
	
}