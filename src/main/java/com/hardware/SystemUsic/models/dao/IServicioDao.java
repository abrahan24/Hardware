package com.hardware.SystemUsic.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hardware.SystemUsic.models.entity.Servicio;

public interface IServicioDao extends CrudRepository<Servicio, Long>{

    @Query("select s from Servicio s left join fetch s.procedencia pr where pr.id_procedencia=?1")
    public List<Servicio> getAllServicioUsuario(Long id_procedencia);
}
