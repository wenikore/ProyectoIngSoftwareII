/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.services;

import com.co.crm.Ifacades.RolFacadeLocal;
import com.co.crm.Iservices.ServiceRolLocal;
import com.co.crm.entities.Rol;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class ServiceRol implements ServiceRolLocal {

    @Inject
    private RolFacadeLocal rolFacadeLocal;

    @Override
    public Rol buscarRolPorNombre(String nombreRol) {

        Rol rolHallado;

        rolHallado = rolFacadeLocal.buscarRolPorNombre(nombreRol);

        return rolHallado;
    }

}
