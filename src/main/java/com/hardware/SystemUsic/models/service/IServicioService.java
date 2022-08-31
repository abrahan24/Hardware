package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.Servicio;

public interface IServicioService {
    public List<Servicio> findAll();

	public void save(Servicio servicio);

	public Servicio findOne(Long id);

	public void delete(Long id);

	public List<Servicio> getAllServicioUsuario(Long id_procedencia);
}
