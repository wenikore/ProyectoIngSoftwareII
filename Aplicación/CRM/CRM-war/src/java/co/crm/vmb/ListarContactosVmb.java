/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.entities.Contacto;
import com.co.crm.services.ContactoServicio;
import java.io.Serializable;
import java.util.List;
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
public class ListarContactosVmb implements Serializable {

    private List<Contacto> contactosEncontrados;
    private String textoBusqueda;

    @Inject
    ContactoServicio contactoServicio;

    @Inject
    UserSmb contactoSesion;

    private List<Contacto> contactosHallados;

    @PostConstruct
    public void init() {
    }

    /*Este método retorna un 'Contacto' encontrado por identificación*/
    public void buscarContactoPorCedula() {
        try {
            contactosHallados = contactoServicio.buscarContactoPorIdentificacionServicio(textoBusqueda);
            if (contactosHallados.size() > 0) {
                Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "Busqueda exitosa", "Se ha encontrado un cliente potencial en el sistema"));
            } else {
                Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_WARN, "Busqueda sin resultados", "No se ha encontrado un cliente potencial en el sistema"));

            }
        } catch (Exception e) {
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error ", e.getMessage()));;

        }
    }

    /*Este método asigna la información  del row de la tabla a una variable en sesión*/
    public String seleccionarContacto(Contacto contacto) {
        contactoSesion.setContactoSession(contacto);
        return "irDetalleContacto";
    }

    /*Esta función modifica un 'Contacto' de estato 'A'(Activo) a 'I'(Inactivo)*/
    public void eliminarContacto() {
        try {
            for (int i = 0; i < contactosHallados.size(); i++) {
                contactosHallados.get(i).setEstado("I");
                contactoServicio.actualizarContactoServicio(contactosHallados.get(i));
                contactosHallados.remove(i);
            }
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación exitosa", "Se ha eliminado un cliente en el sistema"));

        } catch (Exception e) {
        }

    }

    

    public String nuevoSeguimiento(Contacto contacto) {
        contactoSesion.setContactoSession(contacto);
        return "irNuevoSeguimiento";
    }

    /*Getters & Setters*/
    public List<Contacto> getContactosHallados() {
        return contactosHallados;
    }

    public void setContactosHallados(List<Contacto> contactosHallados) {
        this.contactosHallados = contactosHallados;
    }

    public String getTextoBusqueda() {
        return textoBusqueda;
    }

    public void setTextoBusqueda(String textoBusqueda) {
        this.textoBusqueda = textoBusqueda;
    }

}
