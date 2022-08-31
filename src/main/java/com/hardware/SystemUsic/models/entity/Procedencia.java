package com.hardware.SystemUsic.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "procedencia")
public class Procedencia implements Serializable{
    private static final long serialVersionUID = 2629195288020321924L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_procedencia;
    private String procedencia;
    private Character estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedencia", fetch = FetchType.LAZY)
	private List<Servicio> servicios;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedencia", fetch = FetchType.LAZY)
	private List<Previo> previos;

    public Long getId_procedencia() {
        return id_procedencia;
    }

    public void setId_procedencia(Long id_procedencia) {
        this.id_procedencia = id_procedencia;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<Previo> getPrevios() {
        return previos;
    }

    public void setPrevios(List<Previo> previos) {
        this.previos = previos;
    }

    
}
