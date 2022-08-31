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
@Table(name = "fallaequipo")
public class FallaEquipo implements Serializable{
    
    private static final long serialVersionUID = 2629195288020321924L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_fallaequipo;
    private Character estado;
//Tabla Tipo Equipo
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipoequipo")
    private TipoEquipo tipoEquipo ;
//Tabla Falla
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_falla")
    private Falla falla  ;

    
    public Long getId_fallaequipo() {
        return id_fallaequipo;
    }
    public void setId_fallaequipo(Long id_fallaequipo) {
        this.id_fallaequipo = id_fallaequipo;
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
    public Falla getFalla() {
        return falla;
    }
    public void setFalla(Falla falla) {
        this.falla = falla;
    }

    
}
