/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.devif;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import oscunach.vif.busquedas.FBDevif;
import oscunach.vif.entidades.Devif;

/**
 *
 * @author Geovanny
 */
@ManagedBean
@RequestScoped
public class CtrlDevifOcupaciones {

    private ArrayList<Devif> lst;
    private CartesianChartModel graficaOcupaciones;
    private CartesianChartModel graficaOcupacionesGenero;
    private int anioSel;

    public ArrayList<Devif> getLst() {
        return lst;
    }

    public void setLst(ArrayList<Devif> lst) {
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

    public CtrlDevifOcupaciones() {
        this.reinit();
    }
    
    private void reinit() {
        this.lst = new ArrayList<Devif>();
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
            lst = FBDevif.obtenerOcupacionesDadoAnio(anio);
            ChartSeries ocupaciones = new ChartSeries();
            ocupaciones.setLabel("Ocupaciones");
            for (int i = 0; i < lst.size(); i++) {
                ocupaciones.set(lst.get(i).getProfesion_ocupacion_victima(), FBDevif.obtenerDatosDadoAnioOcupacion(anio, lst.get(i).getProfesion_ocupacion_victima()).size());
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
            lst = FBDevif.obtenerOcupacionesDadoAnio(anio);
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i).getProfesion_ocupacion_victima(), FBDevif.obtenerDatosDadoAnioOcupacionGenero(anio, lst.get(i).getProfesion_ocupacion_victima(), "MASCULINO").size());
            }
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i).getProfesion_ocupacion_victima(), FBDevif.obtenerDatosDadoAnioOcupacionGenero(anio, lst.get(i).getProfesion_ocupacion_victima(), "FEMENINO").size());
            }
            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
