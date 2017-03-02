/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.mmb;

/**
 *
 * @author Andrés Peña Mantilla
 */
public class ContactoMmb {
 
    /*Variables que apuntan desde la vista a los atributos de un 'Contacto'*/
    private String estado;
    private String etapa;
    /*Getters & Setters*/

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }
    
    
}
