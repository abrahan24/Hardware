package com.hardware.SystemUsic.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hardware.SystemUsic.models.entity.Almacen;

public interface IAlmacenDao extends CrudRepository<Almacen, Long>{
    @Query("select al from Almacen al left join fetch al.tipoEquipo te where te.id_tipoequipo=?1")
    public List<Almacen>getAllAlmacenTipoEquipo(Long id_tipoEquipo);
}
