/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.components.SeguimientoInformacionMmb;
import com.co.crm.entities.Seguimiento;
import com.co.crm.services.SeguimientoServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author andre
 */
@Named
@ViewScoped
public class SeguimientosGeneralesVmb implements Serializable {

    @Inject
    UserSmb sesion;
    @Inject
    SeguimientoServicio seguimientoServicio;

    private List<SeguimientoInformacionMmb> todoslosSeguimientosVendedores;

    @PostConstruct()
    public void init() {
        todoslosSeguimientosVendedores = seguimientoServicio.seguimientosVendedoresPorSupervisorServicio(sesion.getUsuarioSession().getId());
    }

    
    /*Getters & Setters*/

    public List<SeguimientoInformacionMmb> getTodoslosSeguimientosVendedores() {
        return todoslosSeguimientosVendedores;
    }

    public void setTodoslosSeguimientosVendedores(List<SeguimientoInformacionMmb> todoslosSeguimientosVendedores) {
        this.todoslosSeguimientosVendedores = todoslosSeguimientosVendedores;
    }
    
    
    
}
