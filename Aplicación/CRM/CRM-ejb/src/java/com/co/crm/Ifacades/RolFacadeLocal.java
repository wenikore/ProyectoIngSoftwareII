/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.Ifacades;

import com.co.crm.entities.Rol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Local
public interface RolFacadeLocal {

    void create(Rol rol);

    void edit(Rol rol);

    void remove(Rol rol);

    Rol find(Object id);

    List<Rol> findAll();

    List<Rol> findRange(int[] range);

    int count();
    
    Rol buscarRolPorNombre(String nombreRol);

}
