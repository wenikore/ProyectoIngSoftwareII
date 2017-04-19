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

    @PostConstruct
    public void init() {
        if (session.getUsuarioSession().getRol().getNombre().equals("Supervisor")) {
            vendedor = session.getVendedorSession();
            seguimientosVendedor = vendedorContactoServicio.listarTodosSeguimienosVendedoresServicio(vendedor.getId());
            inizializarModel();
            getSeguimientosPieChartModel();
        } else {
            vendedor = session.getUsuarioSession();
            seguimientosVendedor = vendedorContactoServicio.listarTodosSeguimienosVendedoresServicio(vendedor.getId());
            System.out.println("El tamaño es" + seguimientosVendedor.size());
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
        seguimientosPieChartModel.setTitle("OPORTUNIADES");
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
        yAxis.setMax(75);

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

    
    
}
