/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.urbano;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import oscunach.vif.busquedas.FBVifUrbano;
import oscunach.vif.entidades.VifUrbano;

/**
 *
 * @author servidor
 */
@ManagedBean
@RequestScoped
public class CtrlUrbanoEstadoCivil {

    /**
     * Creates a new instance of CtrlUrbanoEstadoCivil
     */
    private CartesianChartModel graficaEstadoCivil;
    private CartesianChartModel graficaEstadoCivilGenero;
    private int anioSel;
    private ArrayList<VifUrbano> lst;

    public ArrayList<VifUrbano> getLst() {
        return lst;
    }

    public void setLst(ArrayList<VifUrbano> lst) {
        this.lst = lst;
    }

    public CartesianChartModel getGraficaEstadoCivil() {
        return graficaEstadoCivil;
    }

    public void setGraficaEstadoCivil(CartesianChartModel graficaEstadoCivil) {
        this.graficaEstadoCivil = graficaEstadoCivil;
    }

    public CartesianChartModel getGraficaEstadoCivilGenero() {
        return graficaEstadoCivilGenero;
    }

    public void setGraficaEstadoCivilGenero(CartesianChartModel graficaEstadoCivilGenero) {
        this.graficaEstadoCivilGenero = graficaEstadoCivilGenero;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CtrlUrbanoEstadoCivil() {
        this.reinit();
    }

    private void reinit() {
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        this.graficaEstadoCivil=estadoCivil(anioSel);
        this.graficaEstadoCivilGenero=estadoCivilGenero(anioSel);

    }

    private CartesianChartModel estadoCivil(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = FBVifUrbano.obtenerDatosEstadoCivilDadoAnio(anio);
            ChartSeries estadoCivil = new ChartSeries();
            estadoCivil.setLabel("Estado Civil");
            
            for (int i = 0; i < lst.size(); i++) {
                estadoCivil.set(lst.get(i).getEstado_civil_victima(), FBVifUrbano.obtenerDatosDadoAnioEstadoCivil(anio, lst.get(i).getEstado_civil_victima()).size());
            }
            model.addSeries(estadoCivil);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel estadoCivilGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = FBVifUrbano.obtenerDatosEstadoCivilDadoAnio(anio);
            
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
             for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i).getEstado_civil_victima(), FBVifUrbano.obtenerDatosDadoAnioEstadoCivilGenero(anio, lst.get(i).getEstado_civil_victima(),"F").size());
            }
            
            
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            
             for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i).getEstado_civil_victima(), FBVifUrbano.obtenerDatosDadoAnioEstadoCivilGenero(anio, lst.get(i).getEstado_civil_victima(),"M").size());
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
