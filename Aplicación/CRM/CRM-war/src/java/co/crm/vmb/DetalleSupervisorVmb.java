/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.components.SeguimientoInformacionMmb;
import com.co.crm.entities.Seguimiento;
import com.co.crm.entities.Usuario;
import com.co.crm.services.SeguimientoServicio;
import com.co.crm.services.SupervisorVendedorServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

/**
 *
 * @author Andrés
 */
@Named
@ViewScoped
public class DetalleSupervisorVmb implements Serializable {

    @Inject
    UserSmb session;
    @Inject
    SupervisorVendedorServicio supervisorVendedorServicio;
    @Inject
    SeguimientoServicio seguimientoServicio;

    private Usuario supervisor;
    private List<Usuario> vendedoresPorSupervisor;
    private List<SeguimientoInformacionMmb> seguimientosPorSupervisor;

    @PostConstruct
    public void init() {
        supervisor = session.getSupervisor();
        vendedoresPorSupervisor = supervisorVendedorServicio.buscarContactosPorVendedor(supervisor.getId());
        seguimientosPorSupervisor = seguimientoServicio.seguimientosVendedoresPorSupervisorServicio(supervisor.getId());
    }

    public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /*Getters & Setters*/
    public Usuario getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Usuario supervisor) {
        this.supervisor = supervisor;
    }

    public List<Usuario> getVendedoresPorSupervisor() {
        return vendedoresPorSupervisor;
    }

    public void setVendedoresPorSupervisor(List<Usuario> vendedoresPorSupervisor) {
        this.vendedoresPorSupervisor = vendedoresPorSupervisor;
    }

    public List<SeguimientoInformacionMmb> getSeguimientosPorSupervisor() {
        return seguimientosPorSupervisor;
    }

    public void setSeguimientosPorSupervisor(List<SeguimientoInformacionMmb> seguimientosPorSupervisor) {
        this.seguimientosPorSupervisor = seguimientosPorSupervisor;
    }

    
    
    
}
