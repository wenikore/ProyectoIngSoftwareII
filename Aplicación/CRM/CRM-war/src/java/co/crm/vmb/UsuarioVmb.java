/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import co.crm.components.PersonaComp;
import co.crm.components.RolComp;
import co.crm.components.UsuarioComp;
import com.co.crm.Iservices.ServiceRolLocal;
import com.co.crm.Iservices.ServiceUsuarioLocal;
import com.co.crm.entities.Persona;
import com.co.crm.entities.Rol;
import com.co.crm.entities.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Named
@ViewScoped
public class UsuarioVmb implements Serializable {

    @Inject
    private ServiceUsuarioLocal serviceUsuarioLocal;

    @Inject
    private ServiceRolLocal serviceRolLocal;

    @Inject
    private PersonaComp personaComp;
    @Inject
    private UsuarioComp usuarioComp;
    @Inject
    private RolComp rolComp;

    @PostConstruct
    public void init() {

        personaComp = new PersonaComp();
        usuarioComp = new UsuarioComp();
        rolComp = new RolComp();
    }

    public void registrarUsuario() {
        /*Se llena el objeto 'Persona' con los datos que entran desde el formulario web*/
        Persona personaFormulario = new Persona();
        personaFormulario.setIdentifiacion(personaComp.getPersonaMmb().getIdentificacion());
        personaFormulario.setPrimerNombre(personaComp.getPersonaMmb().getPrimerNombre());
        personaFormulario.setSegundoNombre(personaComp.getPersonaMmb().getSegundoNombre());
        personaFormulario.setPrimerApellido(personaComp.getPersonaMmb().getPrimerApellido());
        personaFormulario.setSegundoApellido(personaComp.getPersonaMmb().getSegundoApellido());
        personaFormulario.setFechaNacimiento(personaComp.getPersonaMmb().getFechaNacimiento());
        personaFormulario.setDireccion(personaComp.getPersonaMmb().getDireccion());
        personaFormulario.setTelefonoMovil(personaComp.getPersonaMmb().getTelefonoMovil());
        personaFormulario.setTelefonoFijo(personaComp.getPersonaMmb().getTelefonoFijo());
        personaFormulario.setEmail(personaComp.getPersonaMmb().getEmail());

        /*Se busca el Rol de la lista de nombres disponibles desde la vista */
        Rol rolFormulario = new Rol();

        rolFormulario = serviceRolLocal.buscarRolPorNombre(rolComp.getRolMmb().getNombre());

        /*Se llena el objeto 'Usuario' con los datos que entran desde el formulario web*/
        Usuario usuarioFormulario = new Usuario();
        usuarioFormulario.setNombre(usuarioComp.getUsuarioMmb().getNombre());
        usuarioFormulario.setPassword(usuarioComp.getUsuarioMmb().getPassword());
        usuarioFormulario.setPersona(personaFormulario);
        usuarioFormulario.setRol(rolFormulario);

        try {
            serviceUsuarioLocal.crearUsuario(usuarioFormulario, personaFormulario);
            init();
            System.out.println("USUARIO INSERTADO");
        } catch (Exception e) {
            System.out.println("ERROR" + e.getMessage());
        }

    }
}
