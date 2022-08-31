package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.ISolucionDao;
import com.hardware.SystemUsic.models.entity.Solucion;

@Service
public class SolucionServiceImpl implements ISolucionService{

    @Autowired
    private ISolucionDao solucionDao;

    @Override
    public List<Solucion> findAll() {
        
        return (List<Solucion>) solucionDao.findAll();
    }

    @Override
    public void save(Solucion solucion) {
       
        solucionDao.save(solucion);
    }

    @Override
    public Solucion findOne(Long id) {
        
        return solucionDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        
        solucionDao.deleteById(id);
    }

    public ISolucionDao getSolucionDao() {
        return solucionDao;
    }

    public void setSolucionDao(ISolucionDao solucionDao) {
        this.solucionDao = solucionDao;
    }
    
}
