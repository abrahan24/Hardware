package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.SolucionEquipo;

public interface ISolucionEquipoService {
	
    public List<SolucionEquipo> findAll();

	public void save(SolucionEquipo solucionEquipo);

	public SolucionEquipo findOne(Long id);

	public void delete(Long id);
}
