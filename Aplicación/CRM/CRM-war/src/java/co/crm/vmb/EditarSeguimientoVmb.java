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
import com.co.crm.services.SeguimientoServicio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
    UserSmb session;
    @Inject
    ConvertidorEntidades converter;
    

    private Seguimiento seguimiento;
    private Persona persona;
    private Contacto contacto;
    private SeguimientoMmb seguimientoComponente;
    private ContactoMmb contactoComponente;
    private PersonaMmb personaComponente;

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
    
    public void actualizarSeguimientoContacto()
    {
    Contacto contactoActualizar;
    contactoActualizar = converter.convertirContactoComponenteToContacto(contactoComponente);
    seguimiento = converter.converterToSeguimientoComponente(seguimientoComponente);
    seguimiento.setContacto(contactoActualizar);
    
    
    }
    
}
