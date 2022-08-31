package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.Previo;

public interface IPrevioService {
    public List<Previo> findAll();

	public void save(Previo previo);

	public Previo findOne(Long id);

	public void delete(Long id);
    
}
