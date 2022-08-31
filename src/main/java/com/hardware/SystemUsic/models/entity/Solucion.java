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
@Table(name = "solucion")
public class Solucion implements Serializable{
    private static final long serialVersionUID = 2629195288020321924L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_solucion;
    private String solucion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solucion", fetch = FetchType.LAZY)
	private List<DetalleSolucion> detalleSolucions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solucion", fetch = FetchType.LAZY)
	private List<SolucionEquipo> solucionEquipos;

    public Long getId_solucion() {
        return id_solucion;
    }

    public void setId_solucion(Long id_solucion) {
        this.id_solucion = id_solucion;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public List<DetalleSolucion> getDetalleSolucions() {
        return detalleSolucions;
    }

    public void setDetalleSolucions(List<DetalleSolucion> detalleSolucions) {
        this.detalleSolucions = detalleSolucions;
    }

    public List<SolucionEquipo> getSolucionEquipos() {
        return solucionEquipos;
    }

    public void setSolucionEquipos(List<SolucionEquipo> solucionEquipos) {
        this.solucionEquipos = solucionEquipos;
    }

    
}
