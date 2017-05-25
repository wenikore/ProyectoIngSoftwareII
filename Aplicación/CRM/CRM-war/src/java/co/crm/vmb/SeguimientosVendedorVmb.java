/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.entities.Seguimiento;
import com.co.crm.entities.Usuario;
import com.co.crm.services.SeguimientoServicio;
import com.co.crm.services.VendedorContactoServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Named
@ViewScoped
public class SeguimientosVendedorVmb implements Serializable {

    @Inject
    UserSmb session;
    @Inject
    VendedorContactoServicio vendedorContactoServicio;
    @Inject
    SeguimientoServicio seguimientoServicio;

    private Usuario vendedor;
    private List<Seguimiento> seguimientosVendedor;
    private ChartSeries seguimientosVendedorData;
    private BarChartModel seguimientosVendedorModel;
    private PieChartModel seguimientosPieChartModel;
    private int Envio_Informacion;
    private int Contacto_Telefonico;
    private int Cita_Virtual;
    private int Contacto_Posterior;
    private int Otro;
    private int Cita_Presencial;
    private String ListaCita_Presencial = "";
    private String ListaOtro = "";
    private String ListaContacto_posterior = "";
    private String ListaCita_virtual = "";
    private String ListaContacto_telefonico = "";
    private String ListaEnvio_Informacion = "";
    

    @PostConstruct
    public void init() {
        if (session.getUsuarioSession().getRol().getNombre().equals("Supervisor")) {
            vendedor = session.getVendedorSession();
            seguimientosVendedor = vendedorContactoServicio.listarTodosSeguimienosVendedoresServicio(vendedor.getId());
            inizializarModel();
            getSeguimientosPieChartModel();
        } else if (session.getUsuarioSession().getRol().getNombre().equals("Administrador")) {
            vendedor = session.getVendedorSession();
            seguimientosVendedor = vendedorContactoServicio.listarTodosSeguimienosVendedoresServicio(vendedor.getId());
            inizializarModel();
            getSeguimientosPieChartModel();
        } else {
            vendedor = session.getUsuarioSession();
            seguimientosVendedor = vendedorContactoServicio.listarTodosSeguimienosVendedoresServicio(vendedor.getId());
            inizializarModel();
            getSeguimientosPieChartModel();
        }

    }

    /**
     *
     * @return
     */
    public PieChartModel getSeguimientosPieChartModel() {
        seguimientosPieChartModel = new PieChartModel();
        for (Seguimiento aux : seguimientosVendedor) {
            int count = seguimientoServicio.seleccionarCuentaPorSeguimientoMotivoServicio(aux.getMotivo());
            seguimientosPieChartModel.getData().put(aux.getMotivo(), count);

        }
        seguimientosPieChartModel.setTitle("OPORTUNIDADES");
        seguimientosPieChartModel.setLegendPosition("ne");
        return seguimientosPieChartModel;
    }

    /**/
    private BarChartModel initBartModel() {
        BarChartModel model = new BarChartModel();
        seguimientosVendedorData = new ChartSeries();
        seguimientosVendedorData.setLabel("Seguimientos");
        for (Seguimiento aux : seguimientosVendedor) {
            int count = seguimientoServicio.seleccionarCuentaPorSeguimientoMotivoServicio(aux.getMotivo());
            seguimientosVendedorData.set(aux.getMotivo(), count);
        }
        model.addSeries(seguimientosVendedorData);
        return model;
    }

    /**/
    private void createBarModel() {
        seguimientosVendedorModel = initBartModel();
        seguimientosVendedorModel.setTitle("MOTIVOS");
        seguimientosVendedorModel.setLegendPosition("ne");

        Axis xAxis = seguimientosVendedorModel.getAxis(AxisType.X);
        xAxis.setLabel("CATEGORÍAS");

        Axis yAxis = seguimientosVendedorModel.getAxis(AxisType.Y);
        yAxis.setLabel("CANTIDAD");
        yAxis.setMin(0);
        yAxis.setMax(seguimientosVendedor.size());

    }

    private void inizializarModel() {
        createBarModel();
    }

    /*Getters & Setters*/
    public VendedorContactoServicio getVendedorContactoServicio() {
        return vendedorContactoServicio;
    }

    public void setVendedorContactoServicio(VendedorContactoServicio vendedorContactoServicio) {
        this.vendedorContactoServicio = vendedorContactoServicio;
    }

    public List<Seguimiento> getSeguimientosVendedor() {
        return seguimientosVendedor;
    }

    public void setSeguimientosVendedor(List<Seguimiento> seguimientosVendedor) {
        this.seguimientosVendedor = seguimientosVendedor;
    }

    public ChartSeries getSeguimientosVendedorData() {
        return seguimientosVendedorData;
    }

    public void setSeguimientosVendedorData(ChartSeries seguimientosVendedorData) {
        this.seguimientosVendedorData = seguimientosVendedorData;
    }

