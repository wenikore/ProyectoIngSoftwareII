/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.entities.Contacto;
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

    /**
     * Creates a new instance of UserSmb
     */
    public UserSmb() {
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

}
