/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.entities.Contacto;
import com.co.crm.services.ContactoServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Named
@ViewScoped
public class ListarContactoVmb implements Serializable {

    private LazyDataModel<Contacto> contactosModelo;
    private List<Contacto> contactosEncontrados;
    private String textoBusqueda;

    @Inject
    ContactoServicio contactoServicio;

    @Inject
    UserSmb contactoSesion;
    
    @PostConstruct
    public void init() {
        /*Este método busca un 'Contacto' por un texto de búsqueda*/
        contactosModelo = new LazyDataModel<Contacto>() {

            @Override
            public List<Contacto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                contactosEncontrados = new ArrayList<>();
                contactosEncontrados = contactoServicio.buscarContactoPorNombreApellidoServicio(textoBusqueda, first, pageSize);
                setRowCount(contactosEncontrados.size());
                return contactosEncontrados;
            }

            @Override
            public void forEach(Consumer<? super Contacto> action) {
                super.forEach(action); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Spliterator<Contacto> spliterator() {
                return super.spliterator(); //To change body of generated methods, choose Tools | Templates.
            }
        };

    }

    /*Este método retorna una lista  de tipo 'Contacto' filtada por un patametro de búsqueda*/
    public void buscarContacto() {
        init();
    }

    
    /*Este método asigna la información  del row de la tabla a una variable en sesión*/
    public String seleccionarContacto(Contacto contacto)
    {
    contactoSesion.setContactoSession(contacto); 
    return "irDetalleContacto";
    }
    
    /*Getters & Setters*/
    public LazyDataModel<Contacto> getContactosModelo() {
        return contactosModelo;
    }

    public void setContactosModelo(LazyDataModel<Contacto> contactosModelo) {
        this.contactosModelo = contactosModelo;
    }

    public List<Contacto> getContactosEncontrados() {
        return contactosEncontrados;
    }

    public void setContactosEncontrados(List<Contacto> contactosEncontrados) {
        this.contactosEncontrados = contactosEncontrados;
    }

    public String getTextoBusqueda() {
        return textoBusqueda;
    }

    public void setTextoBusqueda(String textoBusqueda) {
        this.textoBusqueda = textoBusqueda;
    }

}
