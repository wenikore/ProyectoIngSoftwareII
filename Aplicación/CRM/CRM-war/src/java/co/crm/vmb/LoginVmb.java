/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.entities.Usuario;
import com.co.crm.services.UsuarioServicio;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.util.Messages;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Named
@ViewScoped
public class LoginVmb implements Serializable {

    @Inject
    UserSmb session;
    @Inject
    UsuarioServicio usuarioServicio;

    private String usuario_nombre;
    private String usuario_password;
    private Usuario usuario;

    public String login() throws IOException, ServletException {

        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

            /*Busca el usuario en sesión por los parametros 'userName' y 'password' para tenerlo en memoria*/
            usuario = usuarioServicio.buscarUsuarioPorNombreContraseniaServicio(usuario_nombre, usuario_password);
            session.setUsuarioSession(usuario);

            //Realiza la peteticion de autenticación al servidor
            request.login(usuario_nombre, usuario_password);

            if (request.isUserInRole("Administrador")) {

                FacesContext.getCurrentInstance().getExternalContext().redirect("/CRM-war/faces/administracion/menuAdministracion.xhtml");

                //return "irMenuAdministrador";
            } else if (request.isUserInRole("Vendedor")) {

                FacesContext.getCurrentInstance().getExternalContext().redirect("/CRM-war/faces/vendedor/menuVendedor.xhtml");
                //return "irMenuVendedor";

            } else if (request.isUserInRole("Supervisor")) {

                FacesContext.getCurrentInstance().getExternalContext().redirect("/CRM-war/faces/supervisor/menuSupervisor.xhtml");
                //return "irMenuVendedor";
            } else {
                Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Confirme sus datos", "El usuario no existe en el sistema"));
            }

            return "";
        } catch (Exception e) {
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Confirme sus datos", "El usuario no existe en el sistema"));

        }
        return "";

    }

    public void logout() throws IOException {

        /*Vuelve nulo el usuario en sesión*/
        usuario = null;

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/CRM-war/faces/login.xhtml");

        } catch (ServletException ex) {
            Logger.getLogger(LoginVmb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /*Getters & Setters*/
    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_password() {
        return usuario_password;
    }

    public void setUsuario_password(String usuario_password) {
        this.usuario_password = usuario_password;
    }

}
