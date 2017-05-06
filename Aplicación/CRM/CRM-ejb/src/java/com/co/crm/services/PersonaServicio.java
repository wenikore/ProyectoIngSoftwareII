/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.services;

import com.co.crm.entities.Persona;
import com.co.crm.facades.PersonaFacade;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class PersonaServicio {

    @Inject
    PersonaFacade personaFacade;

    /*Este método persiste una 'Persona'*/
    public void persistirPersonaServicio(Persona personaPersistir) {
        personaFacade.persistirPersona(personaPersistir);
    }

    /*Este método busca una 'Persona' por un texto de búsqueda*/
    public Persona buscarPersonaPorNombresOApellidos(String txtBusqueda) {
        Persona personaHallada;
        personaHallada = personaFacade.buscarPersonaPorIdentificacion(txtBusqueda);
        return personaHallada;
    }

    /*Este método busca una persona por identificación*/
    public Persona buscarPersonaPorIdentificacion(String identificacion) {
        Persona personaHallada;
        personaHallada = personaFacade.buscarPersonaPorIdentificacion(identificacion);

        return personaHallada;
    }

    /*Este método actualiza una 'Persona' en la base de datos*/
    public void actualizarPersonaServicio(Persona personaActualizar) {
        personaFacade.actualizarPersona(personaActualizar);
    }

    /*Este método Busca una persona por id*/
    public Persona buscarPorIdServicio(Long id) {
        Persona persona;
        persona = personaFacade.buscarPorId(id);
        return persona;
    }

}
