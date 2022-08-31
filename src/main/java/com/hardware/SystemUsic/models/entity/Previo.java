package com.hardware.SystemUsic.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "previo")
public class Previo implements Serializable {
    private static final long serialVersionUID = 2629195288020321924L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_previo;
    private Character estado;
    private Integer correlativo;

//Tabla Unidad
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_unidad")
    private Unidad unidad;
//Tabla Procedencia
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_procedencia")
    private Procedencia procedencia;
//Tabla Usuario
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    public Long getId_previo() {
        return id_previo;
    }
    public void setId_previo(Long id_previo) {
        this.id_previo = id_previo;
    }
    public Character getEstado() {
        return estado;
    }
    public void setEstado(Character estado) {
        this.estado = estado;
    }
    public Unidad getUnidad() {
        return unidad;
    }
    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
    public Procedencia getProcedencia() {
        return procedencia;
    }
    public void setProcedencia(Procedencia procedencia) {
        this.procedencia = procedencia;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Integer getCorrelativo() {
        return correlativo;
    }
    public void setCorrelativo(Integer correlativo) {
        this.correlativo = correlativo;
    }
    
}
