package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IDetalleSolucionDao;
import com.hardware.SystemUsic.models.entity.DetalleSolucion;

@Service
public class DetalleSolucionServiceImpl implements IDetalleSolucionService{

    @Autowired
    private IDetalleSolucionDao detalleSolucionDao;

    @Override
    public List<DetalleSolucion> findAll() {
        
        return (List<DetalleSolucion>) detalleSolucionDao.findAll();
    }

    @Override
    public void save(DetalleSolucion detalleSolucion) {
        
        detalleSolucionDao.save(detalleSolucion);
    }

    @Override
    public DetalleSolucion findOne(Long id) {
        
        return detalleSolucionDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        
        detalleSolucionDao.deleteById(id);
    }
    
}
