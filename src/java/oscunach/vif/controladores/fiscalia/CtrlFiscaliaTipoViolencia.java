/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.fiscalia;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import oscunach.vif.busquedas.FBFichaFiscalia;
import oscunach.vif.entidades.FichaVif;

/**
 *
 * @author servidor
 */
@ManagedBean
@RequestScoped
public class CtrlFiscaliaTipoViolencia {

    private int aniosel;
    private CartesianChartModel graficarViolencia;
    private CartesianChartModel graficarViolenciaGenero;
    private ArrayList<FichaVif> lst1;
    private int totalDenuncias;
    private int femeninoTotal;
    private int masculinoTotal;

    public CtrlFiscaliaTipoViolencia() {
        this.lst1 = new ArrayList<FichaVif>();
    }

    @PostConstruct
    public void graficar() {
        graficarViolencia = violencia(aniosel);
        graficarViolenciaGenero = violenciaGenero(aniosel);

    }

    private CartesianChartModel violencia(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {

            ChartSeries mes = new ChartSeries();
            this.lst1 = FBFichaFiscalia.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst1.size();
            mes.setLabel("Violencia");
            for (int i = 0; i < FBFichaFiscalia.obtenerTiposViolenciaDadoAnio(anio).size(); i++) {

                mes.set(FBFichaFiscalia.obtenerTiposViolenciaDadoAnio(anio).get(i).getTipo_violencia(),
                        FBFichaFiscalia.obtenerFichaDadoAnioTipoViolencia(anio, FBFichaFiscalia.obtenerTiposViolenciaDadoAnio(anio).get(i).getTipo_violencia()).size());
            }
            model.addSeries(mes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return model;

    }

    private CartesianChartModel violenciaGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            this.lst1 = FBFichaFiscalia.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst1.size();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < FBFichaFiscalia.obtenerTiposViolenciaDadoAnio(anio).size(); i++) {
                femenino.set(FBFichaFiscalia.obtenerTiposViolenciaDadoAnio(anio).get(i).getTipo_violencia(),
                        FBFichaFiscalia.obtenerFichaDadoAnioTipoViolenciaGenero(anio, FBFichaFiscalia.obtenerTiposViolenciaDadoAnio(anio).get(i).getTipo_violencia(), "Femenino").size());
                femeninoTotal= femeninoTotal+FBFichaFiscalia.obtenerFichaDadoAnioTipoViolenciaGenero(anio, FBFichaFiscalia.obtenerTiposViolenciaDadoAnio(anio).get(i).getTipo_violencia(), "Femenino").size();
            }
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < FBFichaFiscalia.obtenerTiposViolenciaDadoAnio(anio).size(); i++) {
                masculino.set(FBFichaFiscalia.obtenerTiposViolenciaDadoAnio(anio).get(i).getTipo_violencia(),
                        FBFichaFiscalia.obtenerFichaDadoAnioTipoViolenciaGenero(anio, FBFichaFiscalia.obtenerTiposViolenciaDadoAnio(anio).get(i).getTipo_violencia(), "Masculino").size());
                masculinoTotal=masculinoTotal+FBFichaFiscalia.obtenerFichaDadoAnioTipoViolenciaGenero(anio, FBFichaFiscalia.obtenerTiposViolenciaDadoAnio(anio).get(i).getTipo_violencia(), "Masculino").size();
            }
            model.addSeries(femenino);
            model.addSeries(masculino);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;

    }

    /*
     ** get y set
     */
    public ArrayList<FichaVif> getLst1() {
        return lst1;
    }

    public void setLst1(ArrayList<FichaVif> lst1) {
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

    public int getAniosel() {
        return aniosel;
    }

    public void setAniosel(int aniosel) {
        this.aniosel = aniosel;
    }

    public CartesianChartModel getGraficarViolencia() {
        return graficarViolencia;
    }

    public void setGraficarViolencia(CartesianChartModel graficarViolencia) {
        this.graficarViolencia = graficarViolencia;
    }

    public CartesianChartModel getGraficarViolenciaGenero() {
        return graficarViolenciaGenero;
    }

    public void setGraficarViolenciaGenero(CartesianChartModel graficarViolenciaGenero) {
        this.graficarViolenciaGenero = graficarViolenciaGenero;
    }

}
