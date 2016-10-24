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
public class CtrlDevifTipoViolencia {

    private ArrayList<Devif> lst;
    private ArrayList<Devif> lst1;
    private int anioSel;
    private CartesianChartModel graficaTipoViolencia;
    private CartesianChartModel graficaTipoViolenciaGenero;
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

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CartesianChartModel getGraficaTipoViolencia() {
        return graficaTipoViolencia;
    }

    public void setGraficaTipoViolencia(CartesianChartModel graficaTipoViolencia) {
        this.graficaTipoViolencia = graficaTipoViolencia;
    }

    public CartesianChartModel getGraficaTipoViolenciaGenero() {
        return graficaTipoViolenciaGenero;
    }

    public void setGraficaTipoViolenciaGenero(CartesianChartModel graficaTipoViolenciaGenero) {
        this.graficaTipoViolenciaGenero = graficaTipoViolenciaGenero;
    }

    public CtrlDevifTipoViolencia() {
        this.lst = new ArrayList<Devif>();
        this.lst1 = new ArrayList<Devif>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        graficaTipoViolencia = violencia(anioSel);
        graficaTipoViolenciaGenero = violenciaGenero(anioSel);

    }

    private CartesianChartModel violencia(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries violencia = new ChartSeries();
            violencia.setLabel("Circuitos");
            this.lst1 = FBDevif.obtenerDatosDadoAnio(anioSel);
            this.totalDenuncias = lst1.size();
            //lst = FBVifUrbano.obtenerTipoViolenciaDadoAnio(anio);
            lst = FBDevif.obtenerTipoViolenciaDadoAnio(anio);
            for (int i = 0; i < lst.size(); i++) {
                violencia.set(lst.get(i).getTipo_violencia(), FBDevif.obtenerDatosDadoAnioTipoViolencia(anio, lst.get(i).getTipo_violencia()).size());
            }
            model.addSeries(violencia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel violenciaGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = FBDevif.obtenerTipoViolenciaDadoAnio(anio);
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            this.lst1 = FBDevif.obtenerDatosDadoAnio(anioSel);
            this.totalDenuncias = lst1.size();
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i).getTipo_violencia(), FBDevif.obtenerDatosDadoAnioTipoViolenciaGenero(anio, lst.get(i).getTipo_violencia(), "F").size());
                femeninoTotal= femeninoTotal+FBDevif.obtenerDatosDadoAnioTipoViolenciaGenero(anio, lst.get(i).getTipo_violencia(), "F").size();
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i).getTipo_violencia(), FBDevif.obtenerDatosDadoAnioTipoViolenciaGenero(anio, lst.get(i).getTipo_violencia(), "M").size());
                masculinoTotal=masculinoTotal+FBDevif.obtenerDatosDadoAnioTipoViolenciaGenero(anio, lst.get(i).getTipo_violencia(), "M").size();
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
