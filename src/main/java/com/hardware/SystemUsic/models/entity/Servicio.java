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
@Table(name = "servicio")

public class Servicio implements Serializable{
    private static final long serialVersionUID = 2629195288020321924L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servicio;
    private Date fecha_recepcion;
    private String estado;
    private String accesorio;
    private String observacion;
    private String recomendacion;
    private String conclucion;
    private String qr;
    private Date fecha_entrega;

//Tabla Persona   
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona")
    private Persona persona;
//Tabla Tipo Equipo
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipoequipo")
    private TipoEquipo tipoEquipo;
//Tabla Satisfaccion
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_satisfaccion")
    private Satisfaccion satisfaccion;
//Tabla Procedencia
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_procedencia")
    private Procedencia procedencia;
//Tabla Almacen
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_almacen")
    private Almacen almacen;
//Tabla Baja
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_baja")
    private Baja baja;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio", fetch = FetchType.LAZY)
	private List<Colaborador> colaboradores;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio", fetch = FetchType.LAZY)
	private List<DetalleFalla> detalleFallas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio", fetch = FetchType.LAZY)
	private List<DetalleSolucion> detalleSolucions;

    public Long getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Long id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Date getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Date fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public Satisfaccion getSatisfaccion() {
        return satisfaccion;
    }

    public void setSatisfaccion(Satisfaccion satisfaccion) {
        this.satisfaccion = satisfaccion;
    }

    public Procedencia getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(Procedencia procedencia) {
        this.procedencia = procedencia;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public List<DetalleFalla> getDetalleFallas() {
        return detalleFallas;
    }

    public void setDetalleFallas(List<DetalleFalla> detalleFallas) {
        this.detalleFallas = detalleFallas;
    }

    public String getAccesorio() {
        return accesorio;
    }

    public void setAccesorio(String accesorio) {
        this.accesorio = accesorio;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public List<DetalleSolucion> getDetalleSolucions() {
        return detalleSolucions;
    }

    public void setDetalleSolucions(List<DetalleSolucion> detalleSolucions) {
        this.detalleSolucions = detalleSolucions;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public String getConclucion() {
        return conclucion;
    }

    public void setConclucion(String conclucion) {
        this.conclucion = conclucion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Baja getBaja() {
        return baja;
    }

    public void setBaja(Baja baja) {
        this.baja = baja;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }


}
