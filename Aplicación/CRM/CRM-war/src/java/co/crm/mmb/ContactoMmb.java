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
    private Long id;
    private Long personaId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }
    
    
}
