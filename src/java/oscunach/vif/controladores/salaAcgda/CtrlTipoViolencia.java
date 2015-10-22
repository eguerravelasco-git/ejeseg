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

/**
 *
 * @author Oscunach
 */
@ManagedBean
@RequestScoped
public class CtrlTipoViolencia {

    /**
     * Creates a new instance of CtrlTipoViolencia
     */
    private ArrayList<SalaAcgda> lst;
    private int anioSel;
    private CartesianChartModel graficaTipoViolencia;
    private CartesianChartModel graficaTipoViolenciaGenero;

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

    public ArrayList<SalaAcgda> getLst() {
        return lst;
    }

    public void setLst(ArrayList<SalaAcgda> lst) {
        this.lst = lst;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CtrlTipoViolencia() {
        this.lst = new ArrayList<SalaAcgda>();
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
            lst = FBSalaAcgda.obtenerTiposDeViolencia(anio);
            for (int i = 0; i < lst.size(); i++) {
                violencia.set(lst.get(i).getTipo_agresion(), FBSalaAcgda.obtenerDatosDadoAnioTipoViolencia(anio, lst.get(i).getTipo_agresion()).size());
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
            lst = FBSalaAcgda.obtenerTiposDeViolencia(anio);
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i).getTipo_agresion(), FBSalaAcgda.obtenerDatosDadoAnioTipoViolenciaGenero(anio, lst.get(i).getTipo_agresion(), "F").size());
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i).getTipo_agresion(), FBSalaAcgda.obtenerDatosDadoAnioTipoViolenciaGenero(anio, lst.get(i).getTipo_agresion(), "M").size());
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
