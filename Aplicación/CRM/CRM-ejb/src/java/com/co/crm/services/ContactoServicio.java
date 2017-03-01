/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.services;

import com.co.crm.entities.Contacto;
import com.co.crm.entities.Persona;
import com.co.crm.facades.ContactoFacade;
import java.util.Date;
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

    public void persistirContacroServicio(String contactoEstado, String identificacion, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Date fechaNacimiento, String Direccion, String telefonoMovil, String telefonoFijo) {
        Persona personaPersistir = new Persona();
        Contacto contactoPersistir = new Contacto();


        /*Se llena la 'Persona' del 'Contacto'*/
        personaPersistir.setIdentificacion(identificacion);
        personaPersistir.setPrimerNombre(primerNombre);
        personaPersistir.setSegundoNombre(segundoNombre);
        personaPersistir.setPrimerApellido(primerApellido);
        personaPersistir.setSegundoApellido(segundoApellido);
        personaPersistir.setFechaNacimiento(fechaNacimiento);
        personaPersistir.setDireccion(Direccion);
        personaPersistir.setTelefonoFijo(telefonoFijo);
        personaPersistir.setTelefonoMovil(telefonoMovil);
        personaServicio.persistirPersonaServicio(personaPersistir);

        /*Se llena el objeto 'Contacto' para que esté en contexto de Persistencia*/
        contactoPersistir.setPersona(personaPersistir);
        contactoPersistir.setEstado(contactoEstado);
        /*Se persiste el 'Contacto'*/
        contactoFacade.persistirContacto(contactoPersistir);
    }
}
