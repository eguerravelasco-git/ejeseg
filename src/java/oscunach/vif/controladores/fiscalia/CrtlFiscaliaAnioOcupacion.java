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
import recursos.Ocupaciones;

/**
 *
 * @author ICITS SALA5
 */
@ManagedBean
@RequestScoped
public class CrtlFiscaliaAnioOcupacion {

    private ArrayList<FichaVif> lst;
    private ArrayList<String> lst1;
    private int aniosel;
    private CartesianChartModel graficarOcupacion;
    private CartesianChartModel graficarOcupacioGewero;

    public ArrayList<String> getLst1() {
        return lst1;
    }

    public void setLst1(ArrayList<String> lst1) {
        this.lst1 = lst1;
    }

    public CartesianChartModel getGraficarOcupacion() {
        return graficarOcupacion;
    }

    public void setGraficarOcupacion(CartesianChartModel graficarOcupacion) {
        this.graficarOcupacion = graficarOcupacion;
    }

    public ArrayList<FichaVif> getLst() {
        return lst;
    }

    public void setLst(ArrayList<FichaVif> lst) {
        this.lst = lst;
    }

    public int getAniosel() {
        return aniosel;
    }

    public void setAniosel(int aniosel) {
        this.aniosel = aniosel;
    }

    public CartesianChartModel getGraficarocupacion() {
        return graficarOcupacion;
    }

    public void setGraficarocupacion(CartesianChartModel graficarocupacion) {
        this.graficarOcupacion = graficarocupacion;
    }

    public CartesianChartModel getGraficarOcupacioGewero() {
        return graficarOcupacioGewero;
    }

    public void setGraficarOcupacioGewero(CartesianChartModel graficarOcupacioGewero) {
        this.graficarOcupacioGewero = graficarOcupacioGewero;
    }

    public CrtlFiscaliaAnioOcupacion() {
        this.graficar();
    }

    @PostConstruct

    public void graficar() {
        this.graficarOcupacion = ocupaciones(aniosel);
        this.graficarOcupacioGewero = ocupacionesGenero(aniosel);
    }

    private CartesianChartModel ocupaciones(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
           // lst = FBFichaFiscalia.obtenerOcupacionesDadoAnio(anio);
            lst1 = Ocupaciones.enlistarOcupaciones();
            ChartSeries ocupaciones = new ChartSeries();
            ocupaciones.setLabel("Ocupaciones");
            for (int i = 0; i < lst1.size(); i++) {
                ocupaciones.set(lst1.get(i), FBFichaFiscalia.obtenerFichaDadoAnioOcupacion(anio, lst1.get(i)).size());
            }
            model.addSeries(ocupaciones);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel ocupacionesGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            //lst = FBFichaFiscalia.obtenerOcupacionesDadoAnio(anio);
            lst1 = Ocupaciones.enlistarOcupaciones();
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst1.size(); i++) {
                masculino.set(lst1.get(i), FBFichaFiscalia.obtenerFichaDadoAnioOcupacionGenero(anio, lst1.get(i), "Masculino").size());
            }
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst1.size(); i++) {
                femenino.set(lst1.get(i), FBFichaFiscalia.obtenerFichaDadoAnioOcupacionGenero(anio, lst1.get(i), "Femenino").size());
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
}
