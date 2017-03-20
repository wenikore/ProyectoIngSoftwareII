/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.facades;

import com.co.crm.entities.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class PersonaFacade extends PersistentManager<Persona> {

    /*Este método persiste una 'Persona' en la base de datos*/
    public void persistirPersona(Persona personaPersistir) {
        persistir(personaPersistir);

    }

    /*Este método actualiza una 'Persona' en la base de datos*/
    public void actualizarPersona(Persona personaModificar) {
        actualizar(personaModificar);

    }

    /*Este método busca una 'Persona' por 'personaIdentificación'*/
    public Persona buscarPersonaPorIdentificacion(String personaIdentificacion) {
        Query q = em.createNamedQuery("Persona.findByPersonaIdentificacion", Persona.class).setParameter("personaIdentificacion", personaIdentificacion);
        Persona personaHallada = (Persona) q.getSingleResult();

        return personaHallada;
    }

    /*Este método busca una 'Persona' por nombre y/o Apellidos*/
    public List<Persona> buscarPersonaPorNombreOApellidos(String textoBusqueda) {
        Query q = em.createQuery("SELECT p FROM Persona p WHERE p.personaPrimernombre LIKE :txtBusqueda OR p.personaSegundonombre LIKE :txtBusqueda OR p.personaPrimerapellido LIKE :txtBusqueda OR p.personaSegundoapellido LIKE :txtBusqueda");
        q.setParameter("txtBusqueda", "%" + textoBusqueda + "%");
        return q.getResultList();

    }
}
