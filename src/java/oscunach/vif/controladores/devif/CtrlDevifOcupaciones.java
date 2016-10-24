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
    private ArrayList<Devif> lst1;
    private int totalDenuncias;
    private int femeninoTotal;
    private int masculinoTotal;

    public ArrayList<Devif> getLst1() {
        return lst1;
    }

    public void setLst1(ArrayList<Devif> lst1) {
        this.lst1 = lst1;
    }

    public int getTotalDenuncias() {
        return totalDenuncias;
    }

    public void setTotalDenuncias(int totalDenuncias) {
        this.totalDenuncias = totalDenuncias;
    }

    public int getFemeninoTotal() {
        return femeninoTotal;
    }

    public void setFemeninoTotal(int femeninoTotal) {
        this.femeninoTotal = femeninoTotal;
    }

    public int getMasculinoTotal() {
        return masculinoTotal;
    }

    public void setMasculinoTotal(int masculinoTotal) {
        this.masculinoTotal = masculinoTotal;
    }

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
        this.lst1 = new ArrayList<Devif>();
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
            this.lst1 = FBDevif.obtenerDatosDadoAnio(anioSel);
            this.totalDenuncias = lst1.size();
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
            this.lst1 = FBDevif.obtenerDatosDadoAnio(anioSel);
            this.totalDenuncias = lst1.size();
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i).getProfesion_ocupacion_victima(), FBDevif.obtenerDatosDadoAnioOcupacionGenero(anio, lst.get(i).getProfesion_ocupacion_victima(), "M").size());
                masculinoTotal = masculinoTotal + FBDevif.obtenerDatosDadoAnioOcupacionGenero(anio, lst.get(i).getProfesion_ocupacion_victima(), "M").size();

            }
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i).getProfesion_ocupacion_victima(), FBDevif.obtenerDatosDadoAnioOcupacionGenero(anio, lst.get(i).getProfesion_ocupacion_victima(), "F").size());
                femeninoTotal = femeninoTotal + FBDevif.obtenerDatosDadoAnioOcupacionGenero(anio, lst.get(i).getProfesion_ocupacion_victima(), "F").size();
            }
            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
