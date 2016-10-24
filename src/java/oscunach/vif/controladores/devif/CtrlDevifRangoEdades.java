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
public class CtrlDevifRangoEdades {

    private ArrayList<Devif> lstRangos;
    private CartesianChartModel graficaEdades;
    private CartesianChartModel graficaEdadesGenero;
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
    
    public ArrayList<Devif> getLstRangos() {
        return lstRangos;
    }

    public void setLstRangos(ArrayList<Devif> lstRangos) {
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

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CtrlDevifRangoEdades() {
        this.reinit();
    }
    
    private void reinit() {
        this.lstRangos = new ArrayList<Devif>();
        this.lst1 = new ArrayList<Devif>();
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
            this.lst1 = FBDevif.obtenerDatosDadoAnio(anioSel);
            this.totalDenuncias = lst1.size();
            lstRangos = FBDevif.obtenerRangosEdadDadoAnio(anio);
            for (int i = 0; i < lstRangos.size(); i++) {                
                edades.set(lstRangos.get(i).getRango_edad_victima(), FBDevif.obtenerDatosDadoRangosEdadDadoAnio(anio, lstRangos.get(i).getRango_edad_victima()).size());
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
            lstRangos = FBDevif.obtenerRangosEdadDadoAnio(anio);
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");    
            this.lst1 = FBDevif.obtenerDatosDadoAnio(anioSel);
            this.totalDenuncias = lst1.size();
            for (int i = 0; i < lstRangos.size(); i++) {                
                femenino.set(lstRangos.get(i).getRango_edad_victima(), FBDevif.obtenerDatosDadoRangosEdadDadoAnioGenero(anio, lstRangos.get(i).getRango_edad_victima(),"F").size());
                femeninoTotal= femeninoTotal+FBDevif.obtenerDatosDadoRangosEdadDadoAnioGenero(anio, lstRangos.get(i).getRango_edad_victima(),"F").size();
            }
            
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");            
            for (int i = 0; i < lstRangos.size(); i++) {                
                masculino.set(lstRangos.get(i).getRango_edad_victima(), FBDevif.obtenerDatosDadoRangosEdadDadoAnioGenero(anio, lstRangos.get(i).getRango_edad_victima(),"M").size());
                masculinoTotal=masculinoTotal+FBDevif.obtenerDatosDadoRangosEdadDadoAnioGenero(anio, lstRangos.get(i).getRango_edad_victima(),"M").size();
            }
            
            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
