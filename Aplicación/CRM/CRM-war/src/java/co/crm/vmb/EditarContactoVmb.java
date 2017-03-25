/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import co.crm.mmb.ContactoMmb;
import co.crm.mmb.PersonaMmb;
import co.crm.utilidades.ConvertidorEntidades;
import com.co.crm.entities.Contacto;
import com.co.crm.entities.Persona;
import com.co.crm.services.ContactoServicio;
import com.co.crm.services.PersonaServicio;
import java.io.Serializable;
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
public class EditarContactoVmb implements Serializable {

    @Inject
    UserSmb contactoSesion;
    @Inject
    ConvertidorEntidades convertidor;
    @Inject
    ContactoServicio contactoServicio;
    @Inject
    PersonaServicio personaServicio;

    private Contacto contactoModificar;
    private Persona personaModificar;

    private PersonaMmb personaComponente;
    private ContactoMmb contactoComponente;

    @PostConstruct
    public void init() {
        personaComponente = new PersonaMmb();
        contactoComponente = new ContactoMmb();

        contactoModificar = contactoSesion.getContactoSession();

        personaComponente.setIdentificacion(contactoModificar.getPersona().getIdentificacion());
        personaComponente.setId(contactoModificar.getPersona().getId());
        personaComponente.setPrimerNombre(contactoModificar.getPersona().getPrimerNombre());
        personaComponente.setPrimerApellido(contactoModificar.getPersona().getPrimerApellido());
        personaComponente.setSegundoApellido(contactoModificar.getPersona().getSegundoApellido());
        personaComponente.setDireccion(contactoModificar.getPersona().getDireccion());
        personaComponente.setTelefonoFijo(contactoModificar.getPersona().getTelefonoFijo());
        personaComponente.setTelefonoMovil(contactoModificar.getPersona().getTelefonoMovil());
        personaComponente.setFechaNacimiento(contactoModificar.getPersona().getFechaNacimiento());
        personaComponente.setEmail(contactoModificar.getPersona().getEmail());
        contactoComponente.setEstado(contactoModificar.getEstado());
        contactoComponente.setEtapa(contactoModificar.getEtapa());
        contactoComponente.setId(contactoModificar.getId());
        contactoComponente.setPersonaId(contactoModificar.getPersona().getId());
    }

    /*Este metodo realiza la modificacion del 'Contacto'*/
    public void modificarContacto() {
        try {
            Persona persona;
            Contacto contacto;
            /*Llena las entidades*/
            persona = convertidor.convertirPersonaComponenteToPersona(personaComponente);
            contacto = convertidor.convertirContactoComponenteToContacto(contactoComponente);
            contacto.setPersona(persona);

            /*Se modifican las entidades*/
            personaServicio.actualizarPersonaServicio(persona);
            contactoServicio.actualizarContactoServicio(contacto);
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización exitosa", "Se ha actualizado un contacto en el sistema"));

        } catch (Exception e) {
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar", e.getMessage()));;

        }

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
