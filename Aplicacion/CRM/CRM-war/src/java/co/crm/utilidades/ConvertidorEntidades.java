/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.utilidades;

import co.crm.mmb.ContactoMmb;
import co.crm.mmb.PersonaMmb;
import co.crm.mmb.SeguimientoMmb;
import co.crm.mmb.UsuarioMmb;
import com.co.crm.entities.Contacto;
import com.co.crm.entities.Persona;
import com.co.crm.entities.Rol;
import com.co.crm.entities.Seguimiento;
import com.co.crm.entities.Usuario;
import com.co.crm.services.ContactoServicio;
import com.co.crm.services.PersonaServicio;
import com.co.crm.services.RolServicio;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class ConvertidorEntidades implements Serializable {

    @Inject
    RolServicio rolServicio;
    @Inject
    PersonaServicio personaServicio;
    @Inject
    ContactoServicio contactoServicio;

    private Persona personaModificar;
    private Contacto contactoModificar;
    private Usuario usuarioModificar;

    /*Esta funcion convierte una 'PersonaMmb' en una 'Persona'*/
    public Persona convertirPersonaComponenteToPersona(PersonaMmb personaComponente) {
        personaModificar = new Persona();
        /*Se pasa la informacion del componente al objeto*/
        personaModificar.setIdentificacion(personaComponente.getIdentificacion());
        personaModificar.setId(personaComponente.getId());
        personaModificar.setPrimerNombre(personaComponente.getPrimerNombre());
        personaModificar.setPrimerApellido(personaComponente.getPrimerApellido());
        personaModificar.setSegundoApellido(personaComponente.getSegundoApellido());
        personaModificar.setFechaNacimiento(personaComponente.getFechaNacimiento());
        personaModificar.setDireccion(personaComponente.getDireccion());
        personaModificar.setTelefonoFijo(personaComponente.getTelefonoFijo());
        personaModificar.setTelefonoMovil(personaComponente.getTelefonoMovil());
        personaModificar.setEmail(personaComponente.getEmail());

        return personaModificar;
    }

    /*Esta funcion convierte un 'ContactoMmb' en un 'Contacto'*/
    public Contacto convertirContactoComponenteToContacto(ContactoMmb contactoComponente) {
        /*Se pasa la informacion del componente al objeto*/
        contactoModificar = new Contacto();
        contactoModificar.setEstado(contactoComponente.getEstado());
        contactoModificar.setEtapa(contactoComponente.getEtapa());
        contactoModificar.setId(contactoComponente.getId());
        contactoModificar.setPersona(personaServicio.buscarPorIdServicio(contactoComponente.getPersonaId()));
        return contactoModificar;
    }

    /*Esta funcion convierte un 'UsuarioMmb' en un 'Usuario'*/
    public Usuario convertirUsuarioComponenteToUsuario(UsuarioMmb usuarioComponente) {
        /*Se pasa la informacion del componente al objeto*/
        usuarioModificar = new Usuario();

        /*Se busca el rol del 'Usuario'*/
        Rol rol;
        rol = rolServicio.buscarRolPorId(usuarioComponente.getIdRol());

        usuarioModificar.setId(usuarioComponente.getId());
        usuarioModificar.setPassword(usuarioComponente.getPassword());
        usuarioModificar.setRol(rol);
        usuarioModificar.setNombre(usuarioComponente.getNombre());

        return usuarioModificar;
    }

    /*Convierte una entidad de tipo 'SeguimientoMmb' a una entidad 'Seguimiento'*/
    public SeguimientoMmb converterSeguimientoEntitySeguimientoMmb(Seguimiento seguimiento) {
        SeguimientoMmb seguimientoComponente = new SeguimientoMmb();
        seguimientoComponente.setDescripcion(seguimiento.getDescripcion());
        seguimientoComponente.setMotivo(seguimiento.getMotivo());
        seguimientoComponente.setId(seguimiento.getId());
        seguimientoComponente.setContactoId(seguimiento.getContacto().getId());
        return seguimientoComponente;
    }

    /*Convierte una entidad 'Persona' en 'PersonaMmb'*/
    public PersonaMmb converterToPersonaComponente(Persona persona) {
        PersonaMmb personaComponente = new PersonaMmb();

        personaComponente.setId(persona.getId());
        personaComponente.setDireccion(persona.getDireccion());
        personaComponente.setEmail(persona.getEmail());
        personaComponente.setFechaNacimiento(persona.getFechaNacimiento());
        personaComponente.setIdentificacion(persona.getIdentificacion());
        personaComponente.setPrimerApellido(persona.getPrimerApellido());
        personaComponente.setSegundoApellido(persona.getSegundoApellido());
        personaComponente.setTelefonoFijo(persona.getTelefonoFijo());
        personaComponente.setTelefonoMovil(persona.getTelefonoMovil());
        personaComponente.setPrimerNombre(persona.getPrimerNombre());
        return personaComponente;
    }

    /*Convierte una entidad 'SeguimientoMmb' en 'Seguimiento'*/
    public Seguimiento converterToSeguimientoComponente(SeguimientoMmb seguimientoComponente) {
        Seguimiento seguimiento = new Seguimiento();
        seguimiento.setDescripcion(seguimientoComponente.getDescripcion());
        seguimiento.setMotivo(seguimientoComponente.getMotivo());
        seguimiento.setId(seguimientoComponente.getId());
        seguimiento.setContacto(contactoServicio.buscarPorIdServicio(seguimientoComponente.getContactoId()));

        return seguimiento;
    }

    /**/
    /**
     *
     * @param contacto
     * @return
     */
    public ContactoMmb converterContactoToContactoMmb(Contacto contacto) {
        ContactoMmb contactoComponente = new ContactoMmb();
        contactoComponente.setEstado(contacto.getEstado());
        contactoComponente.setEtapa(contacto.getEtapa());
        contactoComponente.setId(contacto.getId());
        contactoComponente.setPersonaId(contacto.getPersona().getId());

        return contactoComponente;
    }
}
