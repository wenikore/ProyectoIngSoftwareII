/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.mmb;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Andrés Peña Mantilla
 */
public class UsuarioMmb {
    
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    private String password;
    private PersonaMmb personaMmb;
    private String rol;
    
    /*Getters & Setters*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonaMmb getPersonaMmb() {
        return personaMmb;
    }

    public void setPersonaMmb(PersonaMmb personaMmb) {
        this.personaMmb = personaMmb;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
    
}
