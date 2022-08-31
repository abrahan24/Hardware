package com.hardware.SystemUsic.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hardware.SystemUsic.models.entity.Detalle;

public interface IDetalleDao extends CrudRepository<Detalle, Long> {
    
}
