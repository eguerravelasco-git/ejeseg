/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.rural;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import oscunach.vif.busquedas.FBVifRural;
import oscunach.vif.busquedas.FBVifUrbano;
import recursos.Edades;
import recursos.RangoEdades;

/**
 *
 * @author oscunach
 */
@ManagedBean
@RequestScoped
public class CtrlRuralRangoEdad {

    private ArrayList<RangoEdades> lstRangos;
    private CartesianChartModel graficaEdades;
    private CartesianChartModel graficaEdadesGenero;
    private int anioSel;

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

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }
    
    
    
    public CtrlRuralRangoEdad() {
        this.reinit();
    }
    private void reinit() {
        this.lstRangos = new ArrayList<RangoEdades>();
        this.graficar();
    }
    
    @PostConstruct
    public void graficar(){
    this.graficaEdades=edades(anioSel);
    this.graficaEdadesGenero=edadesGenero(anioSel);
    }
    
    private CartesianChartModel edades(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries edades = new ChartSeries();
            edades.setLabel("Rango de Edades");
            lstRangos = Edades.obtenerRangoEdades();
            for (int i = 0; i < lstRangos.size(); i++) {                
                edades.set(lstRangos.get(i).getEspecificacion(), FBVifRural.obtenerDatosDadoAnioRangoEdad(anio, lstRangos.get(i).getRango()).size());
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
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");            
            for (int i = 0; i < lstRangos.size(); i++) {                
                femenino.set(lstRangos.get(i).getEspecificacion(), FBVifRural.obtenerDatosDadoAnioRangoEdadGenero(anio, lstRangos.get(i).getRango(),"F").size());
            }
            
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");            
            for (int i = 0; i < lstRangos.size(); i++) {                
                masculino.set(lstRangos.get(i).getEspecificacion(), FBVifRural.obtenerDatosDadoAnioRangoEdadGenero(anio, lstRangos.get(i).getRango(),"M").size());
            }
            
            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
}
