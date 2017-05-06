/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.facades;

import com.co.crm.entities.Contacto;
import com.co.crm.entities.Seguimiento;
import com.co.crm.entities.Usuario;
import com.co.crm.entities.VendedorContacto;
import com.co.crm.services.SeguimientoServicio;
import com.co.crm.services.UsuarioServicio;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class VendedorContactoFacade extends PersistentManager<VendedorContactoFacade> {

    @Inject
    SeguimientoServicio seguimientoServicio;
    @Inject
    UsuarioServicio usuarioServicio;

    /*Este método persiste una entidad 'VendedorContacto'*/
    public void persistirVendedorContactoFacade(VendedorContacto vendedorContacto) {
        em.persist(vendedorContacto);
    }

    /*Este método actualiza una entidad 'VendedorContacto'*/
    public void actualizarVendedorContactoFacade(VendedorContacto vendedorContacto) {
        em.merge(vendedorContacto);
    }

    /*Este método elimina una entidad 'VendedorContacto'*/
    public void eliminarVendedorContactoFacade(VendedorContacto vendedorContacto) {
        em.remove(vendedorContacto);
    }

    /*Este método retorna una lista de 'Contactos'  por un 'Vendedor' dado*/
    public List<Contacto> buscarContactosPorVendedor(Long vendedorId) {
        List<VendedorContacto> vendedorContacto;
        List<Contacto> contactosPorVendedor = new ArrayList<>();
        Query q = em.createQuery("SELECT V FROM VendedorContacto V WHERE V.vendedorId =:vendedorId");
        q.setParameter("vendedorId", vendedorId);
        vendedorContacto = q.getResultList();

        for (int i = 0; i < vendedorContacto.size(); i++) {
            Contacto contacto;
            contacto = em.find(Contacto.class, vendedorContacto.get(i).getContactoId());
            contactosPorVendedor.add(contacto);

        }
        return contactosPorVendedor;
    }

    /*Este método retorna una lista de 'Contactos'  por un 'Vendedor' dado*/
    public List<Seguimiento> listarTodosSeguimienosVendedores(Long vendedorId) {
        List<VendedorContacto> vendedorContacto;
        List<Contacto> contactosPorVendedor = new ArrayList<>();
        List<Seguimiento> todosLosSeguimientos = new ArrayList();
        Query q = em.createQuery("SELECT V FROM VendedorContacto V WHERE V.vendedorId =:vendedorId");
        q.setParameter("vendedorId", vendedorId);
        vendedorContacto = q.getResultList();
        for (int i = 0; i < vendedorContacto.size(); i++) {
            Contacto contacto;
            contacto = em.find(Contacto.class, vendedorContacto.get(i).getContactoId());
            contactosPorVendedor.add(contacto);
        }
        for (int i = 0; i < contactosPorVendedor.size(); i++) {
            List<Seguimiento> seguimientosPorContacto;
            seguimientosPorContacto = seguimientoServicio.buscarSeguimientosPorContactoServicio(contactosPorVendedor.get(i));
            for (int j = 0; j < seguimientosPorContacto.size(); j++) {
                todosLosSeguimientos.add(seguimientosPorContacto.get(j));
            }
        }
        return todosLosSeguimientos;
    }

    public Usuario buscarVendedorPorContacto(Long idContacto) {
        Query q = em.createQuery("SELECT V FROM VendedorContacto  V WHERE V.contactoId = :idContacto");
        q.setParameter("idContacto", idContacto);
        VendedorContacto aux = (VendedorContacto) q.getSingleResult();
        Usuario vendedor;
        vendedor = usuarioServicio.buscarPorIdServicio(aux.getVendedorId());
        return vendedor;
    }
}
