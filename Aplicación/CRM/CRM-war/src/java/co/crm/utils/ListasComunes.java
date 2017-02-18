/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.utils;

import com.co.crm.Ifacades.RolFacadeLocal;
import com.co.crm.entities.Rol;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrés Peña Mantilla
 */
@ViewScoped
@Named
public class ListasComunes implements Serializable {

    @Inject
    private RolFacadeLocal rolFacadeLocal;

    private List<String> rolesList;

    /*Consulta todos los roles en el sistema y los retorna como una lista de 'Strings'*/
    public List<String> rolesList() {

        for (Rol rol : rolFacadeLocal.findAll()) {
            rolesList.add(rol.getNombre());
        }

        return rolesList;
    }
}
