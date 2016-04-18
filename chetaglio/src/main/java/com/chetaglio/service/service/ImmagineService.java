package com.chetaglio.service.service;

import java.util.List;

import com.chetaglio.model.entity.Immagine;

public interface ImmagineService {

	public void create(Immagine immagine);

	public void update(Immagine immagine);

	public void delete(Immagine immagine);

	public Immagine findById(Long id);

	public List<Immagine> findAll();
}
