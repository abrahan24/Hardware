package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.Pregunta;

public interface IPreguntaService {
    public List<Pregunta> findAll();

	public void save(Pregunta pregunta);

	public Pregunta findOne(Long id);

	public void delete(Long id);
}
