package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IFallaDao;
import com.hardware.SystemUsic.models.entity.Falla;
@Service
public class FallaServiceImpl implements IFallaService{

    @Autowired
    private IFallaDao fallaDao;

    @Override
    public List<Falla> findAll() {

        return (List<Falla>) fallaDao.findAll();
    }

    @Override
    public void save(Falla falla) {
  
        fallaDao.save(falla);
    }

    @Override
    public Falla findOne(Long id) {
       
        return fallaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
       
        fallaDao.deleteById(id);
    }
    
}
