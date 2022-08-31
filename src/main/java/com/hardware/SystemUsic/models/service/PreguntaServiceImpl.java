package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IPreguntaDao;
import com.hardware.SystemUsic.models.entity.Pregunta;
@Service
public class PreguntaServiceImpl implements IPreguntaService{

    @Autowired
    private IPreguntaDao preguntaDao;

    @Override
    public List<Pregunta> findAll() {
  
        return (List<Pregunta>) preguntaDao.findAll();
    }

    @Override
    public void save(Pregunta pregunta) {

        preguntaDao.save(pregunta);
    }

    @Override
    public Pregunta findOne(Long id) {

        return preguntaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
  
        preguntaDao.deleteById(id);
    }
    
}
