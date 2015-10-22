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
import oscunach.vif.entidades.SalaAcgda;

/**
 *
 * @author Oscunach
 */
@ManagedBean
@RequestScoped
public class CtrlEstadoCivilSalaAcgda {

    /**
     * Creates a new instance of CtrlEstadoCivilSalaAcgda
     */
    private ArrayList<SalaAcgda> lst;
    private int anioSel;
    private CartesianChartModel graficaEstadoCivil;
    private CartesianChartModel graficaEstadoCivilGenero;

    public ArrayList<SalaAcgda> getLst() {
        return lst;
    }

    public void setLst(ArrayList<SalaAcgda> lst) {
        this.lst = lst;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
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

    public CtrlEstadoCivilSalaAcgda() {
        this.reinit();
    }

    private void reinit() {
        this.lst = new ArrayList<SalaAcgda>();
        this.graficar();

    }

    @PostConstruct
    public void graficar() {
        graficaEstadoCivil=estadoCivil(anioSel);
        graficaEstadoCivilGenero=estadoCivilGenero(anioSel);

    }

    private CartesianChartModel estadoCivil(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries estadoCivil = new ChartSeries();
            estadoCivil.setLabel("Estado Civil");
            lst = FBSalaAcgda.obtenerEstadosCiviles(anio);
            for (int i = 0; i < lst.size(); i++) {
                estadoCivil.set(lst.get(i).getEstado_civil_victima(), FBSalaAcgda.obtenerDatosDadoAnioEstadoCivil(anio, lst.get(i).getEstado_civil_victima()).size());
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
            lst = FBSalaAcgda.obtenerEstadosCiviles(anio);
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i).getEstado_civil_victima(), FBSalaAcgda.obtenerDatosDadoAnioEstadoCivilGenero(anio, lst.get(i).getEstado_civil_victima(), "F").size());
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i).getEstado_civil_victima(), FBSalaAcgda.obtenerDatosDadoAnioEstadoCivilGenero(anio, lst.get(i).getEstado_civil_victima(), "M").size());
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
    
    
    
    
}
