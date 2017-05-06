/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.services;

import com.co.crm.entities.Seguimiento;
import com.co.crm.entities.Tarea;
import com.co.crm.facades.TareaFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class TareaServicio {

    @Inject
    TareaFacade tareaFacade;

    /*Este método lista las tareas por seguimiento*/
    public List<Tarea> buscarTareasPorSeguimientoServicio(Seguimiento seguimiento) {
        List<Tarea> tareasPorSeguimiento;
        tareasPorSeguimiento = tareaFacade.buscarTareasPorSeguimiento(seguimiento);
        return tareasPorSeguimiento;
    }

    /*Este métdo persiste una 'Tarea'*/
    public void persistirTareaServicio(Tarea tarea) {
        tareaFacade.persistirTarea(tarea);
    }

}
