/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.entities.Usuario;
import com.co.crm.services.SupervisorVendedorServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrés
 */
@Named
@ViewScoped
public class ListaVendedoresVmb implements Serializable {

    private List<Usuario> listaUsuariosPorVendedor;
    private Usuario supervisorSesion;

    @Inject
    SupervisorVendedorServicio supervisorVendedorServicio;
    @Inject
    UserSmb usuarioSesion;

    @PostConstruct
    public void init() {
        supervisorSesion = usuarioSesion.getUsuarioSession();
        listaUsuariosPorVendedor = supervisorVendedorServicio.buscarContactosPorVendedor(supervisorSesion.getId());
    }

    /*Getters & Setters*/
    public List<Usuario> getListaUsuariosPorVendedor() {
        return listaUsuariosPorVendedor;
    }

    public void setListaUsuariosPorVendedor(List<Usuario> listaUsuariosPorVendedor) {
        this.listaUsuariosPorVendedor = listaUsuariosPorVendedor;
    }

}
