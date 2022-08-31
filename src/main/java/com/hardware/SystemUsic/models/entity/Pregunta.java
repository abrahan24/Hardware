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
@Table(name = "pregunta")
public class Pregunta implements Serializable{
    private static final long serialVersionUID = 2629195288020321924L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pregunta;
    private String pregunta;
    private Character estado;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pregunta", fetch = FetchType.LAZY)
	private List<Satisfaccion> satisfaccions;


    public Long getId_pregunta() {
        return id_pregunta;
    }


    public void setId_pregunta(Long id_pregunta) {
        this.id_pregunta = id_pregunta;
    }


    public String getPregunta() {
        return pregunta;
    }


    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }


    public Character getEstado() {
        return estado;
    }


    public void setEstado(Character estado) {
        this.estado = estado;
    }


    public List<Satisfaccion> getSatisfaccions() {
        return satisfaccions;
    }


    public void setSatisfaccions(List<Satisfaccion> satisfaccions) {
        this.satisfaccions = satisfaccions;
    }

    
}
