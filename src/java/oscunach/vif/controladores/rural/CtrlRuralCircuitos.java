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
import oscunach.vif.entidades.VifRural;
import recursos.CircuitoSubcircuitoRural;

/**
 *
 * @author oscunach
 */
@ManagedBean
@RequestScoped
public class CtrlRuralCircuitos {

    private ArrayList<VifRural> lst;
    private ArrayList<String>   lstCircuitos;
    private CartesianChartModel graficaCircuito;
    private CartesianChartModel graficaCircuitoGenero;

    
      
    private int anioSel;

    /* inicio metodo*/
    public ArrayList<String> getLstCircuitos() {
        return lstCircuitos;
    }

    public void setLstCircuitos(ArrayList<String> lstCircuitos) {
        this.lstCircuitos = lstCircuitos;
    }
     /*fin metodo */
    
    
    /* inicio metodo*/
    public ArrayList<VifRural> getLst() {
        return lst;
    }

    public void setLst(ArrayList<VifRural> lst) {
        this.lst = lst;
    }
    /*fin metodo */
    
    
     /* inicio metodo*/
    public CartesianChartModel getGraficaCircuito() {
        return graficaCircuito;
    }

    public void setGraficaCircuito(CartesianChartModel graficaCircuito) {
        this.graficaCircuito = graficaCircuito;
    }
    /*fin metodo */
    
    
    /* inicio metodo*/
    public CartesianChartModel getGraficaCircuitoGenero() {
        return graficaCircuitoGenero;
    }

    public void setGraficaCircuitoGenero(CartesianChartModel graficaCircuitoGenero) {
        this.graficaCircuitoGenero = graficaCircuitoGenero;
    }
    /*fin metodo */
    
    
     /* inicio metodo*/
    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }
     /*fin metodo */

         
    public CtrlRuralCircuitos() {
        this.lst = new ArrayList<VifRural>();
        this.lstCircuitos = new ArrayList<String>();
    }

    @PostConstruct
    public void graficar() {
        this.graficaCircuito = circuitos(anioSel);
        this.graficaCircuitoGenero=circuitosGenero(anioSel);
    }

    
    
    
    
    
    
    
    /*circuito inicio*/
    private CartesianChartModel circuitos(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lstCircuitos = CircuitoSubcircuitoRural.obtenerCircuitoRural();
            ChartSeries circuitos = new ChartSeries();
            circuitos.setLabel("Circuitos");
            for (int i = 0; i < lstCircuitos.size(); i++) {
                lst = FBVifRural.obtenerDatosDadoAnioCircuito(anio, lstCircuitos.get(i));
                circuitos.set(lstCircuitos.get(i), lst.size());
            }
            model.addSeries(circuitos);

        } catch (Exception e) {
        }
        return model;
    }
      /*circuito inicio*/
    
    
    
    
    /*circuito genero inicio*/
    private CartesianChartModel circuitosGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lstCircuitos = CircuitoSubcircuitoRural.obtenerCircuitoRural();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lstCircuitos.size(); i++) {
                lst = FBVifRural.obtenerDatosDadoAnioCircuitoGenero(anio, lstCircuitos.get(i), "F");
                femenino.set(lstCircuitos.get(i), lst.size());
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lstCircuitos.size(); i++) {
                lst = FBVifRural.obtenerDatosDadoAnioCircuitoGenero(anio, lstCircuitos.get(i), "M");
                masculino.set(lstCircuitos.get(i), lst.size());
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
        }
        return model;
    }
    /*circuito genero fin*/
}
