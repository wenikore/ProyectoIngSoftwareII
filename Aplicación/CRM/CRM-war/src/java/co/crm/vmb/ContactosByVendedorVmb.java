/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.entities.Contacto;
import com.co.crm.services.VendedorContactoServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class ContactosByVendedorVmb implements Serializable {

    @Inject
    VendedorContactoServicio vendedorContactoServicio;
    @Inject
    UserSmb session;
    private Long vendedorId;
    private List<Contacto> contactos;

    @PostConstruct
    public void init() {
        vendedorId = session.getUsuarioSession().getId();
        contactos = new ArrayList<>();
        contactos = vendedorContactoServicio.buscarContactosPorVendedorServicio(vendedorId);

    }
    
    
    /*Getters % Setters*/

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }
    
    
    

}
