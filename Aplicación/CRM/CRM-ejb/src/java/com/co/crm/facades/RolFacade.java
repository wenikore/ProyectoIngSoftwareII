/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.facades;

import com.co.crm.entities.Rol;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class RolFacade extends PersistentManager<Rol> {

    /*Este método persiste un 'Rol' en la base de datos*/
    public void persistirRol(Rol rolPersistir) {
        persistir(rolPersistir);
    }


    /*Este método actualiza un 'Rol' en la base de datos*/
    public void actualizarUsuario(Rol rolModificar) {
        actualizar(rolModificar);
    }

    /*Este método busca un 'Rol' por rolNombre*/
    public Rol buscarRolPorNombre(String nombreRol) {
        Query q = em.createNamedQuery("Rol.findByRolNombre", Rol.class).setParameter("rolNombre", nombreRol);
        Rol rolHallado = (Rol) q.getSingleResult();
        return rolHallado;
    }    
    
    public Rol buscarRolPorId(Long rolId)
    {
    Query q = em.createNamedQuery("Rol.findByRolId", Rol.class).setParameter("rolId", rolId);
    Rol rolHallado = (Rol)q.getSingleResult();
    return rolHallado;
    }
}
