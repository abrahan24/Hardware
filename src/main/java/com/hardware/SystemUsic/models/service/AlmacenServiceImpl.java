package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IAlmacenDao;
import com.hardware.SystemUsic.models.entity.Almacen;

@Service
public class AlmacenServiceImpl implements IAlmacenService{

    @Autowired
    private IAlmacenDao almacenDao;

    @Override
    public List<Almacen> findAll() {

        return (List<Almacen>) almacenDao.findAll();
    }

    @Override
    public void save(Almacen almacen) {

        almacenDao.save(almacen);
    }

    @Override
    public Almacen findOne(Long id) {

        return almacenDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        
        almacenDao.deleteById(id);
    }

    @Override
    public List<Almacen> getAllAlmacenTipoEquipo(Long id_tipoEquipo) {
        
        
        return almacenDao.getAllAlmacenTipoEquipo(id_tipoEquipo);
    }

    
}