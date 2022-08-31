package com.hardware.SystemUsic.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
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
import javax.xml.crypto.Data;

@Entity
@Table(name = "almacen")
public class Almacen implements Serializable{
    private static final long serialVersionUID = 2629195288020321924L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_almacen;
    private Character estado;
    private String cod_equipo;
    private Date fecha_adquisicion;
    private String descripcion;
    private String modelo;
    private String serie;
    private String marca;

//Tabla TipoEquipo
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipoequipo")
    private TipoEquipo tipoEquipo;
//Tabla Baja
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_baja")
    private Baja baja;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almacen", fetch = FetchType.LAZY)
	private List<Servicio> servicios;

    public Long getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(Long id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getCod_equipo() {
        return cod_equipo;
    }

    public void setCod_equipo(String cod_equipo) {
        this.cod_equipo = cod_equipo;
    }

    public Date getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    public void setFecha_adquisicion(Date fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Baja getBaja() {
        return baja;
    }

    public void setBaja(Baja baja) {
        this.baja = baja;
    }
    
}
