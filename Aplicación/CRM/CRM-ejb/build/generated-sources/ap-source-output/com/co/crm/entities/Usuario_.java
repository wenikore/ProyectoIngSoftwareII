package com.co.crm.entities;

import com.co.crm.entities.Persona;
import com.co.crm.entities.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-08T19:42:04")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-08T16:36:22")
>>>>>>> d93d92ec59cb056a40ffa2802318c53eb02792ef
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, Persona> persona;
    public static volatile SingularAttribute<Usuario, Long> id;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, Rol> rol;

}