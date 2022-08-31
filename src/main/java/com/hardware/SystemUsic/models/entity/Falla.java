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
@Table(name = "falla")
public class Falla implements Serializable{
    private static final long serialVersionUID = 2629195288020321924L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_falla;
    private String falla;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "falla", fetch = FetchType.LAZY)
	private List<DetalleFalla> detallefallas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "falla", fetch = FetchType.LAZY)
	private List<FallaEquipo> fallaEquipos;

    public Long getId_falla() {
        return id_falla;
    }

    public void setId_falla(Long id_falla) {
        this.id_falla = id_falla;
    }

    public String getFalla() {
        return falla;
    }

    public void setFalla(String falla) {
        this.falla = falla;
    }

    public List<DetalleFalla> getDetallefallas() {
        return detallefallas;
    }

    public void setDetallefallas(List<DetalleFalla> detallefallas) {
        this.detallefallas = detallefallas;
    }

    public List<FallaEquipo> getFallaEquipos() {
        return fallaEquipos;
    }

    public void setFallaEquipos(List<FallaEquipo> fallaEquipos) {
        this.fallaEquipos = fallaEquipos;
    }

    
}
