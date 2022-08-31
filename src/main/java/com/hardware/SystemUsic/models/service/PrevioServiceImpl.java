package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IPrevioDao;
import com.hardware.SystemUsic.models.entity.Previo;

@Service
public class PrevioServiceImpl implements IPrevioService{

    @Autowired
    private IPrevioDao previoDao;

    @Override
    public List<Previo> findAll() {
        
        return (List<Previo>) previoDao.findAll();
    }

    @Override
    public void save(Previo previo) {
       
       previoDao.save(previo);
    }

    @Override
    public Previo findOne(Long id) {
        
        return previoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
       
        previoDao.deleteById(id);
    }
    
}
