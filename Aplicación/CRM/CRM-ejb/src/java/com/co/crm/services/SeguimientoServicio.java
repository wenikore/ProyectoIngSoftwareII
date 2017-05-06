/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.services;

import com.co.crm.components.SeguimientoInformacionMmb;
import com.co.crm.entities.Contacto;
import com.co.crm.entities.Seguimiento;
import com.co.crm.facades.SeguimientoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class SeguimientoServicio {

    @Inject
    SeguimientoFacade seguimientoFacade;

    /*Este método busca los seguimientos por un 'contacto' dado*/
    public List<Seguimiento> buscarSeguimientosPorContactoServicio(Contacto contacto) {
        List<Seguimiento> seguimientosPorContacto;
        seguimientosPorContacto = seguimientoFacade.buscarSeguimientosPorContacto(contacto);
        return seguimientosPorContacto;
    }

    /*Este método persiste un 'Seguimiento'*/
    public void persistirSeguimientoServicio(Seguimiento seguimiento) {
        seguimientoFacade.persistirSeguimiento(seguimiento);
    }

    /*Este método actualizar un 'Seguimiento'*/
    public void actualizarSeguimientoServicio(Seguimiento seguimiento) {
        seguimientoFacade.actualizarSeguimiento(seguimiento);
    }

    public int seleccionarCuentaPorSeguimientoMotivoServicio(String motivoSeguimiento) {
        int count = seguimientoFacade.seleccionarCuentaPorSeguimientoMotivo(motivoSeguimiento);
        return count;
    }

    public List<SeguimientoInformacionMmb> seguimientosVendedoresPorSupervisorServicio(Long idSupervisor) {
        List<SeguimientoInformacionMmb> todosLosSeguimientos = new ArrayList<>();
        todosLosSeguimientos = seguimientoFacade.seguimientosVendedoresPorSupervisor(idSupervisor);

        return todosLosSeguimientos;
    }

}
