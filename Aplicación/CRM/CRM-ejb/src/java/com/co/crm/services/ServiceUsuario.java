/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.services;

import com.co.crm.Ifacades.UsuarioFacadeLocal;
import com.co.crm.Iservices.ServiceUsuarioLocal;
import com.co.crm.entities.Persona;
import com.co.crm.entities.Usuario;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class ServiceUsuario implements ServiceUsuarioLocal {

    @Inject
    private UsuarioFacadeLocal usuarioFacadeLocal;

    @Override
    
    public void crearUsuario(Usuario usuario, Persona persona) {

    usuarioFacadeLocal.create(usuario);
    
    }

}
