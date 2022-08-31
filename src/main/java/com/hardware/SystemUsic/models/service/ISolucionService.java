package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.Solucion;

public interface ISolucionService {
	
    public List<Solucion> findAll();

	public void save(Solucion solucion);

	public Solucion findOne(Long id);

	public void delete(Long id);
}
