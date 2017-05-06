/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.facades;

import com.co.crm.entities.SupervisorVendedor;
import com.co.crm.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class SupervisorVendedorFacade extends PersistentManager<SupervisorVendedor> {

    /*Este método persiste una entidad 'SupervisorVendedor'*/
    public void persistirSupervisorVendedorFacade(SupervisorVendedor supervisorVendedor) {
        em.persist(supervisorVendedor);
    }

    /*Este método actualiza una entidad 'SupervisorVendedor'*/
    public void actualizarSupervisorVendedorFacade(SupervisorVendedor supervisorVendedor) {
        em.merge(supervisorVendedor);
    }

    /*Este método elimina una entidad 'SupervisorVendedor'*/
    public void eliminarSupervisorVendedorFacade(SupervisorVendedor supervisorVendedor) {
        em.remove(supervisorVendedor);
    }

    /*Este método retorna una lista de 'usuarios' de tipo 'vendedor' por un 'supervisor' dado*/
    public List<Usuario> buscarVendedoresPorSupervisor(Long supervisorId) {
        List<SupervisorVendedor> supervisorVendedor;
        List<Usuario> vendedoresPorSupervisor = new ArrayList<>();
        Query q = em.createQuery("SELECT S FROM SupervisorVendedor s WHERE s.supervisorId = :supervisorId");
        q.setParameter("supervisorId", supervisorId);
        supervisorVendedor = q.getResultList();

        for (int i = 0; i < supervisorVendedor.size(); i++) {
            Usuario vendedor;
            vendedor = em.find(Usuario.class, supervisorVendedor.get(i).getVendedorId());
            vendedoresPorSupervisor.add(vendedor);

        }
        return vendedoresPorSupervisor;
    }
    
    
    
}
