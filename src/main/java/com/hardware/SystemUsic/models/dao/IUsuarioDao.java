package com.hardware.SystemUsic.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hardware.SystemUsic.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

    @Query("select us from Usuario us where us.usuario=?1 and us.contrasena=?2")
    public Usuario getUsuario(String usuario,String contrasena);
    
}
