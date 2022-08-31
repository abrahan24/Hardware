package com.hardware.SystemUsic.models.entity;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "baja")
public class Baja implements Serializable{
    private static final long serialVersionUID = 2629195288020321924L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_baja;
    private Character estado;
    private Date fecha_baja;
    private String desarrollo;
    private String recomendacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baja", fetch = FetchType.LAZY)
	private List<Servicio> servicios;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baja", fetch = FetchType.LAZY)
	private List<Almacen> almacens;

    public Long getId_baja() {
        return id_baja;
    }

    public void setId_baja(Long id_baja) {
        this.id_baja = id_baja;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<Almacen> getAlmacens() {
        return almacens;
    }

    public void setAlmacens(List<Almacen> almacens) {
        this.almacens = almacens;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public String getDesarrollo() {
        return desarrollo;
    }

    public void setDesarrollo(String desarrollo) {
        this.desarrollo = desarrollo;
    }

}
