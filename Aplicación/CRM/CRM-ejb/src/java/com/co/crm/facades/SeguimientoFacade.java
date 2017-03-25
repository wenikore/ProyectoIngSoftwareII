/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.facades;

import com.co.crm.entities.Contacto;
import com.co.crm.entities.Seguimiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class SeguimientoFacade extends PersistentManager<Seguimiento> {

    /*Este método busca los seguimientos por un 'contacto' dado*/
    public List<Seguimiento> buscarSeguimientosPorContacto(Contacto contacto) {
        List<Seguimiento> seguimientosPorContacto;
        Query q = em.createQuery("SELECT s FROM Seguimiento s WHERE s.contacto = :contacto");
        q.setParameter("contacto", contacto);
        seguimientosPorContacto = q.getResultList();
        return seguimientosPorContacto;
    }

    /*Este método persiste un 'Seguimiento'*/
    public void persistirSeguimiento(Seguimiento seguimiento) {
        em.persist(seguimiento);
    }

    /*Este método actualizar un 'Seguimiento'*/
    public void actualizarSeguimiento(Seguimiento seguimiento) {
        em.merge(seguimiento);
    }
}
