/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.facades;

import com.co.crm.entities.Usuario;
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

}
