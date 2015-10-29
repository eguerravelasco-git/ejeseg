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
import oscunach.vif.busquedas.FBVifUrbano;
import oscunach.vif.entidades.VifRural;
import oscunach.vif.entidades.VifUrbano;

/**
 *
 * @author oscunach
 */
@ManagedBean
@RequestScoped
public class CtrlRuralEstadoCivil {

    private CartesianChartModel graficaEstadoCivil;
    private CartesianChartModel graficaEstadoCivilGenero;
    private int anioSel;
    private ArrayList<VifRural> lst;

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

    public ArrayList<VifRural> getLst() {
        return lst;
    }

    public void setLst(ArrayList<VifRural> lst) {
        this.lst = lst;
    }

    public CtrlRuralEstadoCivil() {
        this.reinit();

    }

    private void reinit() {
        this.lst=new ArrayList<VifRural>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        this.graficaEstadoCivil = estadoCivil(anioSel);
        this.graficaEstadoCivilGenero = estadoCivilGenero(anioSel);
    }

    private CartesianChartModel estadoCivil(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = FBVifRural.obtenerDatosDadoEstadoCivilVictimaDadoAnio(anio);
            ChartSeries estadoCivil = new ChartSeries();
            estadoCivil.setLabel("Estado Civil");

            for (int i = 0; i < lst.size(); i++) {
                estadoCivil.set(lst.get(i).getEstado_civil_victima(), FBVifRural.obtenerDatosDadoAnioEstadoCivil(anio, lst.get(i).getEstado_civil_victima()).size());
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
            lst = FBVifRural.obtenerDatosDadoEstadoCivilVictimaDadoAnio(anio);

            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i).getEstado_civil_victima(), FBVifRural.obtenerDatosDadoAnioEstadoCivilGenero(anio, lst.get(i).getEstado_civil_victima(), "F").size());
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");

            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i).getEstado_civil_victima(), FBVifRural.obtenerDatosDadoAnioEstadoCivilGenero(anio, lst.get(i).getEstado_civil_victima(), "M").size());
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
