/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.services;

import com.co.crm.entities.Persona;
import com.co.crm.entities.Rol;
import com.co.crm.entities.Usuario;
import com.co.crm.facades.UsuarioFacade;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class UsuarioServicio {

    @Inject
    UsuarioFacade usuarioFacade;
    @Inject
    PersonaServicio personaServicio;
    @Inject
    RolServicio rolServicio;

    /*Este método persiste un 'Usuario' en la base de datos*/
    public void persistirUsuarioServicio(String usuarioNombre, String usuarioPassword, Persona personaPersistir, String rolNombre) {
        Usuario usuarioPersistir = new Usuario();

        Rol rolUsuario;

        /*Se buscar el 'Rol' del 'Usuario 'por el nombreRol*/
        rolUsuario = rolServicio.buscarRolPorNombreServicio(rolNombre);

        /*Se llena persiste la  'Persona'*/
        personaServicio.persistirPersonaServicio(personaPersistir);

        /*Se llena el objeto 'Usuario' para que esté en contexto de Persistencia*/
        usuarioPersistir.setNombre(usuarioNombre);
        usuarioPersistir.setPassword(DigestUtils.md5Hex(usuarioPassword));
        usuarioPersistir.setRol(rolUsuario);
        usuarioPersistir.setPersona(personaPersistir);
        /*Se persiste el 'Usuario'*/
        usuarioFacade.persistirUsuario(usuarioPersistir);
    }

    /*Este método retorna la lista de 'Usuarios' hallados por nombre y apellidos*/
    public List<Usuario> buscarUsuarioPorNombreApellidoServicio(String txtBusqueda, int first, int pageSize) {
        List<Usuario> usuariosPorNombreApellido;
        usuariosPorNombreApellido = usuarioFacade.buscarUsuarioPorNombreApellido(txtBusqueda, first, pageSize);
        return usuariosPorNombreApellido;
    }

    /*Este método guarda los cambios en los campos en un 'Usuario'*/
    public void actualizarUsuarioServicio(Usuario usuarioModificar) {
        usuarioFacade.actualizarUsuario(usuarioModificar);
    }

    /**
     *
     * @param nombre
     * @param contrasenia
     * @return Usuario
     */
    public Usuario buscarUsuarioPorNombreContraseniaServicio(String nombre, String contrasenia) {
        Usuario usuarioHallado;
        usuarioHallado = usuarioFacade.buscarUsuarioPorNombreContrasenia(nombre, (DigestUtils.md5Hex(contrasenia)));
        return usuarioHallado;
    }

    /*Este método retorna un 'Usuario' por identidificacion*/
    public Long buscarUsuarioPorIdentificacionServicio(String identificacion) {
        Usuario usuario;
        usuario = usuarioFacade.buscarUsuarioPorIdentificacion(identificacion);
        return usuario.getId();
    }

    public Usuario buscarPorIdServicio(Long id) {
        Usuario usuario;
        usuario = usuarioFacade.buscarPorId(id);
        return usuario;
    }

    public List<Usuario> buscarTodosLosSupervisoresServicio() {
        List<Usuario> supervisores;
        supervisores = usuarioFacade.buscarTodosLosSupervisores();
        return supervisores;
    }

    public Map<String, Long> buscarTodosLosSupervisoresMapServicio() {
        List<Usuario> supervisores;
        Map<String, Long> supervisoresMap = new HashMap<>();
        supervisores = usuarioFacade.buscarTodosLosSupervisores();

        for (Usuario supervisor : supervisores) {
            supervisoresMap.put(supervisor.getPersona().getPrimerNombre() + " " + supervisor.getPersona().getPrimerApellido() + " "
                    + supervisor.getPersona().getSegundoApellido(), supervisor.getId());
        }
        return supervisoresMap;
    }

}
