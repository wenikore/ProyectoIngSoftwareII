/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import co.crm.mmb.PersonaMmb;
import co.crm.mmb.UsuarioMmb;
import com.co.crm.entities.Usuario;
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
public class EditarUsuarioVmb implements Serializable {

    @Inject
    UserSmb usuarioSesion;

    private Usuario usuario;

    private PersonaMmb personaComponente;
    private UsuarioMmb usuarioComponente;

    /*Esta función asigna los valores de un 'Usuario' en sesión  a los componentes de 'Persona' y 'Usuario'*/
    @PostConstruct
    public void init() {
        /*Se inicializan los componentes de 'Usuario' y 'Persona' de la vista*/
        personaComponente = new PersonaMmb();
        usuarioComponente = new UsuarioMmb();
        /*'Se ininializa el nuevo objeto 'Usuario 'que contiene la  información de la sesión'*/
        usuario = new Usuario();
        usuario = usuarioSesion.getUsuarioSession();

        /*Se asignan los valores a los componentes de 'Usuario y 'Persona'*/
        personaComponente.setIdentificacion(usuario.getPersona().getIdentificacion());
        personaComponente.setPrimerNombre(usuario.getPersona().getPrimerNombre());
        personaComponente.setPrimerApellido(usuario.getPersona().getPrimerApellido());
        personaComponente.setSegundoApellido(usuario.getPersona().getSegundoApellido());
        personaComponente.setDireccion(usuario.getPersona().getDireccion());
        personaComponente.setEmail(usuario.getPersona().getEmail());
        personaComponente.setFechaNacimiento(usuario.getPersona().getFechaNacimiento());
        personaComponente.setTelefonoFijo(usuario.getPersona().getTelefonoFijo());
        personaComponente.setTelefonoMovil(usuario.getPersona().getTelefonoMovil());
        personaComponente.setId(usuario.getPersona().getId());
        usuarioComponente.setId(usuario.getId());
        usuarioComponente.setNombre(usuario.getNombre());
        usuarioComponente.setPassword(usuario.getPassword());
        usuarioComponente.setIdPersona(usuario.getPersona().getId());

    }

    /*Esta funcion modifica un 'Usuario' en la base de datos*/
    
    
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
