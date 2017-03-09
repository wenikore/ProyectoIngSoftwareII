/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.services;

import com.co.crm.entities.Rol;
import com.co.crm.facades.RolFacade;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author andre
 */
@Stateless
public class RolServicio {
    @Inject
    RolFacade rolFacade;
    
    public Rol buscarRolPorNombreServicio(String nombreRol)
    {
    Rol rolHallado;
    rolHallado = rolFacade.buscarRolPorNombre(nombreRol);
    return rolHallado;
    }
    
}
