package entities;

import entities.Persona;
import entities.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-21T11:20:40")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Rol> rolId;
    public static volatile SingularAttribute<Usuario, String> usuarioPassword;
    public static volatile SingularAttribute<Usuario, String> usuarioId;
    public static volatile SingularAttribute<Usuario, String> usuarioNombre;
    public static volatile SingularAttribute<Usuario, Persona> personaId;

}