package com.co.crm.entities;

import com.co.crm.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-25T19:55:58")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, Integer> rolId;
    public static volatile SingularAttribute<Rol, String> nombreRol;
    public static volatile CollectionAttribute<Rol, Usuario> usuarioCollection;

}