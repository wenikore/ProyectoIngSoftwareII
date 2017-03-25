/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.services;

import com.co.crm.entities.Contacto;
import com.co.crm.entities.VendedorContacto;
import com.co.crm.facades.VendedorContactoFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class VendedorContactoServicio {

    @Inject
    VendedorContactoFacade vendedorContactoFacade;

    
    /*Esta es la lista de contactos del vendedor que inicia sesión*/
    public List<Contacto> buscarContactosPorVendedorServicio(Long vendedorId) {
        List<Contacto> contactos;
        contactos = vendedorContactoFacade.buscarContactosPorVendedor(vendedorId);
        return contactos;

    }

    
    /*Este método persiste una entidad de tipo 'VendedorContacto'*/
    public void persistirSupervisorVendedorServicio(VendedorContacto vendedorContacto) {
        vendedorContactoFacade.persistirVendedorContactoFacade(vendedorContacto);
    }
}
