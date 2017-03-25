package com.co.crm.entities;

import com.co.crm.entities.Seguimiento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-24T21:06:45")
@StaticMetamodel(Tarea.class)
public class Tarea_ { 

    public static volatile SingularAttribute<Tarea, Date> fechaCierre;
    public static volatile SingularAttribute<Tarea, String> estado;
    public static volatile SingularAttribute<Tarea, String> tareaDescripcion;
    public static volatile SingularAttribute<Tarea, Seguimiento> seguimiento;
    public static volatile SingularAttribute<Tarea, Date> fechaCreacion;
    public static volatile SingularAttribute<Tarea, Long> id;

}