/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.services;

import com.co.crm.entities.SupervisorVendedor;
import com.co.crm.entities.Usuario;
import com.co.crm.facades.SupervisorVendedorFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class SupervisorVendedorServicio {
    
    @Inject
    SupervisorVendedorFacade supervisorVendedorFacade;

    /*Esta es la lista de vendedores del supervisor que inicia sesión*/
    public List buscarContactosPorVendedor(Long supervisorId) {
        List<Usuario> vendedores;
        vendedores = supervisorVendedorFacade.buscarVendedoresPorSupervisor(supervisorId);
        return vendedores;
    }

    /*Este método persiste una entidad de tipo 'SupervisorVendedor'*/
    public void persistirSupervisorVendedorServicio(SupervisorVendedor supervisorVendedor) {
        supervisorVendedorFacade.persistirSupervisorVendedorFacade(supervisorVendedor);
    }    
}
