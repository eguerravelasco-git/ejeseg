/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.unidadesfamilia;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import oscunach.vif.busquedas.FBUnidadFamilia;
import recursos.CircuitoSubcircuitoUrbano;

/**
 *
 * @author Geovanny
 */
@ManagedBean
@RequestScoped
public class CtrlUnidadesFamiliaCircuitos {

    private int anioSel;
    private CartesianChartModel graficoCircuitos;
    private CartesianChartModel graficoCircuitosGenero;

    public CtrlUnidadesFamiliaCircuitos() {
        anioSel=0;
        graficar();
    }
    
    
    @PostConstruct
    public void graficar(){
        this.graficoCircuitos=circuitos(anioSel);
        this.graficoCircuitosGenero=circuitoGenero(anioSel);
    }
    
/*
    Grafico circuitos
    */
    
    private CartesianChartModel circuitos(int anio){
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries circuitos = new ChartSeries();
            circuitos.setLabel("Circuitos");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++ ){
                circuitos.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        FBUnidadFamilia.obtenerDadoCircuito(anio, CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i)).size());
            }
            model.addSeries(circuitos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
    
    private CartesianChartModel circuitoGenero(int anio){
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("MASCULINO");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                masculino.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        FBUnidadFamilia.obtenerDadoCircuitoGenero(anio, CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "MASCULINO").size());
            }
            
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("FEMENINO");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                femenino.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        FBUnidadFamilia.obtenerDadoCircuitoGenero(anio, CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "FEMENINO").size());
            }
            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
                
    }
            
    
    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CartesianChartModel getGraficoCircuitos() {
        return graficoCircuitos;
    }

    public void setGraficoCircuitos(CartesianChartModel graficoCircuitos) {
        this.graficoCircuitos = graficoCircuitos;
    }

    public CartesianChartModel getGraficoCircuitosGenero() {
        return graficoCircuitosGenero;
    }

    public void setGraficoCircuitosGenero(CartesianChartModel graficoCircuitosGenero) {
        this.graficoCircuitosGenero = graficoCircuitosGenero;
    }

}
