/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.facades;

import com.co.crm.components.SeguimientoInformacionMmb;
import com.co.crm.entities.Contacto;
import com.co.crm.entities.Seguimiento;
import com.co.crm.entities.Usuario;
import com.co.crm.services.SeguimientoServicio;
import com.co.crm.services.SupervisorVendedorServicio;
import com.co.crm.services.UsuarioServicio;
import com.co.crm.services.VendedorContactoServicio;
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

    @Inject
    SupervisorVendedorServicio supervisorVendedorServicio;

    @Inject
    VendedorContactoServicio vendedorContactoServicio;

    @Inject
    SeguimientoServicio seguimientoServicio;

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

    public List<SeguimientoInformacionMmb> seguimientosVendedoresPorSupervisor(Long idSupervisor) {
        /*Aqui busca todos los vendedores que tiene asignado un supervisor*/
        List<Usuario> vendedoresPorSupervisor = supervisorVendedorServicio.buscarContactosPorVendedor(idSupervisor);
        /*Esta lista de seguimientos contendra todos los seguimientos de sus vendedores*/
        List<Seguimiento> todosLosSeguimientos = new ArrayList<>();
        List<SeguimientoInformacionMmb> seguimientosInformacion = new ArrayList<>();

        for (int i = 0; i < vendedoresPorSupervisor.size(); i++) {

            List<Contacto> contactosPorVendedor;
            /*Busca todos los contactos por cada vendedor */
            contactosPorVendedor = vendedorContactoServicio.buscarContactosPorVendedorServicio(vendedoresPorSupervisor.get(i).getId());
            for (int j = 0; j < contactosPorVendedor.size(); j++) {

                List<Seguimiento> seguimientosPorUnVendedor;
                /*Busca todos los seguimientos por un contacto*/
                seguimientosPorUnVendedor = (seguimientoServicio.buscarSeguimientosPorContactoServicio(contactosPorVendedor.get(j)));

                /*Agrega todos los seguimientos por un contacto a la lista de seguimientos general*/
                for (int k = 0; k < seguimientosPorUnVendedor.size(); k++) {
                    todosLosSeguimientos.add(seguimientosPorUnVendedor.get(k));

                }
            }

        }

        for (int i = 0; i < todosLosSeguimientos.size(); i++) {
            SeguimientoInformacionMmb aux = new SeguimientoInformacionMmb();
            Usuario vendedor = new Usuario();
            /**/
            vendedor = vendedorContactoServicio.buscarVendedorPorContacto(todosLosSeguimientos.get(i).getContacto().getId());
            aux.setVendedor(vendedor);
            aux.setSeguimiento(todosLosSeguimientos.get(i));
            seguimientosInformacion.add(aux);
        }
        return seguimientosInformacion;
    }
}
