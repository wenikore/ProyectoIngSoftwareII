/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.facades;

import com.co.crm.entities.Seguimiento;
import com.co.crm.entities.Tarea;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class TareaFacade extends PersistentManager<Tarea> {

    /*Este método lista las tareas por seguimiento*/
    public List<Tarea> buscarTareasPorSeguimiento(Seguimiento seguimiento) {
        List<Tarea> tareasPorSeguimiento;
        Query q = em.createQuery("SELECt t FROM Tarea t WHERE t.seguimiento = :seguimiento");
        q.setParameter("seguimiento", seguimiento);
        tareasPorSeguimiento = q.getResultList();
        return tareasPorSeguimiento;
    }

    /*Este métdo persiste una 'Tarea'*/
    public void persistirTarea(Tarea tarea)
    {
    em.persist(tarea);
    }
}
