/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.datacollections;

import com.co.crm.enums.EstadoContacto;
import com.co.crm.enums.EtapaContacto;
import java.io.Serializable;
import java.util.LinkedHashMap;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author Andrés Peña Mantilla
 *
 */
@Singleton
@Startup
@Named
public class DatosComunes implements Serializable {

    private LinkedHashMap<String, EtapaContacto> etapasContacto;
    private LinkedHashMap<String, EstadoContacto> estadosContacto;

    @PostConstruct
    public void init() {
        cargarEtapasContacto();
        cargarEstadosContacto();
    }

    /*Carga las Etapas que puede tener un 'Contacto' y los convierte a un 'LinkedHashMap'*/
    public void cargarEtapasContacto() {
        etapasContacto = new LinkedHashMap<>();
        for (EtapaContacto object : EtapaContacto.values()) {
            etapasContacto.put(object.getValue(), object);

        }
    }

    /*Carga los Estados que puede tener un 'Contacto' y los convierte en un 'LinkedHasMap'*/
    public void cargarEstadosContacto() {
        estadosContacto = new LinkedHashMap<>();
        for (EstadoContacto object : EstadoContacto.values()) {
            estadosContacto.put(object.getValue(), object);

        }

    }

    /*Getters & Setters*/
    public LinkedHashMap<String, EtapaContacto> getEtapasContacto() {
        return etapasContacto;
    }

    public void setEtapasContacto(LinkedHashMap<String, EtapaContacto> etapasContacto) {
        this.etapasContacto = etapasContacto;
    }

    public LinkedHashMap<String, EstadoContacto> getEstadosContacto() {
        return estadosContacto;
    }

    public void setEstadosContacto(LinkedHashMap<String, EstadoContacto> estadosContacto) {
        this.estadosContacto = estadosContacto;
    }

}
