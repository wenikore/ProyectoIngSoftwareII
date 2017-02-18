/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.Iservices;

import com.co.crm.entities.Contacto;
import javax.ejb.Local;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Local
public interface ServiceContactoLocal {

    public Contacto crearContacto(Contacto contacto);
}
