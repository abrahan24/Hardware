package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.Cargo;

public interface ICargoService {
    public List<Cargo> findAll();

	public void save(Cargo cargo);

	public Cargo findOne(Long id);

	public void delete(Long id);
}
