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
@Table(name = "solucionEquipo")
public class SolucionEquipo implements Serializable{

    private static final long serialVersionUID = 2629195288020321924L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_solucionEquipo;
    private Character estado;

//Tabla Tipo Equipo
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipoequipo")
    private TipoEquipo tipoEquipo ;

//Tabla Solucion
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_solucion")
    private Solucion solucion;

    public Long getId_solucionEquipo() {
        return id_solucionEquipo;
    }

    public void setId_solucionEquipo(Long id_solucionEquipo) {
        this.id_solucionEquipo = id_solucionEquipo;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public Solucion getSolucion() {
        return solucion;
    }

    public void setSolucion(Solucion solucion) {
        this.solucion = solucion;
    }

   

    
}
