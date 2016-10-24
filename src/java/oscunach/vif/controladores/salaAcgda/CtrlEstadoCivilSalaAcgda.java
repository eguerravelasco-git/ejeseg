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
    private ArrayList<SalaAcgda> lst1;
    private int totalDenuncias;
    private int femeninoTotal;
    private int masculinoTotal;

    public ArrayList<SalaAcgda> getLst1() {
        return lst1;
    }

    public void setLst1(ArrayList<SalaAcgda> lst1) {
        this.lst1 = lst1;
    }

    public int getTotalDenuncias() {
        return totalDenuncias;
    }

    public void setTotalDenuncias(int totalDenuncias) {
        this.totalDenuncias = totalDenuncias;
    }

    public int getFemeninoTotal() {
        return femeninoTotal;
    }

    public void setFemeninoTotal(int femeninoTotal) {
        this.femeninoTotal = femeninoTotal;
    }

    public int getMasculinoTotal() {
        return masculinoTotal;
    }

    public void setMasculinoTotal(int masculinoTotal) {
        this.masculinoTotal = masculinoTotal;
    }
    
    

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
        this.lst1 = new ArrayList<SalaAcgda>();
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
            this.lst1 = FBSalaAcgda.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst1.size();
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
            this.lst1 = FBSalaAcgda.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst1.size();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i).getEstado_civil_victima(), FBSalaAcgda.obtenerDatosDadoAnioEstadoCivilGenero(anio, lst.get(i).getEstado_civil_victima(), "F").size());
                femeninoTotal= femeninoTotal+FBSalaAcgda.obtenerDatosDadoAnioEstadoCivilGenero(anio, lst.get(i).getEstado_civil_victima(), "F").size();
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i).getEstado_civil_victima(), FBSalaAcgda.obtenerDatosDadoAnioEstadoCivilGenero(anio, lst.get(i).getEstado_civil_victima(), "M").size());
                masculinoTotal=masculinoTotal+FBSalaAcgda.obtenerDatosDadoAnioEstadoCivilGenero(anio, lst.get(i).getEstado_civil_victima(), "M").size();
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
    
    
    
    
}
