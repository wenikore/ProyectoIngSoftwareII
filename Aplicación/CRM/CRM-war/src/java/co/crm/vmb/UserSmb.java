/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.entities.Contacto;
import com.co.crm.entities.Seguimiento;
import com.co.crm.entities.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Named
@SessionScoped
public class UserSmb implements Serializable {

    /*Contacto en sesión*/
    private Contacto contactoSession;
    /*Usuario en sesión*/
    private Usuario usuarioSession;
    /*Nombre del Usuario en sesión*/
    private String nombreUsuario;
    /*Seguimiento en sesión*/
    private Seguimiento seguimiento;
    private Usuario vendedorSession;
    

    /**
     * Creates a new instance of UserSmb
     */
    public UserSmb() {
    }

    /*Esta función destruye los objetos en sesión*/
    public void destroyObjectsInSession() {
        this.contactoSession = null;
        this.usuarioSession = null;

    }

    /*Getters & Setters*/
    public Contacto getContactoSession() {
        return contactoSession;
    }

    public void setContactoSession(Contacto contactoSession) {
        this.contactoSession = contactoSession;
    }

    public Usuario getUsuarioSession() {
        return usuarioSession;
    }

    public void setUsuarioSession(Usuario usuarioSession) {
        this.usuarioSession = usuarioSession;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void nombreUsuarioEnSesion() {
        nombreUsuario = usuarioSession.getPersona().getPrimerNombre() + " " + usuarioSession.getPersona().getPrimerApellido() + " " + usuarioSession.getPersona().getSegundoApellido();
    }

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }

    public Usuario getVendedorSession() {
        return vendedorSession;
    }

    public void setVendedorSession(Usuario vendedorSession) {
        this.vendedorSession = vendedorSession;
    }

    
    
}
