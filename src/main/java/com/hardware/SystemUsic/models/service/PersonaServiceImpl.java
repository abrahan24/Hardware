package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IPersonaDao;
import com.hardware.SystemUsic.models.entity.Persona;
@Service
public class PersonaServiceImpl implements IPersonaService{

    @Autowired
    private IPersonaDao personaDao;

    @Override
    public List<Persona> findAll() {

        return (List<Persona>) personaDao.findAll();
    }

    @Override
    public void save(Persona persona) {
       
        personaDao.save(persona);
    }

    @Override
    public Persona findOne(Long id) {

        return personaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {

        personaDao.deleteById(id);
    }

    @Override
    public Persona getCIpersona(String ci) {
        
        return personaDao.getCIpersona(ci);
    }
    
}
