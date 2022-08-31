package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IProcedenciaDao;
import com.hardware.SystemUsic.models.entity.Procedencia;
@Service
public class ProcedenciaServiceImpl implements IProcedenciaService{

    @Autowired
    private IProcedenciaDao procedenciaDao;

    @Override
    public List<Procedencia> findAll() {

        return (List<Procedencia>) procedenciaDao.findAll();
    }

    @Override
    public void save(Procedencia procedencia) {

        procedenciaDao.save(procedencia);
    }

    @Override
    public Procedencia findOne(Long id) {
   
        return procedenciaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
   
        procedenciaDao.deleteById(id);
    }
    
}
