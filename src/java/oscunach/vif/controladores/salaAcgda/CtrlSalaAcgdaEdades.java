/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.salaAcgda;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import oscunach.vif.busquedas.FBSalaAcgda;
import oscunach.vif.entidades.SalaAcgda;
import recursos.Edades;
import recursos.RangoEdades;

/**
 *
 * @author Oscunach
 */
@ManagedBean
@RequestScoped
public class CtrlSalaAcgdaEdades {

    /**
     * Creates a new instance of CtrlSalaAcgdaEdades
     */
    private ArrayList<RangoEdades> lstRangos;
    private CartesianChartModel graficaEdades;
    private CartesianChartModel graficaEdadesGenero;
    private int anioSel;
    private ArrayList<SalaAcgda> lst1;
    private int totalDenuncias;
    private int femeninoTotal;
    private int masculinoTotal;

    public ArrayList<SalaAcgda> getLst1() {
        return lst1;
    }

    public void setLst1(ArrayList<SalaAcgda> lst1) {
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

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public ArrayList<RangoEdades> getLstRangos() {
        return lstRangos;
    }

    public void setLstRangos(ArrayList<RangoEdades> lstRangos) {
        this.lstRangos = lstRangos;
    }

    public CartesianChartModel getGraficaEdades() {
        return graficaEdades;
    }

    public void setGraficaEdades(CartesianChartModel graficaEdades) {
        this.graficaEdades = graficaEdades;
    }

    public CartesianChartModel getGraficaEdadesGenero() {
        return graficaEdadesGenero;
    }

    public void setGraficaEdadesGenero(CartesianChartModel graficaEdadesGenero) {
        this.graficaEdadesGenero = graficaEdadesGenero;
    }

    public CtrlSalaAcgdaEdades() {
        this.reinit();
    }

    private void reinit() {
        this.lstRangos = new ArrayList<RangoEdades>();
        this.lst1 = new ArrayList<SalaAcgda>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        graficaEdades = edades(anioSel);
        graficaEdadesGenero = edadesGenero(anioSel);
    }

    private CartesianChartModel edades(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries edades = new ChartSeries();
            edades.setLabel("Rango de Edades");
            lstRangos = Edades.obtenerRangoEdades();
            this.lst1 = FBSalaAcgda.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst1.size();
            for (int i = 0; i < lstRangos.size(); i++) {
                edades.set(lstRangos.get(i).getEspecificacion(), FBSalaAcgda.obtenerDatosDadoAnioRangoEdad(anio, lstRangos.get(i).getRango()).size());
            }
            model.addSeries(edades);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel edadesGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lstRangos = Edades.obtenerRangoEdades();
            this.lst1 = FBSalaAcgda.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst1.size();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lstRangos.size(); i++) {
                femenino.set(lstRangos.get(i).getEspecificacion(), FBSalaAcgda.obtenerDatosDadoAnioRangoEdadGenero(anio, lstRangos.get(i).getRango(), "F").size());
                femeninoTotal = femeninoTotal + FBSalaAcgda.obtenerDatosDadoAnioRangoEdadGenero(anio, lstRangos.get(i).getRango(), "F").size();
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lstRangos.size(); i++) {
                masculino.set(lstRangos.get(i).getEspecificacion(), FBSalaAcgda.obtenerDatosDadoAnioRangoEdadGenero(anio, lstRangos.get(i).getRango(), "M").size());
                masculinoTotal = masculinoTotal + FBSalaAcgda.obtenerDatosDadoAnioRangoEdadGenero(anio, lstRangos.get(i).getRango(), "M").size();
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
