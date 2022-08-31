package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IServicioDao;
import com.hardware.SystemUsic.models.entity.Servicio;
@Service
public class ServicioServiceImpl implements IServicioService{

    @Autowired
    private IServicioDao servicioDao;

    @Override
    public List<Servicio> findAll() {

        return (List<Servicio>) servicioDao.findAll();
    }

    @Override
    public void save(Servicio servicio) {
     
        servicioDao.save(servicio);
    }

    @Override
    public Servicio findOne(Long id) {
  
        return servicioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        
        servicioDao.deleteById(id);
    }

    @Override
    public List<Servicio> getAllServicioUsuario(Long id_procedencia) {
        
        return servicioDao.getAllServicioUsuario(id_procedencia);
    }
    
}
