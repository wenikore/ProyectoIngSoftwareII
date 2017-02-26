/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author samuel
 */
@Entity
@Table(name = "contacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c")
    , @NamedQuery(name = "Contacto.findByContactoId", query = "SELECT c FROM Contacto c WHERE c.contactoId = :contactoId")
    , @NamedQuery(name = "Contacto.findByContactoEstado", query = "SELECT c FROM Contacto c WHERE c.contactoEstado = :contactoEstado")})
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contacto_id")
    private Integer contactoId;
    @Size(max = 2147483647)
    @Column(name = "contacto_estado")
    private String contactoEstado;
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id")
    @ManyToOne
    private Persona personaId;

    public Contacto() {
    }

    public Contacto(Integer contactoId) {
        this.contactoId = contactoId;
    }

    public Integer getContactoId() {
        return contactoId;
    }

    public void setContactoId(Integer contactoId) {
        this.contactoId = contactoId;
    }

    public String getContactoEstado() {
        return contactoEstado;
    }

    public void setContactoEstado(String contactoEstado) {
        this.contactoEstado = contactoEstado;
    }

    public Persona getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Persona personaId) {
        this.personaId = personaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactoId != null ? contactoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.contactoId == null && other.contactoId != null) || (this.contactoId != null && !this.contactoId.equals(other.contactoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.crm.entities.Contacto[ contactoId=" + contactoId + " ]";
    }
    
}
