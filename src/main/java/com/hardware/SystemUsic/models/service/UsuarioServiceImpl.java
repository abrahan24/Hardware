package com.hardware.SystemUsic.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.SystemUsic.models.dao.IUsuarioDao;
import com.hardware.SystemUsic.models.entity.Usuario;
@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    public List<Usuario> findAll() {
       
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public void save(Usuario usuario) {
       
        usuarioDao.save(usuario);
    }

    @Override
    public Usuario findOne(Long id) {
       
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        
        usuarioDao.deleteById(id);
    }

    @Override
    public Usuario getUsuario(String usuario, String contrasena) {
        return usuarioDao.getUsuario(usuario, contrasena);
    }
    
}
