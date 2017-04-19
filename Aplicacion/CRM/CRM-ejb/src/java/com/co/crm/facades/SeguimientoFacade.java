/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.facades;

import com.co.crm.entities.Contacto;
import com.co.crm.entities.Seguimiento;
import com.co.crm.entities.Usuario;
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
public class SeguimientoFacade extends PersistentManager<Seguimiento> {

    @Inject
    UsuarioServicio usuarioServicio;

    /*Este método busca los seguimientos por un 'contacto' dado*/
    public List<Seguimiento> buscarSeguimientosPorContacto(Contacto contacto) {
        List<Seguimiento> seguimientosPorContacto;
        Query q = em.createQuery("SELECT s FROM Seguimiento s WHERE s.contacto = :contacto");
        q.setParameter("contacto", contacto);
        seguimientosPorContacto = q.getResultList();
        return seguimientosPorContacto;
    }

    /*Este método persiste un 'Seguimiento'*/
    public void persistirSeguimiento(Seguimiento seguimiento) {
        em.persist(seguimiento);
    }

    /*Este método actualizar un 'Seguimiento'*/
    public void actualizarSeguimiento(Seguimiento seguimiento) {
        em.merge(seguimiento);
    }

    public List<Seguimiento> listarSeguimientosDeVendedores(List<Usuario> vendedores) {
        List<Seguimiento> todosLosSeguimientos = new ArrayList<>();
        List<Contacto> contactosPorVendedor;

        for (int vendedor = 0; vendedor < vendedores.size(); vendedor++) {
            List<Seguimiento> seguimientosPorVendedor;
            //  seguimientosPorVendedor = buscarSeguimientosPorContacto(vendedores.get(vendedor).getId());
        }
        return todosLosSeguimientos;
    }

    public int seleccionarCuentaPorSeguimientoMotivo(String motivoSeguimiento) {

        Query q = em.createQuery("SELECT s FROM Seguimiento s WHERE s.motivo = :motivo");
        q.setParameter("motivo", motivoSeguimiento);

        int count;
        count = q.getResultList().size();
        System.out.println(count);
        return count;
    }
}
