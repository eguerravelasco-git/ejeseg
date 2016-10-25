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
import recursos.CircuitoSubcircuitoUrbano;

/**
 *
 * @author ICITS SALA5
 */
@ManagedBean
@RequestScoped
public class CtrlFiscaliaAnioSubcircuito {

    private ArrayList<String> lst;
    private int anioSel;
    private CartesianChartModel graficaSubcircuitos;
    private CartesianChartModel graficaSubcircuitosGenero;
    private ArrayList<FichaVif> lst1;
    private int totalDenuncias;
    private int femeninoTotal;
    private int masculinoTotal;

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

    public ArrayList<String> getLst() {
        return lst;
    }

    public void setLst(ArrayList<String> lst) {
        this.lst = lst;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CartesianChartModel getGraficaSubcircuitos() {
        return graficaSubcircuitos;
    }

    public void setGraficaSubcircuitos(CartesianChartModel graficaSubcircuitos) {
        this.graficaSubcircuitos = graficaSubcircuitos;
    }

    public CartesianChartModel getGraficaSubcircuitosGenero() {
        return graficaSubcircuitosGenero;
    }

    public void setGraficaSubcircuitosGenero(CartesianChartModel graficaSubcircuitosGenero) {
        this.graficaSubcircuitosGenero = graficaSubcircuitosGenero;
    }

    

    public CtrlFiscaliaAnioSubcircuito() {
        this.lst = new ArrayList<String>();
        this.lst1 = new ArrayList<FichaVif>();
        this.graficar();

    }

    @PostConstruct
    public void graficar() {
        graficaSubcircuitos = subcircuitos(anioSel);
        graficaSubcircuitosGenero = subcircuitosGenero(anioSel);

    }

    private CartesianChartModel subcircuitos(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = CircuitoSubcircuitoUrbano.obtenerSubcircuitoUrbano();
            this.lst1 = FBFichaFiscalia.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst1.size();

            ChartSeries circuitos = new ChartSeries();
            circuitos.setLabel("Subircuitos");
            for (int i = 0; i < lst.size(); i++) {
                circuitos.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioSubcircuito(anio, lst.get(i)).size());
            }
            model.addSeries(circuitos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel subcircuitosGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = CircuitoSubcircuitoUrbano.obtenerSubcircuitoUrbano();
            this.lst1 = FBFichaFiscalia.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst1.size();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioSubcircuitoGenero(anio, lst.get(i), "Femenino").size());
                System.out.println(lst.get(i) + FBFichaFiscalia.obtenerFichaDadoAnioSubcircuitoGenero(anio, lst.get(i), "Femenino").size());
                femeninoTotal= femeninoTotal+FBFichaFiscalia.obtenerFichaDadoAnioSubcircuitoGenero(anio, lst.get(i), "Femenino").size();
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioSubcircuitoGenero(anio, lst.get(i), "Masculino").size());
                masculinoTotal=masculinoTotal+FBFichaFiscalia.obtenerFichaDadoAnioSubcircuitoGenero(anio, lst.get(i), "Masculino").size();
            }
            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
