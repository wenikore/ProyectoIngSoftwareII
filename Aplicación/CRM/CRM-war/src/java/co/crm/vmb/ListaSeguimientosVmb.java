/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import co.crm.mmb.SeguimientoMmb;
import com.co.crm.entities.Contacto;
import com.co.crm.entities.Seguimiento;
import com.co.crm.services.SeguimientoServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Messages;

/**
 *
 * // * @author Andrés Peña Mantilla
 */
@Named
@ViewScoped
public class ListaSeguimientosVmb implements Serializable {

    @Inject
    SeguimientoServicio seguimientoServicio;
    @Inject
    UserSmb session;

    private List<Seguimiento> seguimientosPorContacto;
    private Contacto contacto;
    private Seguimiento seguimientoNuevo;
    private SeguimientoMmb seguimientoComponente;

    @PostConstruct
    public void init() {
        /*'Contacto' seleccionado*/
        seguimientoComponente = new SeguimientoMmb();
        contacto = new Contacto();
        contacto = session.getContactoSession();
        /*Busqueda de la lista 'de seguimientos' por 'contacto' seleccionado*/
        seguimientosPorContacto = new ArrayList();
        seguimientosPorContacto = seguimientoServicio.buscarSeguimientosPorContactoServicio(contacto);

    }

    /*Este método persiste un seguimiento*/
    public void persistirSeguimiento() {

        try {
            Date fechaCreacion = new Date();
            seguimientoNuevo = new Seguimiento();
            seguimientoNuevo.setMotivo(seguimientoComponente.getMotivo());
            seguimientoNuevo.setContacto(contacto);
            seguimientoNuevo.setDescripcion(seguimientoComponente.getDescripcion());
            seguimientoNuevo.setFechaCreacion(fechaCreacion);
            seguimientoServicio.persistirSeguimientoServicio(seguimientoNuevo);
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha registrado un seguimiento de oportunidad"));
            seguimientoComponente = new SeguimientoMmb();
            seguimientosPorContacto.add(seguimientoNuevo);
            seguimientoNuevo = new Seguimiento();

        } catch (Exception e) {
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar", e.getMessage()));;

        }

    }

    
    public String irDetalleSeguimiento(Seguimiento seguimiento)
    {
    session.setSeguimiento(seguimiento);     
    return "irDetalleSeguimiento";
    }
    

     public String irEditarSeguimiento(Seguimiento seguimiento)
    {
    session.setSeguimiento(seguimiento);     
    return "irEditarSeguimiento";
    }
    
    /*Getters & Setters*/
    public List<Seguimiento> getSeguimientosPorContacto() {
        return seguimientosPorContacto;
    }

    public void setSeguimientosPorContacto(List<Seguimiento> seguimientosPorContacto) {
        this.seguimientosPorContacto = seguimientosPorContacto;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public SeguimientoMmb getSeguimientoComponente() {
        return seguimientoComponente;
    }

    public void setSeguimientoComponente(SeguimientoMmb seguimientoComponente) {
        this.seguimientoComponente = seguimientoComponente;
    }

}
