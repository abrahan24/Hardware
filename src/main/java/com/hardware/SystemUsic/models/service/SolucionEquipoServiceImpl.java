package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.ISolucionEquipoDao;
import com.hardware.SystemUsic.models.entity.SolucionEquipo;

@Service
public class SolucionEquipoServiceImpl implements ISolucionEquipoService{

    @Autowired
    private ISolucionEquipoDao solucionEquipoDao;

    @Override
    public List<SolucionEquipo> findAll() {
        
        return (List<SolucionEquipo>) solucionEquipoDao.findAll();
    }

    @Override
    public void save(SolucionEquipo solucionEquipo) {
        
        solucionEquipoDao.save(solucionEquipo);
    }

    @Override
    public SolucionEquipo findOne(Long id) {
        
        return solucionEquipoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        
        solucionEquipoDao.deleteById(id);
    }
    
}
