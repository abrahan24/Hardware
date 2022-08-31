package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.FallaEquipo;

public interface IFallaEquipoService {
    public List<FallaEquipo> findAll();

	public void save(FallaEquipo fallaEquipo);

	public FallaEquipo findOne(Long id);

	public void delete(Long id);
}
