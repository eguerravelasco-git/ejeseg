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
public class CtrlRuralSubCircuitos {
    
    private ArrayList<VifRural> lst;
    private ArrayList<String>   lstCircuitos;
    private CartesianChartModel graficaSubCircuito;
    private CartesianChartModel graficaSubCircuitoGenero;
    private int anioSel;

    public ArrayList<VifRural> getLst() {
        return lst;
    }

    public void setLst(ArrayList<VifRural> lst) {
        this.lst = lst;
    }

    public ArrayList<String> getLstCircuitos() {
        return lstCircuitos;
    }

    public void setLstCircuitos(ArrayList<String> lstCircuitos) {
        this.lstCircuitos = lstCircuitos;
    }

    public CartesianChartModel getGraficaSubCircuito() {
        return graficaSubCircuito;
    }

    public void setGraficaSubCircuito(CartesianChartModel graficaSubCircuito) {
        this.graficaSubCircuito = graficaSubCircuito;
    }

    public CartesianChartModel getGraficaSubCircuitoGenero() {
        return graficaSubCircuitoGenero;
    }

    public void setGraficaSubCircuitoGenero(CartesianChartModel graficaSubCircuitoGenero) {
        this.graficaSubCircuitoGenero = graficaSubCircuitoGenero;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CtrlRuralSubCircuitos() {
        this.lst = new ArrayList<VifRural>();
        this.lstCircuitos = new ArrayList<String>();
    }

    @PostConstruct
    public void graficar()
    {
        this.graficaSubCircuito=subCircuitos(anioSel);
        this.graficaSubCircuitoGenero=subCircuitosGenero(anioSel);
    }
    
    
    /*circuito inicio*/
    private CartesianChartModel subCircuitos(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lstCircuitos = CircuitoSubcircuitoRural.obtenerSubcircuitoRural();
            ChartSeries circuitos = new ChartSeries();
            circuitos.setLabel("SubCircuitos");
            for (int i = 0; i < lstCircuitos.size(); i++) {
                lst = FBVifRural.obtenerDatosDadoAnioSubCircuito(anio, lstCircuitos.get(i));
                circuitos.set(lstCircuitos.get(i), lst.size());
            }
            model.addSeries(circuitos);

        } catch (Exception e) {
        }
        return model;
    }
      /*circuito inicio*/
    
    
    
    /*inicio*/
    private CartesianChartModel subCircuitosGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lstCircuitos = CircuitoSubcircuitoRural.obtenerSubcircuitoRural();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lstCircuitos.size(); i++) {
                lst = FBVifRural.obtenerDatosDadoAnioSubCircuitoGenero(anio, lstCircuitos.get(i), "F");
                femenino.set(lstCircuitos.get(i), lst.size());
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lstCircuitos.size(); i++) {
                lst = FBVifRural.obtenerDatosDadoAnioSubCircuitoGenero(anio, lstCircuitos.get(i), "M");
                masculino.set(lstCircuitos.get(i), lst.size());
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
        }
        return model;
    }
    /*fin*/
    
}
