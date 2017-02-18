/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.components;

import co.crm.mmb.RolMmb;
import java.io.Serializable;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Dependent
public class RolComp implements Serializable {

    private RolMmb rolMmb;

    /*Getters & Setters*/
    public RolMmb getRolMmb() {
        return rolMmb;
    }

    public void setRolMmb(RolMmb rolMmb) {
        this.rolMmb = rolMmb;
    }

}
