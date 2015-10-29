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
import oscunach.vif.entidades.VifRural;
import oscunach.vif.entidades.VifUrbano;
import recursos.RangoEdades;

/**
 *
 * @author oscunach
 */
@ManagedBean
@RequestScoped
public final class CtrlRuralTipoViolencia {

    private CartesianChartModel graficaTipoViolencia;
    private CartesianChartModel graficaTipoViolenciaGenero;
    private ArrayList<VifRural> lst;
    private int anioSel;

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

    public ArrayList<VifRural> getLst() {
        return lst;
    }

    public void setLst(ArrayList<VifRural> lst) {
        this.lst = lst;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CtrlRuralTipoViolencia() {

      this.reinit();
    }
    
    private void reinit() {
        this.lst = new ArrayList<VifRural>();
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
            lst = FBVifRural.obtenerTipoViolenciaDadoAnio(anio);
            for (int i = 0; i < lst.size(); i++) {
                violencia.set(lst.get(i).getTipo_de_violencia(), FBVifRural.obtenerDatosDadoAnioTipoViolencia(anio, lst.get(i).getTipo_de_violencia()).size());
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
            lst = FBVifRural.obtenerTipoViolenciaDadoAnio(anio);
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i).getTipo_de_violencia(), FBVifRural.obtenerDatosDadoAnioTipoViolenciaGenero(anio, lst.get(i).getTipo_de_violencia(), "F").size());
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i).getTipo_de_violencia(), FBVifRural.obtenerDatosDadoAnioTipoViolenciaGenero(anio, lst.get(i).getTipo_de_violencia(), "M").size());
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
}
