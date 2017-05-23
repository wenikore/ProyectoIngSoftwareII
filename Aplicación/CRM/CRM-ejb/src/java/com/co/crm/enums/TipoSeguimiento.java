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
    
        Envío_Informacion("Envío Información"), 
        Contacto_Telefónico("Contacto Telefónico"),
        Cita_Presencial("Cita Presencial"),
        Cita_Virtual("Cita Virtual"),
        Contacto_Posterior("Contacto Posterior"),
        Otro("Otro");


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
