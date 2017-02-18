/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.facades;

import com.co.crm.Ifacades.RolFacadeLocal;
import com.co.crm.entities.Rol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class RolFacade extends AbstractFacade<Rol> implements RolFacadeLocal {

    @PersistenceContext(unitName = "unidad_persistencia_general")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }

    @Override
    public Rol buscarRolPorNombre(String nombreRol) {
        Query query = em.createNamedQuery("Select R.nombre FROM Rol R WHERE  P.nombre =:nombreRol");
        query.setParameter("nombreRol", nombreRol);
        Rol rolHallado;
        rolHallado = (Rol) query.getSingleResult();

        return rolHallado;
    }

}
