/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.crm.vmb;

import com.co.crm.components.SeguimientoInformacionMmb;
import com.co.crm.entities.Seguimiento;
import com.co.crm.entities.Usuario;
import com.co.crm.services.SeguimientoServicio;
import com.co.crm.services.SupervisorVendedorServicio;
import com.co.crm.services.UsuarioServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
 * @author Andrés
 */
@Named
@ViewScoped
public class ListaSupervisoresVmb implements Serializable {

    @Inject
    UsuarioServicio usuarioServicio;
    @Inject
    SupervisorVendedorServicio supervisorVendedorServicio;
    @Inject
    UserSmb session;
    @Inject
    SeguimientoServicio seguimientoServicio;

    private Map<String, Long> supervisores;
    private List<Usuario> vendedoresPorSupervisor;
    private Long idSupervisor;
    private List<SeguimientoInformacionMmb> seguimientosPorSupervisor;
    private ChartSeries seguimientosData;
    private BarChartModel seguimientosModel;
    private PieChartModel seguimientosPieChartModel;
    private List<Seguimiento> seguimientosEstadisticas;

    @PostConstruct
    public void init() {
        supervisores = usuarioServicio.buscarTodosLosSupervisoresMapServicio();

    }

    public void buscarVendedoresPorSupervisor() {
        vendedoresPorSupervisor = supervisorVendedorServicio.buscarContactosPorVendedor(idSupervisor);
        seguimientosPorSupervisor = seguimientoServicio.seguimientosVendedoresPorSupervisorServicio(idSupervisor);
        cargarSoloSeguimientos();
        inizializarModel();
        getSeguimientosPieChartModel();
    }
    
    
    public void nullear() {
        vendedoresPorSupervisor = supervisorVendedorServicio.buscarContactosPorVendedor(null);
        seguimientosPorSupervisor = seguimientoServicio.seguimientosVendedoresPorSupervisorServicio(null);
        cargarSoloSeguimientos();
        inizializarModel();
        getSeguimientosPieChartModel();
    }

    public void cargarSoloSeguimientos() {
        seguimientosEstadisticas = new ArrayList<>();
        for (int i = 0; i < seguimientosPorSupervisor.size(); i++) {
            seguimientosEstadisticas.add(seguimientosPorSupervisor.get(i).getSeguimiento());
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
        yAxis.setMax(seguimientosEstadisticas.size());

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

    public String irDetalleVendedor(Usuario vendedor) {
        session.setVendedorSession(vendedor);
        return "irDetalleVendedor";
    }

    /*Getters & Setters*/
    public Map<String, Long> getSupervisores() {
        return supervisores;
    }

    public void setSupervisores(Map<String, Long> supervisores) {
        this.supervisores = supervisores;
    }

    public List<Usuario> getVendedoresPorSupervisor() {
        return vendedoresPorSupervisor;
    }

    public void setVendedoresPorSupervisor(List<Usuario> vendedoresPorSupervisor) {
        this.vendedoresPorSupervisor = vendedoresPorSupervisor;
    }

    public Long getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Long idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public List<SeguimientoInformacionMmb> getSeguimientosPorSupervisor() {
        return seguimientosPorSupervisor;
    }

    public void setSeguimientosPorSupervisor(List<SeguimientoInformacionMmb> seguimientosPorSupervisor) {
        this.seguimientosPorSupervisor = seguimientosPorSupervisor;
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

}
