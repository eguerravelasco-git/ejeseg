/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.urbano;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import oscunach.vif.busquedas.FBVifUrbano;
import recursos.Ocupaciones;

/**
 *
 * @author Geovanny
 */
@ManagedBean
@RequestScoped
public class CtrlUrbanoOcupaciones {

    private ArrayList<String> lst;
    private CartesianChartModel graficaOcupaciones;
    private CartesianChartModel graficaOcupacionesGenero;
    private int anioSel;

    public ArrayList<String> getLst() {
        return lst;
    }

    public void setLst(ArrayList<String> lst) {
        this.lst = lst;
    }

    public CartesianChartModel getGraficaOcupaciones() {
        return graficaOcupaciones;
    }

    public void setGraficaOcupaciones(CartesianChartModel graficaOcupaciones) {
        this.graficaOcupaciones = graficaOcupaciones;
    }

    public CartesianChartModel getGraficaOcupacionesGenero() {
        return graficaOcupacionesGenero;
    }

    public void setGraficaOcupacionesGenero(CartesianChartModel graficaOcupacionesGenero) {
        this.graficaOcupacionesGenero = graficaOcupacionesGenero;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CtrlUrbanoOcupaciones() {
        this.reinit();
    }

    private void reinit() {
        this.lst = new ArrayList<String>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        this.graficaOcupaciones = ocupaciones(anioSel);
        this.graficaOcupacionesGenero = ocupacionesGenero(anioSel);
    }

    private CartesianChartModel ocupaciones(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = Ocupaciones.enlistarOcupaciones();
            ChartSeries ocupaciones = new ChartSeries();
            ocupaciones.setLabel("Ocupaciones");
            for (int i = 0; i < lst.size(); i++) {
                ocupaciones.set(lst.get(i), FBVifUrbano.obtenerDatosDadoAnioOcupacion(anio, lst.get(i)).size());
            }
            model.addSeries(ocupaciones);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel ocupacionesGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = Ocupaciones.enlistarOcupaciones();
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i), FBVifUrbano.obtenerDatosDadoAnioOcupacionGenero(anio, lst.get(i), "M").size());
            }
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i), FBVifUrbano.obtenerDatosDadoAnioOcupacionGenero(anio, lst.get(i), "F").size());
            }
            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
