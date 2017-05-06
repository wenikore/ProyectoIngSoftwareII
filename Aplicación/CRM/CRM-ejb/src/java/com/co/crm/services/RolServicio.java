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

    /*Este método busca un "Rol" por nombre*/
    public Rol buscarRolPorNombreServicio(String nombreRol) {
        Rol rolHallado;
        rolHallado = rolFacade.buscarRolPorNombre(nombreRol);
        return rolHallado;
    }

    /*Este método busca un "Rol" por id*/
    public Rol buscarRolPorId(Long idRol) {
        Rol rolHallado;
        rolHallado = rolFacade.buscarRolPorId(idRol);
        return rolHallado;
    }
}
