package com.hardware.SystemUsic.models.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "detallefalla")
public class DetalleFalla implements Serializable{
    private static final long serialVersionUID = 2629195288020321924L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detallefalla;
    private Date fecha_registro;
//Tabla Falla
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_falla")
    private Falla falla;
//Tabla Servicio
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_servicio")
    private Servicio servicio;


    
    public Long getId_detallefalla() {
        return id_detallefalla;
    }
    public void setId_detallefalla(Long id_detallefalla) {
        this.id_detallefalla = id_detallefalla;
    }
    public Date getFecha_registro() {
        return fecha_registro;
    }
    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    public Falla getFalla() {
        return falla;
    }
    public void setFalla(Falla falla) {
        this.falla = falla;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }




    
}
