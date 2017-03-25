/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import co.crm.mmb.TareaMmb;
import com.co.crm.entities.Seguimiento;
import com.co.crm.entities.Tarea;
import com.co.crm.services.TareaServicio;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Messages;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Named
@ViewScoped
public class TareasVmb implements Serializable {

    @Inject
    TareaServicio tareaServicio;

    @Inject
    UserSmb session;

    private TareaMmb tareaComponente;
    private Seguimiento seguimientoSesion;
    private List<Tarea> tareasPorSeguimiento;
    private Tarea tareaNueva;

    @PostConstruct
    public void init() {
        tareaComponente = new TareaMmb();
        seguimientoSesion = new Seguimiento();
        seguimientoSesion = session.getSeguimiento();
        tareasPorSeguimiento = tareaServicio.buscarTareasPorSeguimientoServicio(seguimientoSesion);
    }

    /*Este método persiste una tarea*/
    public void persistirTarea() {
        try {

            Date fechaCreacion = new Date();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date todayWithZeroTime = formatter.parse(formatter.format(fechaCreacion));

            tareaNueva = new Tarea();
            tareaNueva.setSeguimiento(seguimientoSesion);
            tareaNueva.setTareaDescripcion(tareaComponente.getDescripcion());
            tareaNueva.setFechaCreacion(todayWithZeroTime);
            tareaNueva.setEstado(tareaComponente.getEstado());
            tareaServicio.persistirTareaServicio(tareaNueva);
            tareasPorSeguimiento.add(tareaNueva);
            tareaNueva = new Tarea();
            tareaComponente = new TareaMmb();
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha registrado una tarea al seguimiento del contacto"));

        } catch (Exception e) {
            Messages.add("messageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar", e.getMessage()));;

        }
    }

    /*Getters & Setters*/
    public TareaMmb getTareaComponente() {
        return tareaComponente;
    }

    public void setTareaComponente(TareaMmb tareaComponente) {
        this.tareaComponente = tareaComponente;
    }

    public Seguimiento getSeguimientoSesion() {
        return seguimientoSesion;
    }

    public void setSeguimientoSesion(Seguimiento seguimientoSesion) {
        this.seguimientoSesion = seguimientoSesion;
    }

    public List<Tarea> getTareasPorSeguimiento() {
        return tareasPorSeguimiento;
    }

    public void setTareasPorSeguimiento(List<Tarea> tareasPorSeguimiento) {
        this.tareasPorSeguimiento = tareasPorSeguimiento;
    }

}
