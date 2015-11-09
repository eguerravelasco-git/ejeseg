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
import recursos.CircuitoSubcircuitoUrbano;

/**
 *
 * @author ICITS SALA5
 */
@ManagedBean
@RequestScoped
public class CtrlFiscaliaAnioSubcircuito {

    private ArrayList<String> lst;
    private int aniosel;
    private CartesianChartModel graficaSubcircuito;
    private CartesianChartModel graficaSubcircuitoGenero;

    public ArrayList<String> getLst() {
        return lst;
    }

    public void setLst(ArrayList<String> lst) {
        this.lst = lst;
    }

    public int getAniosel() {
        return aniosel;
    }

    public void setAniosel(int aniosel) {
        this.aniosel = aniosel;
    }

    public CartesianChartModel getGraficaSubcircuito() {
        return graficaSubcircuito;
    }

    public void setGraficaSubcircuito(CartesianChartModel graficaSubcircuito) {
        this.graficaSubcircuito = graficaSubcircuito;
    }

    public CartesianChartModel getGraficaSubcircuitoGenero() {
        return graficaSubcircuitoGenero;
    }

    public void setGraficaSubcircuitoGenero(CartesianChartModel graficaSubcircuitoGenero) {
        this.graficaSubcircuitoGenero = graficaSubcircuitoGenero;
    }

    public CtrlFiscaliaAnioSubcircuito() {
        this.lst = new ArrayList<String>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        graficaSubcircuito = subcircuito(aniosel);
        graficaSubcircuito = subcircuitoGenero(aniosel);
    }

    private CartesianChartModel subcircuito(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = CircuitoSubcircuitoUrbano.obtenerSubcircuitoUrbano();
            ChartSeries subcircuito = new ChartSeries();
            subcircuito.setLabel("Subcircuito");
            for (int i = 0; i < lst.size(); i++) {
                subcircuito.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioSubcircuito(anio, lst.get(i)).size());
            }
            model.addSeries(subcircuito);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        return model;
    }

     private CartesianChartModel subcircuitoGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = CircuitoSubcircuitoUrbano.obtenerSubcircuitoUrbano();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioSubcircuitoGenero(anio, lst.get(i), "Femenino").size());
            }
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioSubcircuitoGenero(anio, lst.get(i), "Masculino").size());
            }
            model.addSeries(femenino);
            model.addSeries(masculino);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;

    }

}
