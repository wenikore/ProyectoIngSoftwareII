/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.enums;

/**
 *
 * @author Andrés Peña Mantilla
 */
public enum TipoSeguimiento {
    
        EI("Envío Información"), 
        CT("Contacto Telefónico"),
        CP("Cita Presencial"),
        CV("Cita Virtual"),
        CPo("Contacto Posterior"),
        O("Otro");


    private final String value;

    private TipoSeguimiento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
