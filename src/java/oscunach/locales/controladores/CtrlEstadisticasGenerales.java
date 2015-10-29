/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.locales.controladores;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import oscunach.locales.busquedas.BusquedasLocales;
import recursos.CircuitoSubcircuitoUrbano;
import recursos.Util;

/**
 *
 * @author servidor
 */
@ManagedBean
@RequestScoped
public class CtrlEstadisticasGenerales {

    private CartesianChartModel estadisticasCircuitos;
    private CartesianChartModel estadisticasSubcircuitos;
    private CartesianChartModel estadisticasParroquias;
    private PieChartModel pieCircuitos;
    private PieChartModel pieSubcircuitos;
    private PieChartModel pieParroquias;
    private ArrayList<String> lst;

    public ArrayList<String> getLst() {
        return lst;
    }

    public void setLst(ArrayList<String> lst) {
        this.lst = lst;
    }

    public CartesianChartModel getEstadisticasCircuitos() {
        return estadisticasCircuitos;
    }

    public void setEstadisticasCircuitos(CartesianChartModel estadisticasCircuitos) {
        this.estadisticasCircuitos = estadisticasCircuitos;
    }

    public CartesianChartModel getEstadisticasSubcircuitos() {
        return estadisticasSubcircuitos;
    }

    public void setEstadisticasSubcircuitos(CartesianChartModel estadisticasSubcircuitos) {
        this.estadisticasSubcircuitos = estadisticasSubcircuitos;
    }

    public CartesianChartModel getEstadisticasParroquias() {
        return estadisticasParroquias;
    }

    public void setEstadisticasParroquias(CartesianChartModel estadisticasParroquias) {
        this.estadisticasParroquias = estadisticasParroquias;
    }

    public PieChartModel getPieCircuitos() {
        return pieCircuitos;
    }

    public void setPieCircuitos(PieChartModel pieCircuitos) {
        this.pieCircuitos = pieCircuitos;
    }

    public PieChartModel getPieSubcircuitos() {
        return pieSubcircuitos;
    }

    public void setPieSubcircuitos(PieChartModel pieSubcircuitos) {
        this.pieSubcircuitos = pieSubcircuitos;
    }

    public PieChartModel getPieParroquias() {
        return pieParroquias;
    }

    public void setPieParroquias(PieChartModel pieParroquias) {
        this.pieParroquias = pieParroquias;
    }

    public CtrlEstadisticasGenerales() {
        this.lst=new ArrayList<String>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        estadisticasCircuitos=seriesCircuitos();
        pieCircuitos=pieCircuitos();

    }

    private CartesianChartModel seriesCircuitos() {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano();
            ChartSeries circuitos = new ChartSeries();
            circuitos.setLabel("Estadísticas por circuitos");
            for (String lst1 : lst) {
                circuitos.set(lst1, BusquedasLocales.obtenerDatosDadoCircuito(lst1).size());
            }
            model.addSeries(circuitos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

   private PieChartModel pieCircuitos() {
        PieChartModel pieModel = new PieChartModel();
        try {
            pieModel = new PieChartModel();
            lst = CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano();
            for (int i=0;i<lst.size();i++){
                pieModel.set(lst.get(i), BusquedasLocales.obtenerDatosDadoCircuito(lst.get(i)).size());
            }

        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
        return pieModel;
    }


}
