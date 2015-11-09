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


/**
 *
 * @author ICITS SALA5
 */
@ManagedBean
@RequestScoped
public class CrtlFiscaliaAnioOcupacion {

     private ArrayList<FichaVif>lst;
    private int aniosel;
    private CartesianChartModel graficarOcupacion;
    private CartesianChartModel graficarOcupacioGewero;

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
            lst = FBFichaFiscalia.obtenerOcupacionesDadoAnio(anio);
            ChartSeries ocupaciones = new ChartSeries();
            ocupaciones.setLabel("Ocupaciones");
            for (int i = 0; i < lst.size(); i++) {
                ocupaciones.set(lst.get(i).getOcupacion_victima(), FBFichaFiscalia.obtenerFichaDadoAnioOcupacion(anio, lst.get(i).getOcupacion_victima()).size());
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
            lst = lst = FBFichaFiscalia.obtenerOcupacionesDadoAnio(anio);
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i).getOcupacion_victima(),FBFichaFiscalia.obtenerFichaDadoAnioOcupacionGenero(anio, lst.get(i).getOcupacion_victima(), "Masculino") .size());
            }
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                 femenino.set(lst.get(i).getOcupacion_victima(),FBFichaFiscalia.obtenerFichaDadoAnioOcupacionGenero(anio, lst.get(i).getOcupacion_victima(), "FEMENINO") .size());
              }
            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
}

