/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.facades;

import com.co.crm.Ifacades.ContactoFacadeLocal;
import com.co.crm.entities.Contacto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class ContactoFacade extends AbstractFacade<Contacto> implements ContactoFacadeLocal{
    
    @PersistenceContext(unitName = "unidad_persistencia_general")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactoFacade() {
        super(Contacto.class);
    }
    
    
}
