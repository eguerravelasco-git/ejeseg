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
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import oscunach.vif.busquedas.FBSalaAcgda;
import oscunach.vif.entidades.SalaAcgda;
import recursos.CircuitoSubcircuitoUrbano;

/**
 *
 * @author Oscunach
 */
@ManagedBean
@RequestScoped
public class CtrlCircuitosSalaAcgda {

    /**
     * Creates a new instance of CtrlCircuitosSalaAcgda
     */
    private ArrayList<String> lst;
    private CartesianChartModel graficaCircuitos;
    private CartesianChartModel graficaCircuitosGenero;
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

    public CartesianChartModel getGraficaCircuitos() {
        return graficaCircuitos;
    }

    public void setGraficaCircuitos(CartesianChartModel graficaCircuitos) {
        this.graficaCircuitos = graficaCircuitos;
    }

    public CartesianChartModel getGraficaCircuitosGenero() {
        return graficaCircuitosGenero;
    }

    public void setGraficaCircuitosGenero(CartesianChartModel graficaCircuitosGenero) {
        this.graficaCircuitosGenero = graficaCircuitosGenero;
    }

    public ArrayList<String> getLst() {
        return lst;
    }

    public void setLst(ArrayList<String> lst) {
        this.lst = lst;
    }

    public CtrlCircuitosSalaAcgda() {
        this.reinit();
    }

    private void reinit() {
        this.lst = new ArrayList<String>();
        this.lst1 = new ArrayList<SalaAcgda>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        this.graficaCircuitos = circuitos(anioSel);
        this.graficaCircuitosGenero = circuitosGenero(anioSel);

    }

    private CartesianChartModel circuitos(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries circuitos = new ChartSeries();
            circuitos.setLabel("Circuitos");
            lst = CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano();
            this.lst1 = FBSalaAcgda.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst1.size();
            for (int i = 0; i < lst.size(); i++) {
                circuitos.set(lst.get(i), FBSalaAcgda.obtenerDatosDadoAnioCircuito(anio, lst.get(i)).size());
            }
            model.addSeries(circuitos);
            DefaultRequestContext.getCurrentInstance().execute("dlgStatus.hide()");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel circuitosGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            this.lst1 = FBSalaAcgda.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst1.size();
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i), FBSalaAcgda.obtenerDatosDadoAnioCircuitoGenero(anio,lst.get(i),"F").size());
                femeninoTotal= femeninoTotal+FBSalaAcgda.obtenerDatosDadoAnioCircuitoGenero(anio,lst.get(i),"F").size();
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i), FBSalaAcgda.obtenerDatosDadoAnioCircuitoGenero(anio, lst.get(i), "M").size());
                masculinoTotal=masculinoTotal+FBSalaAcgda.obtenerDatosDadoAnioCircuitoGenero(anio, lst.get(i), "M").size();
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
            DefaultRequestContext.getCurrentInstance().execute("dlgStatus.hide()");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
