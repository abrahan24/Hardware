package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IColaboradorDao;
import com.hardware.SystemUsic.models.entity.Colaborador;
@Service
public class ColaboradorServiceImpl implements IColaboradorService{

    @Autowired
    private IColaboradorDao colaboradorDao;


    @Override
    public List<Colaborador> findAll() {

        return (List<Colaborador>) colaboradorDao.findAll();
    }

    @Override
    public void save(Colaborador colaborador) {
      
        colaboradorDao.save(colaborador);
    }

    @Override
    public Colaborador findOne(Long id) {
       
        return colaboradorDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
       
        colaboradorDao.deleteById(id);
    }
    
}
