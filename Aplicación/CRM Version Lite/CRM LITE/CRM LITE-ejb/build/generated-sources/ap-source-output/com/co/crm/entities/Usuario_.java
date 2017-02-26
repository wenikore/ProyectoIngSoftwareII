package com.co.crm.entities;

import com.co.crm.entities.Persona;
import com.co.crm.entities.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-25T19:55:58")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Rol> rolId;
    public static volatile SingularAttribute<Usuario, String> usuarioPassword;
    public static volatile SingularAttribute<Usuario, Integer> usuarioId;
    public static volatile SingularAttribute<Usuario, String> usuarioNombre;
    public static volatile SingularAttribute<Usuario, Persona> personaId;

}