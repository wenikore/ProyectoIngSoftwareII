/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.components.SeguimientoInformacionMmb;
import com.co.crm.entities.Seguimiento;
import com.co.crm.services.SeguimientoServicio;
import java.io.Serializable;
import java.util.ArrayList;
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
 * @author andre
 */
@Named
@ViewScoped
public class SeguimientosGeneralesVmb implements Serializable {

    @Inject
    UserSmb sesion;
    @Inject
    SeguimientoServicio seguimientoServicio;

    private List<SeguimientoInformacionMmb> todoslosSeguimientosVendedores;
    private List<Seguimiento> seguimientosEstadisticas;
    private ChartSeries seguimientosData;
    private BarChartModel seguimientosModel;
    private PieChartModel seguimientosPieChartModel;

    @PostConstruct()
    public void init() {
        todoslosSeguimientosVendedores = seguimientoServicio.seguimientosVendedoresPorSupervisorServicio(sesion.getUsuarioSession().getId());
        cargarSoloSeguimientos();
        inizializarModel();
        getSeguimientosPieChartModel();
    }

    public void cargarSoloSeguimientos() {
        seguimientosEstadisticas = new ArrayList<>();
        for (int i = 0; i < todoslosSeguimientosVendedores.size(); i++) {
            seguimientosEstadisticas.add(todoslosSeguimientosVendedores.get(i).getSeguimiento());
        }

    }

    private BarChartModel initBartModel() {
        BarChartModel model = new BarChartModel();
        seguimientosData = new ChartSeries();
        seguimientosData.setLabel("OPORTUNIDADES");
        for (Seguimiento aux : seguimientosEstadisticas) {
            int count = seguimientoServicio.seleccionarCuentaPorSeguimientoMotivoServicio(aux.getMotivo());
            seguimientosData.set(aux.getMotivo(), count);
        }
        model.addSeries(seguimientosData);
        return model;
    }

    private void createBarModel() {
        seguimientosModel = initBartModel();
        seguimientosModel.setTitle("MOTIVOS");
        seguimientosModel.setLegendPosition("ne");

        Axis xAxis = seguimientosModel.getAxis(AxisType.X);
        xAxis.setLabel("CATEGORÍAS");

        Axis yAxis = seguimientosModel.getAxis(AxisType.Y);
        yAxis.setLabel("CANTIDAD");
        yAxis.setMin(0);
        yAxis.setMax(75);

    }

    private void inizializarModel() {
        createBarModel();
    }

    public PieChartModel getSeguimientosPieChartModel() {
        seguimientosPieChartModel = new PieChartModel();
        for (Seguimiento aux : seguimientosEstadisticas) {
            int count = seguimientoServicio.seleccionarCuentaPorSeguimientoMotivoServicio(aux.getMotivo());
            seguimientosPieChartModel.getData().put(aux.getMotivo(), count);

        }
        seguimientosPieChartModel.setTitle("OPORTUNIDADES");
        seguimientosPieChartModel.setLegendPosition("ne");
        return seguimientosPieChartModel;
    }


    /*Getters & Setters*/
    public List<SeguimientoInformacionMmb> getTodoslosSeguimientosVendedores() {
        return todoslosSeguimientosVendedores;
    }

    public void setTodoslosSeguimientosVendedores(List<SeguimientoInformacionMmb> todoslosSeguimientosVendedores) {
        this.todoslosSeguimientosVendedores = todoslosSeguimientosVendedores;
    }

    public List<Seguimiento> getSeguimientosEstadisticas() {
        return seguimientosEstadisticas;
    }

    public void setSeguimientosEstadisticas(List<Seguimiento> seguimientosEstadisticas) {
        this.seguimientosEstadisticas = seguimientosEstadisticas;
    }

    public ChartSeries getSeguimientosData() {
        return seguimientosData;
    }

    public void setSeguimientosData(ChartSeries seguimientosData) {
        this.seguimientosData = seguimientosData;
    }

    public BarChartModel getSeguimientosModel() {
        return seguimientosModel;
    }

    public void setSeguimientosModel(BarChartModel seguimientosModel) {
        this.seguimientosModel = seguimientosModel;
    }

    
    public String irDetalleTareas(SeguimientoInformacionMmb seguimientoModelo)
    {
        
    sesion.setSeguimiento(seguimientoModelo.getSeguimiento());
    return "irDetalleTareas";
    }
}
