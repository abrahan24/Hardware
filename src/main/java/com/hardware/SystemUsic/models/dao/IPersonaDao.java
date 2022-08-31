package com.hardware.SystemUsic.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hardware.SystemUsic.models.entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long>{

    @Query("select p from Persona p where p.ci=?1")
    public Persona getCIpersona(String ci);
}