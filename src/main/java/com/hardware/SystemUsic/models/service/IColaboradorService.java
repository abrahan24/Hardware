package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.Colaborador;

public interface IColaboradorService {
    public List<Colaborador> findAll();

	public void save(Colaborador colaborador);

	public Colaborador findOne(Long id);

	public void delete(Long id);
}
