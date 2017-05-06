/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.entities.Usuario;
import com.co.crm.services.SupervisorVendedorServicio;
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
public class VendedoresBySupervisorVmb implements Serializable {

    @Inject
    SupervisorVendedorServicio supervisorVendedorServicio;
    @Inject
    UserSmb session;

    private Long supervisorId;
    private List<Usuario> vendedores;

    @PostConstruct
    public void init() {
        supervisorId = session.getUsuarioSession().getId();
        vendedores = new ArrayList<>();
        vendedores = supervisorVendedorServicio.buscarContactosPorVendedor(supervisorId);
    }

    /*Getters % Setters*/

    public List<Usuario> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<Usuario> vendedores) {
        this.vendedores = vendedores;
    }
    
    
}
