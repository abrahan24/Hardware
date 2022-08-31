package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IDetalleDao;
import com.hardware.SystemUsic.models.entity.Detalle;
@Service
public class DetalleServiceImpl implements IDetalleService{

    @Autowired
    private IDetalleDao detalleDao;

    @Override
    public List<Detalle> findAll() {

        return (List<Detalle>) detalleDao.findAll();
    }

    @Override
    public void save(Detalle detalle) {
       
        detalleDao.save(detalle);
    }

    @Override
    public Detalle findOne(Long id) {
    
        return detalleDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
   
        detalleDao.deleteById(id);
    }
    
}
