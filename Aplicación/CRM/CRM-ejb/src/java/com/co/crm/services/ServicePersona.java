/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.services;

import com.co.crm.Ifacades.PersonaFacadeLocal;
import com.co.crm.Iservices.ServicePersonaLocal;
import com.co.crm.entities.Persona;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class ServicePersona implements ServicePersonaLocal{

    @Inject
    private PersonaFacadeLocal personaFacadeLocal;
    
    @Override
    public Persona crearPersona(Persona persona) {
        
        personaFacadeLocal.create(persona);
       
        return persona;
        
    }
    
}
