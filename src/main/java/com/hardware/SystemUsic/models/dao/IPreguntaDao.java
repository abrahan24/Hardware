package com.hardware.SystemUsic.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hardware.SystemUsic.models.entity.Pregunta;

public interface IPreguntaDao extends CrudRepository<Pregunta, Long>{
    
}
