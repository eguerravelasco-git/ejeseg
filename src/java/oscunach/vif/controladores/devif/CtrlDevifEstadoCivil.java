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
public class CtrlDevifEstadoCivil {

    private CartesianChartModel graficaEstadoCivil;
    private CartesianChartModel graficaEstadoCivilGenero;
    private int anioSel;
    private ArrayList<Devif> lst;
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
    
    public CartesianChartModel getGraficaEstadoCivil() {
        return graficaEstadoCivil;
    }

    public void setGraficaEstadoCivil(CartesianChartModel graficaEstadoCivil) {
        this.graficaEstadoCivil = graficaEstadoCivil;
    }

    public CartesianChartModel getGraficaEstadoCivilGenero() {
        return graficaEstadoCivilGenero;
    }

    public void setGraficaEstadoCivilGenero(CartesianChartModel graficaEstadoCivilGenero) {
        this.graficaEstadoCivilGenero = graficaEstadoCivilGenero;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public ArrayList<Devif> getLst() {
        return lst;
    }

    public void setLst(ArrayList<Devif> lst) {
        this.lst = lst;
    }

    public CtrlDevifEstadoCivil() {
        this.reinit();
    }

    private void reinit() {
        this.lst = new ArrayList<Devif>();
        this.lst1 = new ArrayList<Devif>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        this.graficaEstadoCivil = estadoCivil(anioSel);
        this.graficaEstadoCivilGenero = estadoCivilGenero(anioSel);

    }

    private CartesianChartModel estadoCivil(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = FBDevif.obtenerEstadoCivilDadoAnio(anio);
            ChartSeries estadoCivil = new ChartSeries();
            estadoCivil.setLabel("Estado Civil");
            this.lst1 = FBDevif.obtenerDatosDadoAnio(anioSel);
            this.totalDenuncias = lst1.size();

            for (int i = 0; i < lst.size(); i++) {
                estadoCivil.set(lst.get(i).getEstado_civil_victima(), FBDevif.obtenerDatosDadoAnioEstadoCivil(anio, lst.get(i).getEstado_civil_victima()).size());
            }
            model.addSeries(estadoCivil);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel estadoCivilGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = FBDevif.obtenerEstadoCivilDadoAnio(anio);
            this.lst1 = FBDevif.obtenerDatosDadoAnio(anioSel);
            this.totalDenuncias = lst1.size();

            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i).getEstado_civil_victima(), FBDevif.obtenerDatosDadoAnioEstadoCivilGenero(anio, lst.get(i).getEstado_civil_victima(), "F").size());
                femeninoTotal= femeninoTotal+FBDevif.obtenerDatosDadoAnioEstadoCivilGenero(anio, lst.get(i).getEstado_civil_victima(), "F").size();
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");

            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i).getEstado_civil_victima(), FBDevif.obtenerDatosDadoAnioEstadoCivilGenero(anio, lst.get(i).getEstado_civil_victima(), "M").size());
                masculinoTotal=masculinoTotal+FBDevif.obtenerDatosDadoAnioEstadoCivilGenero(anio, lst.get(i).getEstado_civil_victima(), "M").size();
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
}
