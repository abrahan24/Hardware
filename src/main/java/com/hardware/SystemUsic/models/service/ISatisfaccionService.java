package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.Satisfaccion;

public interface ISatisfaccionService {
    public List<Satisfaccion> findAll();

	public void save(Satisfaccion satisfaccion);

	public Satisfaccion findOne(Long id);

	public void delete(Long id);
}
