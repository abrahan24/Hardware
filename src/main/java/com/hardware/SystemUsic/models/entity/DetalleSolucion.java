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
@Table(name = "detalleSolucion")
public class DetalleSolucion implements Serializable {

    private static final long serialVersionUID = 2629195288020321924L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalleSolucion;

//Tabla Solucion
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_solucion")
    private Solucion solucion;

//Tabla Servicio
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_servicio")
    private Servicio servicio;

    public Long getId_detalleSolucion() {
        return id_detalleSolucion;
    }

    public void setId_detalleSolucion(Long id_detalleSolucion) {
        this.id_detalleSolucion = id_detalleSolucion;
    }

    public Solucion getSolucion() {
        return solucion;
    }

    public void setSolucion(Solucion solucion) {
        this.solucion = solucion;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    
}
