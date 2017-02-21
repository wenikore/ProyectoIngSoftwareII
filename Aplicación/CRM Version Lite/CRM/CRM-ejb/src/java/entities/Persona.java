/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author samuel
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByPersonaId", query = "SELECT p FROM Persona p WHERE p.personaId = :personaId")
    , @NamedQuery(name = "Persona.findByPersonaIdentificacion", query = "SELECT p FROM Persona p WHERE p.personaIdentificacion = :personaIdentificacion")
    , @NamedQuery(name = "Persona.findByPersonaPrimernombre", query = "SELECT p FROM Persona p WHERE p.personaPrimernombre = :personaPrimernombre")
    , @NamedQuery(name = "Persona.findByPersonaSegundonombre", query = "SELECT p FROM Persona p WHERE p.personaSegundonombre = :personaSegundonombre")
    , @NamedQuery(name = "Persona.findByPersonaPrimerapellido", query = "SELECT p FROM Persona p WHERE p.personaPrimerapellido = :personaPrimerapellido")
    , @NamedQuery(name = "Persona.findByPersonaSegundoapellido", query = "SELECT p FROM Persona p WHERE p.personaSegundoapellido = :personaSegundoapellido")
    , @NamedQuery(name = "Persona.findByPersonaFechanacimiento", query = "SELECT p FROM Persona p WHERE p.personaFechanacimiento = :personaFechanacimiento")
    , @NamedQuery(name = "Persona.findByPersonaDireccion", query = "SELECT p FROM Persona p WHERE p.personaDireccion = :personaDireccion")
    , @NamedQuery(name = "Persona.findByPersonaTelefonomovil", query = "SELECT p FROM Persona p WHERE p.personaTelefonomovil = :personaTelefonomovil")
    , @NamedQuery(name = "Persona.findByPersonaTelefonofijo", query = "SELECT p FROM Persona p WHERE p.personaTelefonofijo = :personaTelefonofijo")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "persona_id")
    private Integer personaId;
    @Size(max = 2147483647)
    @Column(name = "persona_identificacion")
    private String personaIdentificacion;
    @Size(max = 2147483647)
    @Column(name = "persona_primernombre")
    private String personaPrimernombre;
    @Size(max = 2147483647)
    @Column(name = "persona_segundonombre")
    private String personaSegundonombre;
    @Size(max = 2147483647)
    @Column(name = "persona_primerapellido")
    private String personaPrimerapellido;
    @Size(max = 2147483647)
    @Column(name = "persona_segundoapellido")
    private String personaSegundoapellido;
    @Column(name = "persona_fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date personaFechanacimiento;
    @Size(max = 2147483647)
    @Column(name = "persona_direccion")
    private String personaDireccion;
    @Size(max = 2147483647)
    @Column(name = "persona_telefonomovil")
    private String personaTelefonomovil;
    @Size(max = 2147483647)
    @Column(name = "persona_telefonofijo")
    private String personaTelefonofijo;
    @OneToMany(mappedBy = "personaId")
    private Collection<Contacto> contactoCollection;
    @OneToMany(mappedBy = "personaId")
    private Collection<Usuario> usuarioCollection;

    public Persona() {
    }

    public Persona(Integer personaId) {
        this.personaId = personaId;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public String getPersonaIdentificacion() {
        return personaIdentificacion;
    }

    public void setPersonaIdentificacion(String personaIdentificacion) {
        this.personaIdentificacion = personaIdentificacion;
    }

    public String getPersonaPrimernombre() {
        return personaPrimernombre;
    }

    public void setPersonaPrimernombre(String personaPrimernombre) {
        this.personaPrimernombre = personaPrimernombre;
    }

    public String getPersonaSegundonombre() {
        return personaSegundonombre;
    }

    public void setPersonaSegundonombre(String personaSegundonombre) {
        this.personaSegundonombre = personaSegundonombre;
    }

    public String getPersonaPrimerapellido() {
        return personaPrimerapellido;
    }

    public void setPersonaPrimerapellido(String personaPrimerapellido) {
        this.personaPrimerapellido = personaPrimerapellido;
    }

    public String getPersonaSegundoapellido() {
        return personaSegundoapellido;
    }

    public void setPersonaSegundoapellido(String personaSegundoapellido) {
        this.personaSegundoapellido = personaSegundoapellido;
    }

    public Date getPersonaFechanacimiento() {
        return personaFechanacimiento;
    }

    public void setPersonaFechanacimiento(Date personaFechanacimiento) {
        this.personaFechanacimiento = personaFechanacimiento;
    }

    public String getPersonaDireccion() {
        return personaDireccion;
    }

    public void setPersonaDireccion(String personaDireccion) {
        this.personaDireccion = personaDireccion;
    }

    public String getPersonaTelefonomovil() {
        return personaTelefonomovil;
    }

    public void setPersonaTelefonomovil(String personaTelefonomovil) {
        this.personaTelefonomovil = personaTelefonomovil;
    }

    public String getPersonaTelefonofijo() {
        return personaTelefonofijo;
    }

    public void setPersonaTelefonofijo(String personaTelefonofijo) {
        this.personaTelefonofijo = personaTelefonofijo;
    }

    @XmlTransient
    public Collection<Contacto> getContactoCollection() {
        return contactoCollection;
    }

    public void setContactoCollection(Collection<Contacto> contactoCollection) {
        this.contactoCollection = contactoCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaId != null ? personaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.personaId == null && other.personaId != null) || (this.personaId != null && !this.personaId.equals(other.personaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Persona[ personaId=" + personaId + " ]";
    }
    
}
