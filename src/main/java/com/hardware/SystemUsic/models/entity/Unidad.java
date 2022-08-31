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
@Table(name = "unidad")
public class Unidad implements Serializable{
    private static final long serialVersionUID = 2629195288020321924L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_unidad;
    private String unidad;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidad", fetch = FetchType.LAZY)
	private List<Persona> personas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidad", fetch = FetchType.LAZY)
	private List<Previo> previos;


    public Long getId_unidad() {
        return id_unidad;
    }


    public void setId_unidad(Long id_unidad) {
        this.id_unidad = id_unidad;
    }


    public String getUnidad() {
        return unidad;
    }


    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }


    public List<Persona> getPersonas() {
        return personas;
    }


    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    
}
