/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.facades;

import com.co.crm.entities.Seguimiento;
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
public class UsuarioFacade extends PersistentManager<Usuario> {

    /*Este método persiste un 'Usuario' en la base de datos*/
    public void persistirUsuario(Usuario usuarioPersistir) {
        persistir(usuarioPersistir);
    }

    /*Este método retorna un 'Usuario' encontrado por el 'usuarioNombre'*/
    public Usuario buscarUsuarioPorNombreUsuario(String usuarioNombre) {
        Query q = em.createNamedQuery("Usuario.findByUsuarioNombre", Usuario.class).setParameter("usuarioNombre", usuarioNombre);
        Usuario usuarioHallado = (Usuario) q.getSingleResult();
        return usuarioHallado;
    }

    /*Este método actualiza un 'Usuario' en la base de datos*/
    public void actualizarUsuario(Usuario usuarioModificar) {
        actualizar(usuarioModificar);
    }

    /*Este método retorna una lista de 'Usuarios' filtrados por nombres y apellidos o identificacion*/
    public List<Usuario> buscarUsuarioPorNombreApellido(String txtBusqueda, int startAt, int maxPerPage) {
        Query q = em.createQuery("SELECT U FROM Usuario U WHERE U.persona.identificacion LIKE :txtBusqueda OR U.persona.primerNombre LIKE :txtBusqueda OR U.persona.primerApellido LIKE :txtBusqueda OR U.persona.segundoApellido LIKE :txtBusqueda OR U.persona.primerApellido LIKE :txtBusqueda");
        q.setParameter("txtBusqueda", "%" + txtBusqueda + "%");
        q.setFirstResult(startAt);
        q.setMaxResults(maxPerPage);
        return q.getResultList();
    }

    /*Este método retorna un Usuario por 'nombre' y 'contraseña'*/
    public Usuario buscarUsuarioPorNombreContrasenia(String nombre, String password) {
        Query q = em.createQuery("SELECT U FROM Usuario U WHERE U.nombre = :nombre AND U.password =:password");
        Usuario usuarioHallado;
        q.setParameter("nombre", nombre);
        q.setParameter("password", password);

        usuarioHallado = (Usuario) q.getSingleResult();

        if (usuarioHallado != null) {
            return usuarioHallado;
        } else {
            return null;
        }

    }

    /*Este método busca un 'usuario' por identificación*/
    public Usuario buscarUsuarioPorIdentificacion(String identificacion) {
        Query q = em.createQuery("SELECT U FROM Usuario U WHERE U.persona.identificacion = :identificacion");
        q.setParameter("identificacion", identificacion);
        Usuario usuario;
        usuario = (Usuario) q.getSingleResult();
        return usuario;
    }

   
}
