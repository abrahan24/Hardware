package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.ICargoDao;
import com.hardware.SystemUsic.models.entity.Cargo;
@Service
public class CargoServiceImpl implements ICargoService{

    @Autowired
    private ICargoDao cargoDao;

    @Override
    public List<Cargo> findAll() {
 
        return (List<Cargo>) cargoDao.findAll();
    }

    @Override
    public void save(Cargo cargo) {
     
        cargoDao.save(cargo);
    }

    @Override
    public Cargo findOne(Long id) {
    
        return cargoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
  
        cargoDao.deleteById(id);
    }
    
}
