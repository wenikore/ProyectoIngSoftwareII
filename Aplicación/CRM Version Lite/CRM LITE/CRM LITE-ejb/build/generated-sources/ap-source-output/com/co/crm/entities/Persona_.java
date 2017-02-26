package com.co.crm.entities;

import com.co.crm.entities.Contacto;
import com.co.crm.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-25T19:55:58")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> personaTelefonomovil;
    public static volatile SingularAttribute<Persona, String> personaSegundonombre;
    public static volatile SingularAttribute<Persona, String> personaPrimernombre;
    public static volatile SingularAttribute<Persona, Date> personaFechanacimiento;
    public static volatile SingularAttribute<Persona, String> personaIdentificacion;
    public static volatile SingularAttribute<Persona, String> personaPrimerapellido;
    public static volatile SingularAttribute<Persona, String> personaSegundoapellido;
    public static volatile CollectionAttribute<Persona, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Persona, Integer> personaId;
    public static volatile CollectionAttribute<Persona, Contacto> contactoCollection;
    public static volatile SingularAttribute<Persona, String> personaTelefonofijo;
    public static volatile SingularAttribute<Persona, String> personaDireccion;

}