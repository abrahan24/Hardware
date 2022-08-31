package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IDetalleFallaDao;
import com.hardware.SystemUsic.models.entity.DetalleFalla;
@Service
public class DetalleFallaServiceImpl implements IDetalleFallaService{

    @Autowired
    private IDetalleFallaDao detalleFallaDao;

    @Override
    public List<DetalleFalla> findAll() {

        return (List<DetalleFalla>) detalleFallaDao.findAll();
    }

    @Override
    public void save(DetalleFalla detalleFalla) {
      
        detalleFallaDao.save(detalleFalla);
    }

    @Override
    public DetalleFalla findOne(Long id) {
       
        return detalleFallaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
       
        detalleFallaDao.deleteById(id);
    }
    
}
