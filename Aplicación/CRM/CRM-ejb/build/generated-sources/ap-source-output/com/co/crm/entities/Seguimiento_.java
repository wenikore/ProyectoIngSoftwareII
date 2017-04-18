package com.co.crm.entities;

import com.co.crm.entities.Contacto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-18T17:47:23")
@StaticMetamodel(Seguimiento.class)
public class Seguimiento_ { 

    public static volatile SingularAttribute<Seguimiento, String> descripcion;
    public static volatile SingularAttribute<Seguimiento, Date> fechaCierre;
    public static volatile SingularAttribute<Seguimiento, String> motivo;
    public static volatile SingularAttribute<Seguimiento, Contacto> contacto;
    public static volatile SingularAttribute<Seguimiento, Date> fechaCreacion;
    public static volatile SingularAttribute<Seguimiento, Long> id;

}