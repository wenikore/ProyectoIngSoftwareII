/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.services;

import com.co.crm.entities.Contacto;
import com.co.crm.entities.Persona;
import com.co.crm.facades.ContactoFacade;
import java.util.List;
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

    public void persistirContactoServicio(String contactoEstado, String contactoEtapa, Persona persona) {

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

    /*Este método retorna la lista de 'Contactos' hallados por nombre y apellidos*/
    public List<Contacto> buscarContactoPorNombreApellidoServicio(String txtBusqueda, int first, int pageSize) {
        List<Contacto> contactosPorNombreApellido;
        contactosPorNombreApellido = contactoFacade.buscarContactoPorNombreApellido(txtBusqueda, first, pageSize);
        return contactosPorNombreApellido;
    }

    /*Este método guarda los cambios en los campos en un 'Contacto'*/
    public void actualizarContactoServicio(Contacto contactoModificar) {
        contactoFacade.actualizar(contactoModificar);

    }

    /*Esta funcion trae una lista de un(1) 'Contacto encontrado por identificación'*/
    public List<Contacto> buscarContactoPorIdentificacionServicio(String txtBusqueda) {
        List<Contacto> contactosHallados;
        contactosHallados = contactoFacade.buscarContactoPorIdentificacionAndEstado(txtBusqueda);
        return contactosHallados;
    }
   
    /*Este método busca un único 'Contacto' por identificacion*/
    public Long buscarContactoPorCedulaServicio(String identificacion)
    {
    Contacto contacto;
    contacto = contactoFacade.buscarContactoPorIdentificacion(identificacion);
    return contacto.getId();
    }    
}
