/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.components;

import com.co.crm.entities.Seguimiento;
import com.co.crm.entities.Usuario;

/**
 *
 * @author andre
 */
public class SeguimientoInformacionMmb {
    
    private Seguimiento seguimiento;
    private Usuario Vendedor;
    
    /*Getters & Setters*/

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }

    public Usuario getVendedor() {
        return Vendedor;
    }

    public void setVendedor(Usuario Vendedor) {
        this.Vendedor = Vendedor;
    }
    
    
    
    
}
