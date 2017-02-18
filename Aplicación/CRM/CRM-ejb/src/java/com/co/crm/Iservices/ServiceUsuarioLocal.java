/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.Iservices;

import com.co.crm.entities.Persona;
import com.co.crm.entities.Usuario;
import javax.ejb.Local;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Local
public interface ServiceUsuarioLocal {

    public void crearUsuario(Usuario usuario, Persona persona);
}
