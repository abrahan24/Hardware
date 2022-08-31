package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IBajaDao;
import com.hardware.SystemUsic.models.entity.Baja;

@Service
public class BajaServiceImpl implements IBajaService{

    @Autowired
    private IBajaDao bajaDao;

    @Override
    public List<Baja> findAll() {
        
        return (List<Baja>) bajaDao.findAll();
    }

    @Override
    public void save(Baja baja) {
        
        bajaDao.save(baja);
        
    }

    @Override
    public Baja findOne(Long id) {
       
        return bajaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
      
        bajaDao.deleteById(id);
        
    }
}
