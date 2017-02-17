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
public enum Estado {
    
    C("Contacto Inicial"), I("Inactivo");
    
    private final String value;
    
    private Estado(String value) {
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
