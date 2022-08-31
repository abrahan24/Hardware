package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.DetalleSolucion;

public interface IDetalleSolucionService {
	
    public List<DetalleSolucion> findAll();

	public void save(DetalleSolucion detalleSolucion);

	public DetalleSolucion findOne(Long id);

	public void delete(Long id);
}
