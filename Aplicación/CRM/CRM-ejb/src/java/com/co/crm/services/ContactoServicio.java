/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.services;

import com.co.crm.entities.Contacto;
import com.co.crm.entities.Persona;
import com.co.crm.facades.ContactoFacade;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class ContactoServicio {

    @Inject
    ContactoFacade contactoFacade;
    @Inject
    PersonaServicio personaServicio;

    public void persistirContactoServicio(String contactoEstado,String contactoEtapa,Persona persona) {

        Contacto contactoPersistir = new Contacto();


        /*Se persiste la 'Persona' del 'Contacto'*/

        personaServicio.persistirPersonaServicio(persona);

        /*Se llena el objeto 'Contacto' para que esté en contexto de Persistencia*/
        contactoPersistir.setPersona(persona);
        contactoPersistir.setEstado(contactoEstado);
        contactoPersistir.setEtapa(contactoEtapa);
        /*Se persiste el 'Contacto'*/
        contactoFacade.persistirContacto(contactoPersistir);
    }
}
