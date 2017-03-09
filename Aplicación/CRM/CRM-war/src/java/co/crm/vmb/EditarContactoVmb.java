/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import co.crm.mmb.ContactoMmb;
import co.crm.mmb.PersonaMmb;
import com.co.crm.entities.Contacto;
import com.co.crm.entities.Persona;
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
public class EditarContactoVmb implements Serializable {

    @Inject
    UserSmb contactoSesion;

    private Contacto contacto;
    private Persona persona;

    private PersonaMmb personaComponente;
    private ContactoMmb contactoComponente;

    @PostConstruct
    public void init() {
        personaComponente = new PersonaMmb();
        contactoComponente = new ContactoMmb();

        contacto = contactoSesion.getContactoSession();

        personaComponente.setIdentificacion(contacto.getPersona().getIdentificacion());
        personaComponente.setId(contacto.getPersona().getId());
        personaComponente.setPrimerNombre(contacto.getPersona().getPrimerNombre());
        personaComponente.setPrimerApellido(contacto.getPersona().getPrimerApellido());
        personaComponente.setSegundoApellido(contacto.getPersona().getSegundoApellido());
        personaComponente.setDireccion(contacto.getPersona().getDireccion());
        personaComponente.setTelefonoFijo(contacto.getPersona().getTelefonoFijo());
        personaComponente.setTelefonoMovil(contacto.getPersona().getTelefonoMovil());
        personaComponente.setFechaNacimiento(contacto.getPersona().getFechaNacimiento());
        contactoComponente.setEstado(contacto.getEstado());
        contactoComponente.setEtapa(contacto.getEtapa());
        contactoComponente.setId(contacto.getId());
        contactoComponente.setPersonaId(contacto.getPersona().getId());
    }

    /*Getters & Setters*/

    public PersonaMmb getPersonaComponente() {
        return personaComponente;
    }

    public void setPersonaComponente(PersonaMmb personaComponente) {
        this.personaComponente = personaComponente;
    }

    public ContactoMmb getContactoComponente() {
        return contactoComponente;
    }

    public void setContactoComponente(ContactoMmb contactoComponente) {
        this.contactoComponente = contactoComponente;
    }

}
