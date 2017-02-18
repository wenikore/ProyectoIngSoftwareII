/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.components;

import co.crm.mmb.PersonaMmb;
import java.io.Serializable;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Dependent
public class PersonaComp implements Serializable{
    
    private PersonaMmb personaMmb;
    
    /*Getters & Setters*/

    public PersonaMmb getPersonaMmb() {
        return personaMmb;
    }

    public void setPersonaMmb(PersonaMmb personaMmb) {
        this.personaMmb = personaMmb;
    }
    
    
}
