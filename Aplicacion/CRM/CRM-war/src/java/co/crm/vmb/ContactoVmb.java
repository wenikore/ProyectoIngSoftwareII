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
import com.co.crm.entities.VendedorContacto;
import com.co.crm.services.ContactoServicio;
import com.co.crm.services.VendedorContactoServicio;
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
public class ContactoVmb implements Serializable {

    @Inject
    ContactoServicio contactoServicio;
    @Inject
    VendedorContactoServicio vendedorContactoServicio;
    @Inject
    UserSmb session;

    private PersonaMmb personaComponente;
    private ContactoMmb contactoComponente;
    private Contacto contactoFormulario;
    private Persona personaFormulario;
    private VendedorContacto vendedorContacto;

    @PostConstruct
    public void init() {
        contactoComponente = new ContactoMmb();
        personaComponente = new PersonaMmb();
        personaFormulario = new Persona();
        contactoFormulario = new Contacto();
        vendedorContacto = new VendedorContacto();
    }

    /*Este método inserta un 'Contacto' en la base de datos*/
    public void persistirContacto() {
        /*Se asignan los valores de los atributos desde el formulario web para la entidad 'Persona'*/
        String identificacion;
        Long vendedorId;
        
        
        personaFormulario.setIdentificacion(personaComponente.getIdentificacion());
        personaFormulario.setPrimerNombre(personaComponente.getPrimerNombre());
        personaFormulario.setPrimerApellido(personaComponente.getPrimerApellido());
        personaFormulario.setSegundoApellido(personaComponente.getSegundoApellido());
        personaFormulario.setFechaNacimiento(personaComponente.getFechaNacimiento());
        personaFormulario.setDireccion(personaComponente.getDireccion());
        personaFormulario.setTelefonoFijo(personaComponente.getTelefonoFijo());
        personaFormulario.setTelefonoMovil(personaComponente.getTelefonoMovil());
        personaFormulario.setEmail(personaComponente.getEmail());


        /*Se asignan los valores de los atributos desde el formulario web para la entidad 'Contacto'*/
        contactoFormulario.setEstado(contactoComponente.getEstado());
        contactoFormulario.setEtapa(contactoComponente.getEtapa());
        try {
            /*Se envía al servicio  para ser persistido*/

            String contactoEstado = contactoFormulario.getEstado();
            String contactoEtapa = contactoFormulario.getEtapa();
            contactoServicio.persistirContactoServicio(contactoEstado, contactoEtapa, personaFormulario);
            
            identificacion =  personaFormulario.getIdentificacion();
            vendedorId = session.getUsuarioSession().getId();
            /*Se asigna en la tabla VendedorContacto el nuevo Contacto*/
            
            
            vendedorContacto.setContactoId(contactoServicio.buscarContactoPorCedulaServicio(identificacion));
            vendedorContacto.setVendedorId(vendedorId);
            
            vendedorContactoServicio.persistirSupervisorVendedorServicio(vendedorContacto);
            
            
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha registrado un usuario en el sistema"));
            init();
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
