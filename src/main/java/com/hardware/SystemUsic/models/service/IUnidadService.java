package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.Unidad;

public interface IUnidadService {
    public List<Unidad> findAll();

	public void save(Unidad unidad);

	public Unidad findOne(Long id);

	public void delete(Long id);
}