    public BarChartModel getSeguimientosVendedorModel() {
        return seguimientosVendedorModel;
    }

    public void setSeguimientosVendedorModel(BarChartModel seguimientosVendedorModel) {
        this.seguimientosVendedorModel = seguimientosVendedorModel;
    }

    ////Desde aqui se inicia a hacer las modificaciones
    public int cantidadSeguimientos() {

        return seguimientosVendedor.size();
    }

    public void clasificarSeguimientos() {
        Envio_Informacion = 0;
        Contacto_Telefonico = 0;
        Cita_Virtual = 0;
        Contacto_Posterior = 0;
        Otro = 0;
        Cita_Presencial = 0;
        
        
        for (Seguimiento aux : seguimientosVendedor) {
            System.out.println(aux.getContacto().getPersona());
            
            if (aux.getMotivo().equals("Envio_Informacion") || aux.getMotivo().equals("Envío_Informacion")) {
                ListaEnvio_Informacion += "*"+aux.getContacto().getPersona().getPrimerNombre() +"-"
                        +aux.getContacto().getPersona().getPrimerApellido() +"-"
                        +aux.getContacto().getPersona().getTelefonoFijo() + "-" 
                        +aux.getContacto().getPersona().getEmail();
                Envio_Informacion++;
            }
            if (aux.getMotivo().equals("Contacto_Telefonico") || aux.getMotivo().equals("Contacto_Telefónico")) {
                 ListaContacto_telefonico += "*"+aux.getContacto().getPersona().getPrimerNombre() +"-"
                        +aux.getContacto().getPersona().getPrimerApellido() +"-"
                        +aux.getContacto().getPersona().getTelefonoFijo() + "-" 
                        +aux.getContacto().getPersona().getEmail();
                Contacto_Telefonico++;
            }
            if (aux.getMotivo().equals("Cita_Virtual")) {
                 ListaCita_virtual += "*"+aux.getContacto().getPersona().getPrimerNombre() +"-"
                        +aux.getContacto().getPersona().getPrimerApellido() +"-"
                        +aux.getContacto().getPersona().getTelefonoFijo() + "-" 
                        +aux.getContacto().getPersona().getEmail();
                Cita_Virtual++;
            }

            if (aux.getMotivo().equals("Contacto_Posterior")) {
                 ListaContacto_posterior += "*"+aux.getContacto().getPersona().getPrimerNombre() +"-"
                        +aux.getContacto().getPersona().getPrimerApellido() +"-"
                        +aux.getContacto().getPersona().getTelefonoFijo() + "-" 
                        +aux.getContacto().getPersona().getEmail();
                Contacto_Posterior++;
            }

            if (aux.getMotivo().equals("Otro")) {
                 ListaOtro += "*"+aux.getContacto().getPersona().getPrimerNombre() +"-"
                        +aux.getContacto().getPersona().getPrimerApellido() +"-"
                        +aux.getContacto().getPersona().getTelefonoFijo() + "-" 
                        +aux.getContacto().getPersona().getEmail();
                Otro++;
            }

            if (aux.getMotivo().equals("Cita_Presencial")) {
                 ListaCita_Presencial += "*"+aux.getContacto().getPersona().getPrimerNombre() +"-"
                        +aux.getContacto().getPersona().getPrimerApellido() +"-"
                        +aux.getContacto().getPersona().getTelefonoFijo() + "-" 
                        +aux.getContacto().getPersona().getEmail();
                Cita_Presencial++;
            }
    
}

System.out.println("Se encontraron: \n Envio_Informacion" + Envio_Informacion
                + "\n Contacto_Telefonico " + Contacto_Telefonico
                + "\n Cita_Virtual " + Cita_Virtual
                + "\n Contacto_Posterior " + Contacto_Posterior
                + "\n Otro" + Otro
                + "\n Cita Presencial" + Cita_Presencial);

    }
    

    public int getCita_Presencial() {
        return Cita_Presencial;
    }

    public int getEnvio_Informacion() {
        return Envio_Informacion;
    }

    public int getContacto_Telefonico() {
        return Contacto_Telefonico;
    }

    public int getCita_Virtual() {
        return Cita_Virtual;
    }

    public int getContacto_Posterior() {
        return Contacto_Posterior;
    }

    public int getOtro() {
        return Otro;
    }
    
        public String getListaCita_Presencial() {
        return ListaCita_Presencial;
    }

    public String getListaOtro() {
        return ListaOtro;
    }

    public String getListaContacto_posterior() {
        return ListaContacto_posterior;
    }

    public String getListaCita_virtual() {
        return ListaCita_virtual;
    }

    public String getListaContacto_telefonico() {
        return ListaContacto_telefonico;
    }

    public String getListaEnvio_Informacion() {
        return ListaEnvio_Informacion;
    }

}
