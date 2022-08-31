package com.hardware.SystemUsic.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hardware.SystemUsic.models.entity.Cargo;

public interface ICargoDao extends CrudRepository<Cargo, Long>{
    
}
