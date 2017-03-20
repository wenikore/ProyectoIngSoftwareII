/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.facades;

import com.co.crm.entities.Contacto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class ContactoFacade extends PersistentManager<Contacto> {

    /*Este método persiste un 'Contacto' en la base de datos*/
    public void persistirContacto(Contacto contactoPersistir) {
        persistir(contactoPersistir);
    }


    /*Este método actualiza un 'Contacto' en la base de datos*/
    public void actualizarContacto(Contacto contactoModificar) {
        actualizar(contactoModificar);
    }

    /*Este método retorna una lista de 'Contacto' filtrados por nombres y apellidos o identificacion*/
    public List<Contacto> buscarContactoPorNombreApellido(String txtBusqueda, int startAt, int maxPerPage) {
        Query q = em.createQuery("SELECT C FROM Contacto C WHERE C.persona.identificacion LIKE :txtBusqueda OR C.persona.primerNombre LIKE :txtBusqueda OR C.persona.primerApellido LIKE :txtBusqueda OR C.persona.segundoApellido LIKE :txtBusqueda OR C.persona.primerApellido LIKE :txtBusqueda AND C.estado = :Estado");
        q.setParameter("txtBusqueda", "%" + txtBusqueda + "%");
        q.setParameter("Estado", "I");
        q.setFirstResult(startAt);
        q.setMaxResults(maxPerPage);
        return q.getResultList();
    }

    /*Busca un 'Contacto' por  identificación y estado 'A' (Estado activo)*/
    public List<Contacto> buscarContactoPorIdentificacionAndEstado(String txtBusqueda) {
        Query q = em.createQuery("SELECT C FROM Contacto C WHERE C.persona.identificacion = :txtBusqueda AND C.estado = :Estado");
        q.setParameter("txtBusqueda", txtBusqueda);
        q.setParameter("Estado", "A");
        return q.getResultList();
    }
}
