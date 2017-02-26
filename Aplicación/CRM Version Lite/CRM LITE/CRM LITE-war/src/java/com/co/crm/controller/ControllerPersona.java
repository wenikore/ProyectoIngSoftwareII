/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.controller;

import com.co.crm.entities.Persona;
import com.co.crm.model.PersonaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import javax.ejb.EJB;

@Named(value = "controllerPersona")
@SessionScoped
public class ControllerPersona implements Serializable {

    @EJB
    private PersonaFacade personafacade;

    public List<Persona> ListarPersonas() {

        return this.personafacade.findAll();
    }

    public ControllerPersona() {
    }

}
