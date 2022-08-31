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
@Table(name = "tipoequipo")
public class TipoEquipo implements Serializable{
    private static final long serialVersionUID = 2629195288020321924L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipoequipo;
    private String equipo;
    private String icono;
    private String imagen;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEquipo", fetch = FetchType.LAZY)
	private List<Almacen> almacenes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEquipo", fetch = FetchType.LAZY)
	private List<Servicio> servicios;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEquipo", fetch = FetchType.LAZY)
	private List<FallaEquipo> fallaEquipos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEquipo", fetch = FetchType.LAZY)
	private List<SolucionEquipo> solucionEquipos;

    public Long getId_tipoequipo() {
        return id_tipoequipo;
    }

    public void setId_tipoequipo(Long id_tipoequipo) {
        this.id_tipoequipo = id_tipoequipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Almacen> getAlmacenes() {
        return almacenes;
    }

    public void setAlmacenes(List<Almacen> almacenes) {
        this.almacenes = almacenes;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<FallaEquipo> getFallaEquipos() {
        return fallaEquipos;
    }

    public void setFallaEquipos(List<FallaEquipo> fallaEquipos) {
        this.fallaEquipos = fallaEquipos;
    }

    public List<SolucionEquipo> getSolucionEquipos() {
        return solucionEquipos;
    }

    public void setSolucionEquipos(List<SolucionEquipo> solucionEquipos) {
        this.solucionEquipos = solucionEquipos;
    }


    
}
