package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.Procedencia;

public interface IProcedenciaService {
    public List<Procedencia> findAll();

	public void save(Procedencia procedencia);

	public Procedencia findOne(Long id);

	public void delete(Long id);
}
