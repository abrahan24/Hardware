package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.Baja;

public interface IBajaService {
    public List<Baja> findAll();

	public void save(Baja baja);

	public Baja findOne(Long id);

	public void delete(Long id);
}
