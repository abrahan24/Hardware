package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.ISatisfaccionDao;
import com.hardware.SystemUsic.models.entity.Satisfaccion;
@Service
public class SatisfaccionServiceImpl implements ISatisfaccionService{

    @Autowired
    private ISatisfaccionDao satisfaccionDao;

    @Override
    public List<Satisfaccion> findAll() {

        return (List<Satisfaccion>) satisfaccionDao.findAll();
    }

    @Override
    public void save(Satisfaccion satisfaccion) {

        satisfaccionDao.save(satisfaccion);
    }

    @Override
    public Satisfaccion findOne(Long id) {
       
        return satisfaccionDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
  
        satisfaccionDao.deleteById(id);
    }
    
}
