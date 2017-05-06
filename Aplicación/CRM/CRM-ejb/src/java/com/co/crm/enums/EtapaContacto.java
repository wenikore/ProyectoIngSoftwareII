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
public enum EtapaContacto {
  
        Contacto_Inicial("Contacto Inicial"), 
        Cliente("Cliente"),
        Dado_de_Baja("Dado de baja");

    private final String value;

    private EtapaContacto(String value) {
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
