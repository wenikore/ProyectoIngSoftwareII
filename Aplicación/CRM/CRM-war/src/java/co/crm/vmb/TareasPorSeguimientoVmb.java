/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.entities.Seguimiento;
import com.co.crm.services.TareaServicio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrés
 */
@Named
@ViewScoped
public class TareasPorSeguimientoVmb implements Serializable{
    
    
    @Inject
    TareaServicio tareaServicio;
    
    private Seguimiento seguimiento;
    @PostConstruct
    public void init()
    {
    
    
    
    }
}
