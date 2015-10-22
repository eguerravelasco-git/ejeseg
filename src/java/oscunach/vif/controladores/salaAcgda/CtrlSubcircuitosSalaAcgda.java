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
import recursos.CircuitoSubcircuitoUrbano;

/**
 *
 * @author Oscunach
 */
@ManagedBean
@RequestScoped
public class CtrlSubcircuitosSalaAcgda {

    /**
     * Creates a new instance of CtrlSubcircuitosSalaAcgda
     */
    private ArrayList<String> lst;
    private int anioSel;
    private CartesianChartModel graficSubcircuito;
    private CartesianChartModel graficSubcircuitoGenero;

    public CartesianChartModel getGraficSubcircuito() {
        return graficSubcircuito;
    }

    public void setGraficSubcircuito(CartesianChartModel graficSubcircuito) {
        this.graficSubcircuito = graficSubcircuito;
    }

    public CartesianChartModel getGraficSubcircuitoGenero() {
        return graficSubcircuitoGenero;
    }

    public void setGraficSubcircuitoGenero(CartesianChartModel graficSubcircuitoGenero) {
        this.graficSubcircuitoGenero = graficSubcircuitoGenero;
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

    public CtrlSubcircuitosSalaAcgda() {
        this.lst = new ArrayList<String>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        this.graficSubcircuito = subcircuitos(anioSel);
        this.graficSubcircuitoGenero = subcircuitosGenero(anioSel);

    }

    private CartesianChartModel subcircuitos(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries circuitos = new ChartSeries();
            circuitos.setLabel("Subcircuitos");
            lst = CircuitoSubcircuitoUrbano.obtenerSubcircuitoUrbano();
            for (int i = 0; i < lst.size(); i++) {
                circuitos.set(lst.get(i), FBSalaAcgda.obtenerDatosDadoAnioSubcircuito(anio, lst.get(i)).size());
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
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i), FBSalaAcgda.obtenerDatosDadoAnioSubcircuitoGenero(anio, lst.get(i), "F").size());
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i), FBSalaAcgda.obtenerDatosDadoAnioSubcircuitoGenero(anio, lst.get(i), "M").size());
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
}
