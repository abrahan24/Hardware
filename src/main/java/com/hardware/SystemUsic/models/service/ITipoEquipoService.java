package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.TipoEquipo;

public interface ITipoEquipoService {
    public List<TipoEquipo> findAll();

	public void save(TipoEquipo tipoEquipo);

	public TipoEquipo findOne(Long id);

	public void delete(Long id);
}
