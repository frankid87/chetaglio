package com.chetaglio.service.adapter;

import com.chetaglio.model.entity.Categoria;
import com.chetaglio.service.adapter.utility.BaseAdapter;
import com.chetaglio.service.dto.CategoriaDTO;


public class CategoriaAdapter extends BaseAdapter{

	public Categoria fromDtoToEntity(CategoriaDTO dto){
		Categoria entity = mapper.map(dto, Categoria.class);
		return entity;
	}

	public CategoriaDTO fromEntityToDto(Categoria entity){
		CategoriaDTO dto = mapper.map(entity, CategoriaDTO.class);
		return dto;
	}
	
}