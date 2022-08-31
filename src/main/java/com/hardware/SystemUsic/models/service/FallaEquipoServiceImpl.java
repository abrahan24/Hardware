package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IFallaEquipoDao;
import com.hardware.SystemUsic.models.entity.FallaEquipo;
@Service
public class FallaEquipoServiceImpl implements IFallaEquipoService{

    @Autowired
    private IFallaEquipoDao fallaEquipoDao;

    @Override
    public List<FallaEquipo> findAll() {
 
        return (List<FallaEquipo>) fallaEquipoDao.findAll();
    }

    @Override
    public void save(FallaEquipo fallaEquipo) {
    
        fallaEquipoDao.save(fallaEquipo);
    }

    @Override
    public FallaEquipo findOne(Long id) {

        return fallaEquipoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
    
        fallaEquipoDao.deleteById(id);
    }
    
}
