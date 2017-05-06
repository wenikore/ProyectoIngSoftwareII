/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import co.crm.mmb.ContactoMmb;
import co.crm.mmb.PersonaMmb;
import co.crm.mmb.SeguimientoMmb;
import co.crm.utilidades.ConvertidorEntidades;
import com.co.crm.entities.Contacto;
import com.co.crm.entities.Persona;
import com.co.crm.entities.Seguimiento;
import com.co.crm.entities.Tarea;
import com.co.crm.services.ContactoServicio;
import com.co.crm.services.SeguimientoServicio;
import com.co.crm.services.TareaServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Messages;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Named
@ViewScoped
public class EditarSeguimientoVmb implements Serializable {

    @Inject
    SeguimientoServicio seguimientoServicio;
    @Inject
    ContactoServicio contactoServicio;
    @Inject
    UserSmb session;
    @Inject
    ConvertidorEntidades converter;
    @Inject
    TareaServicio tareaServicio;

    private Seguimiento seguimiento;
    private Persona persona;
    private Contacto contacto;
    private SeguimientoMmb seguimientoComponente;
    private ContactoMmb contactoComponente;
    private PersonaMmb personaComponente;
    //private List<Tarea> tareasPorSeguimiento;

    @PostConstruct
    public void init() {
        /*Construccion de objetos*/
        seguimiento = session.getSeguimiento();
        persona = session.getSeguimiento().getContacto().getPersona();
        contacto = session.getSeguimiento().getContacto();

        /*Construccion de Componentes*/
        seguimientoComponente = new SeguimientoMmb();
        contactoComponente = new ContactoMmb();
        personaComponente = new PersonaMmb();
        /*Asignacion de información a  los componentes*/
        seguimientoComponente = converter.converterSeguimientoEntitySeguimientoMmb(seguimiento);
        personaComponente = converter.converterToPersonaComponente(persona);
        contactoComponente = converter.converterContactoToContactoMmb(contacto);
        //tareasPorSeguimiento = tareaServicio.buscarTareasPorSeguimientoServicio(seguimiento);
    }

    /*Getters & Setters*/
    public SeguimientoMmb getSeguimientoComponente() {
        return seguimientoComponente;
    }

    public void setSeguimientoComponente(SeguimientoMmb seguimientoComponente) {
        this.seguimientoComponente = seguimientoComponente;
    }

    public ContactoMmb getContactoComponente() {
        return contactoComponente;
    }

    public void setContactoComponente(ContactoMmb contactoComponente) {
        this.contactoComponente = contactoComponente;
    }

    public PersonaMmb getPersonaComponente() {
        return personaComponente;
    }

    public void setPersonaComponente(PersonaMmb personaComponente) {
        this.personaComponente = personaComponente;
    }

    public void actualizarSeguimientoContacto() {

        try {
            Contacto contactoActualizar;
            Seguimiento seguimientoActualizar;
            contactoActualizar = converter.convertirContactoComponenteToContacto(contactoComponente);
            seguimientoActualizar = converter.converterToSeguimientoComponente(seguimientoComponente);
            contactoServicio.actualizarContactoServicio(contactoActualizar);
            seguimientoServicio.actualizarSeguimientoServicio(seguimientoActualizar);
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización exitosa", "Se ha actualizado el seguimiento de venta"));

        } catch (Exception e) {
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar", e.getMessage()));;

        }

    }

    public String listarTareas() {
        return "irTareasSeguimiento";
    }

}
