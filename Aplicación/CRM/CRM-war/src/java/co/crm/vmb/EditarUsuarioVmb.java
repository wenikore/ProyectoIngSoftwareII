/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import co.crm.mmb.PersonaMmb;
import co.crm.mmb.UsuarioMmb;
import com.co.crm.entities.Persona;
import com.co.crm.entities.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import co.crm.utilidades.ConvertidorEntidades;
import com.co.crm.services.PersonaServicio;
import com.co.crm.services.UsuarioServicio;
import javax.faces.application.FacesMessage;
import org.omnifaces.util.Messages;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Named
@ViewScoped
public class EditarUsuarioVmb implements Serializable {

    @Inject
    UserSmb usuarioSesion;
    @Inject
    ConvertidorEntidades convertidor;
    @Inject
    PersonaServicio personaServicio;
    @Inject
    UsuarioServicio usuarioServicio;

    private Usuario usuarioModificar;
    private Persona personaModificar;

    private PersonaMmb personaComponente;
    private UsuarioMmb usuarioComponente;


    /*Esta función asigna los valores de un 'Usuario' en sesión  a los componentes de 'Persona' y 'Usuario'*/
    @PostConstruct
    public void init() {
        /*Se inicializan los componentes de 'Usuario' y 'Persona' de la vista*/
        personaComponente = new PersonaMmb();
        usuarioComponente = new UsuarioMmb();
        /*'Se ininializa el nuevo objeto 'Usuario 'que contiene la  información de la sesión'*/
        usuarioModificar = new Usuario();
        usuarioModificar = usuarioSesion.getUsuarioSession();

        /*Se asignan los valores a los componentes de 'Usuario y 'Persona'*/
        personaComponente.setIdentificacion(usuarioModificar.getPersona().getIdentificacion());
        personaComponente.setPrimerNombre(usuarioModificar.getPersona().getPrimerNombre());
        personaComponente.setPrimerApellido(usuarioModificar.getPersona().getPrimerApellido());
        personaComponente.setSegundoApellido(usuarioModificar.getPersona().getSegundoApellido());
        personaComponente.setDireccion(usuarioModificar.getPersona().getDireccion());
        personaComponente.setEmail(usuarioModificar.getPersona().getEmail());
        personaComponente.setFechaNacimiento(usuarioModificar.getPersona().getFechaNacimiento());
        personaComponente.setTelefonoFijo(usuarioModificar.getPersona().getTelefonoFijo());
        personaComponente.setTelefonoMovil(usuarioModificar.getPersona().getTelefonoMovil());
        personaComponente.setId(usuarioModificar.getPersona().getId());
        usuarioComponente.setId(usuarioModificar.getId());
        usuarioComponente.setNombre(usuarioModificar.getNombre());
        usuarioComponente.setPassword(usuarioModificar.getPassword());
        usuarioComponente.setIdPersona(usuarioModificar.getPersona().getId());
        usuarioComponente.setIdRol(usuarioModificar.getRol().getId());

    }

    /*Esta funcion modifica un 'Usuario' en la base de datos*/
    public void modificarUsuario() {
        try {
            Persona persona;
            Usuario usuario;
            /*Llena las entidades*/
            persona = convertidor.convertirPersonaComponenteToPersona(personaComponente);
            usuario = convertidor.convertirUsuarioComponenteToUsuario(usuarioComponente);
            usuario.setPersona(persona);
            /*Se modifican las entidades*/
            personaServicio.actualizarPersonaServicio(persona);
            usuarioServicio.actualizarUsuarioServicio(usuario);
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización exitosa", "Se ha actualizado un usuario en el sistema"));

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

    public UsuarioMmb getUsuarioComponente() {
        return usuarioComponente;
    }

    public void setUsuarioComponente(UsuarioMmb usuarioComponente) {
        this.usuarioComponente = usuarioComponente;
    }

}
