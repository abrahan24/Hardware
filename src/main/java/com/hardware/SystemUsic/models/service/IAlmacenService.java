package com.hardware.SystemUsic.models.service;

import java.util.List;

import com.hardware.SystemUsic.models.entity.Almacen;

public interface IAlmacenService {
    public List<Almacen> findAll();

	public void save(Almacen almacen);

	public Almacen findOne(Long id);

	public void delete(Long id);

	public List<Almacen>getAllAlmacenTipoEquipo(Long id_tipoEquipo);
}
