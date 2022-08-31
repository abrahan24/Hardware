package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.ITipoEquipoDao;
import com.hardware.SystemUsic.models.entity.TipoEquipo;
@Service
public class TipoEquipoServiceImpl implements ITipoEquipoService{

    @Autowired
    private ITipoEquipoDao tipoEquipoDao;

    @Override
    public List<TipoEquipo> findAll() {
       
        return (List<TipoEquipo>) tipoEquipoDao.findAll();
    }

    @Override
    public void save(TipoEquipo tipoEquipo) {
       
        tipoEquipoDao.save(tipoEquipo);
    }

    @Override
    public TipoEquipo findOne(Long id) {
       
        return tipoEquipoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
    
        tipoEquipoDao.deleteById(id);
    }
    
}
