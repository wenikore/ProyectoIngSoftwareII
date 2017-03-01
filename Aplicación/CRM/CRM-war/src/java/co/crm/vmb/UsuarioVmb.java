/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import co.crm.mmb.PersonaMmb;
import co.crm.mmb.RolMmb;
import com.co.crm.entities.Persona;
import com.co.crm.entities.Usuario;
import com.co.crm.services.UsuarioServicio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Messages;

/**
 *
 * @author Andres Peña Mantilla
 */
@Named
@ViewScoped
public class UsuarioVmb implements Serializable {

    @Inject
    UsuarioServicio usuarioServicio;

    private PersonaMmb personaComponente;
    private RolMmb rolComponente;
    private String usuarioNombre;
    private String usuarioPassword;
    private Usuario usuarioFormulario;
    private Persona personaFormulario;
    private String rolNombre;

    @PostConstruct
    public void init() {
        personaComponente = new PersonaMmb();
        rolComponente = new RolMmb();
        usuarioFormulario = new Usuario();
        personaFormulario = new Persona();

    }

    /*Este método inserta un 'Usuario' en la base de datos*/
    public void persistirUsuario() {
        personaFormulario.setIdentificacion(personaComponente.getIdentificacion());
        personaFormulario.setPrimerNombre(personaComponente.getPrimerNombre());
        personaFormulario.setPrimerApellido(personaComponente.getPrimerApellido());
        personaFormulario.setSegundoNombre(personaComponente.getSegundoNombre());
        personaFormulario.setSegundoApellido(personaComponente.getSegundoApellido());
        personaFormulario.setFechaNacimiento(personaComponente.getFechaNacimiento());
        personaFormulario.setDireccion(personaComponente.getDireccion());
        personaFormulario.setTelefonoFijo(personaComponente.getTelefonoFijo());
        personaFormulario.setTelefonoMovil(personaComponente.getTelefonoMovil());
        personaFormulario.setEmail(personaComponente.getEmail());
        rolNombre = rolComponente.getRolNombre();
        
        try {
            /*Se envía al servicio  para ser persistido*/
            usuarioServicio.persistirUsuarioServicio(usuarioNombre, usuarioPassword, personaFormulario, rolNombre);
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha registrado un usuario en el sistema"));
            init();
            vaciarCamposUsuario();

        } catch (Exception e) {
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar", e.getMessage()));;

        }

    }

    /*Esta función vacía los campos de usuarioNombre y usuaarioPassword*/
    public void vaciarCamposUsuario() {
        this.usuarioNombre = "";
        this.usuarioPassword = "";
        this.rolNombre = "";
    }

    /*Getters & Setters*/
    public PersonaMmb getPersonaComponente() {
        return personaComponente;
    }

    public void setPersonaComponente(PersonaMmb personaComponente) {
        this.personaComponente = personaComponente;
    }

    public RolMmb getRolComponente() {
        return rolComponente;
    }

    public void setRolComponente(RolMmb rolComponente) {
        this.rolComponente = rolComponente;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }
}
