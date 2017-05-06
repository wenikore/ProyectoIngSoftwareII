/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Named
@ViewScoped
public class NavigationVmb implements Serializable {

    public String buscarContacto() {
        return "irBuscarContacto";
    }

    public String nuevoContacto() {
        return "irNuevoContacto";
    }

    public String buscarUsuario() {
        return "irBuscarUsuario";
    }

    public String nuevoUsuario() {
        return "irNuevoUsuario";
    }

    public String listaUsuarios() {
        return "irListarUsuarios";
    }

    public String misContactos() {
        return "irMisContactos";
    }

    public String misSeguimientos() {
        return "irMisSeguimientos";
    }
    
    public String misVendedores()
    {
    return "irMisVendedores";
    }
}
