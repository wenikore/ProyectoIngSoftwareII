/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Andrés
 */
@Entity
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="tarea_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="tarea_descripcion")
    private String tareaDescripcion;
    
    @Column(name="tarea_estado")
    private String estado;
    
    @Column(name="tarea_actividad")
    private String actividad;
    
    
    @Column(name="tarea_fecha_creacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion;
    
    
    @Column(name="tarea_fecha_cierre")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCierre;
    
    @OneToOne
    @JoinColumn(name="seguimiento_id")
    private Seguimiento seguimiento;
    
    /*Getters & Setters*/
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTareaDescripcion() {
        return tareaDescripcion;
    }

    public void setTareaDescripcion(String tareaDescripcion) {
        this.tareaDescripcion = tareaDescripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
        
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.crm.entities.Tarea[ id=" + id + " ]";
    }
    
}
