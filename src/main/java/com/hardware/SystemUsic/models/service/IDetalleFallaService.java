package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.DetalleFalla;

public interface IDetalleFallaService {
    public List<DetalleFalla> findAll();

	public void save(DetalleFalla detalleFalla);

	public DetalleFalla findOne(Long id);

	public void delete(Long id);
}
