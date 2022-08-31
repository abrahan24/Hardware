package com.hardware.SystemUsic.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "satisfaccion")
public class Satisfaccion implements Serializable{
    private static final long serialVersionUID = 2629195288020321924L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_satisfaccion;
    private Double calificacion;
//Tabla Pregunta
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pregunta")
    private Pregunta pregunta;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "satisfaccion", fetch = FetchType.LAZY)
	private List<Servicio> servicios;

    public Long getId_satisfaccion() {
        return id_satisfaccion;
    }

    public void setId_satisfaccion(Long id_satisfaccion) {
        this.id_satisfaccion = id_satisfaccion;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    
}
