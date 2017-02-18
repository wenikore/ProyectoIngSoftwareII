/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.components;

import co.crm.mmb.UsuarioMmb;
import java.io.Serializable;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Dependent
public class UsuarioComp implements Serializable {

    private UsuarioMmb usuarioMmb;

    /*Getters & Setters*/
    public UsuarioMmb getUsuarioMmb() {
        return usuarioMmb;
    }

    public void setUsuarioMmb(UsuarioMmb usuarioMmb) {
        this.usuarioMmb = usuarioMmb;
    }

}
