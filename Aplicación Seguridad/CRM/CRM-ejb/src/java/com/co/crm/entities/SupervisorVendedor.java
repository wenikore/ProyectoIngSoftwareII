/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name="Supervisor_Vendedor")
public class SupervisorVendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="supervisor_vendedor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="supervisor_id")
    private Long supervisorId;
    
    @Column(name="vendedor_id")
    private Long vendedorId;
    
    /*Getters & Setters*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupervisorVendedor)) {
            return false;
        }
        SupervisorVendedor other = (SupervisorVendedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.crm.entities.SupervisorVendedor[ id=" + id + " ]";
    }
    
}
