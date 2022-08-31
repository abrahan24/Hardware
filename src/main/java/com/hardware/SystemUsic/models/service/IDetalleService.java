package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.Detalle;

public interface IDetalleService {
    
    public List<Detalle> findAll();

	public void save(Detalle detalle);

	public Detalle findOne(Long id);

	public void delete(Long id);
    
}