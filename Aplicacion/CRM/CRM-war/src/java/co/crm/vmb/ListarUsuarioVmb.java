/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.entities.Usuario;
import com.co.crm.services.UsuarioServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Named
@ViewScoped
public class ListarUsuarioVmb implements Serializable {

    @Inject
    UsuarioServicio usuarioServicio;
    
    @Inject
    UserSmb usuarioSesion;

    private LazyDataModel<Usuario> usuariosModelo;
    private List<Usuario> usuariosEncontrados;
    private String textoBusqueda;

    @PostConstruct
    public void init() {

        /*Este método busca un 'Usuario' por un texto de búsqueda*/
        usuariosModelo = new LazyDataModel<Usuario>() {
            @Override

            public List<Usuario> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                usuariosEncontrados = new ArrayList<>();
                usuariosEncontrados = usuarioServicio.buscarUsuarioPorNombreApellidoServicio(textoBusqueda, first, pageSize);
                setRowCount(usuariosEncontrados.size());
                return usuariosEncontrados;
            }

            @Override
            public void forEach(Consumer<? super Usuario> action) {
                super.forEach(action); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Spliterator<Usuario> spliterator() {
                return super.spliterator(); //To change body of generated methods, choose Tools | Templates.
            }
        };

    }

    /*Este método retorna una lista  de tipo 'Usuario' filtada por un patametro de búsqueda*/
    public void buscarUsuario() {
        init();
    }

    /*Este método asigna la información  del row de la tabla a una variable en sesión*/
    public String seleccionarUsuario(Usuario usuario)
    {
    usuarioSesion.setUsuarioSession(usuario); 
    return "irDetalleUsuario";
    }
    
    
    /*Getters & Setters*/
    public LazyDataModel<Usuario> getUsuariosModelo() {
        return usuariosModelo;
    }

    public void setUsuariosModelo(LazyDataModel<Usuario> usuariosModelo) {
        this.usuariosModelo = usuariosModelo;
    }

    public List<Usuario> getUsuariosEncontrados() {
        return usuariosEncontrados;
    }

    public void setUsuariosEncontrados(List<Usuario> usuariosEncontrados) {
        this.usuariosEncontrados = usuariosEncontrados;
    }

    public String getTextoBusqueda() {
        return textoBusqueda;
    }

    public void setTextoBusqueda(String textoBusqueda) {
        this.textoBusqueda = textoBusqueda;
    }

}
