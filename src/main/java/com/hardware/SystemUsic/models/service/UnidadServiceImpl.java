package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IUnidadDao;
import com.hardware.SystemUsic.models.entity.Unidad;
@Service
public class UnidadServiceImpl implements IUnidadService{

    @Autowired
    private IUnidadDao unidadDao;

    @Override
    public List<Unidad> findAll() {
     
        return (List<Unidad>) unidadDao.findAll();
    }

    @Override
    public void save(Unidad unidad) {
        
        unidadDao.save(unidad);
    }

    @Override
    public Unidad findOne(Long id) {
       
        return unidadDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
      
        unidadDao.deleteById(id);
    }
    
}
