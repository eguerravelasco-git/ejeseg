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
import recursos.Ocupaciones;

/**
 *
 * @author Oscunach
 */
@ManagedBean
@RequestScoped
public class CrtlSalaAcigidaOcupacion {

    /**
     * Creates a new instance of CrtlSalaAcigidaOcupacion
     */
    //private ArrayList<SalaAcgda> lst;
    private ArrayList<String> lst;
    private CartesianChartModel graficaOcupacion;
    private CartesianChartModel graficaOcupacionGenero;
    private int anioSel;
    private ArrayList<SalaAcgda> lst1;
    private int totalDenuncias;
    private int femeninoTotal;
    private int masculinoTotal;

    public ArrayList<String> getLst() {
        return lst;
    }

    public void setLst(ArrayList<String> lst) {
        this.lst = lst;
    }

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

    public CartesianChartModel getGraficaOcupacion() {
        return graficaOcupacion;
    }

    public void setGraficaOcupacion(CartesianChartModel graficaOcupacion) {
        this.graficaOcupacion = graficaOcupacion;
    }

    public CartesianChartModel getGraficaOcupacionGenero() {
        return graficaOcupacionGenero;
    }

    public void setGraficaOcupacionGenero(CartesianChartModel graficaOcupacionGenero) {
        this.graficaOcupacionGenero = graficaOcupacionGenero;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CrtlSalaAcigidaOcupacion() {
        this.lst = new ArrayList<String>();
        this.lst1 = new ArrayList<SalaAcgda>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        graficaOcupacion = ocupacion(anioSel);
        graficaOcupacionGenero = OcupacionGenero(anioSel);
    }

    private CartesianChartModel ocupacion(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries ocupacion = new ChartSeries();
            ocupacion.setLabel("OCUPACION");
            //lst = FBSalaAcgda.obteneranioocupacion(anio);
            lst = Ocupaciones.enlistarOcupaciones();
            this.lst1 = FBSalaAcgda.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst1.size();
            for (int i = 0; i < lst.size(); i++) {
                ocupacion.set(lst.get(i), FBSalaAcgda.obtenerDatosDadoAnioOcupacionvictima(anio, lst.get(i)).size());

            }
            model.addSeries(ocupacion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel OcupacionGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            //lst = FBSalaAcgda.obteneranioocupacion(anio);
            lst = Ocupaciones.enlistarOcupaciones();
            this.lst1 = FBSalaAcgda.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst1.size();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");

            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i), FBSalaAcgda.obtenerDatosDadoAnioOcupacionGenero(anio, lst.get(i), "F").size());
                femeninoTotal = femeninoTotal + FBSalaAcgda.obtenerDatosDadoAnioOcupacionGenero(anio, lst.get(i), "F").size();
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i), FBSalaAcgda.obtenerDatosDadoAnioOcupacionGenero(anio, lst.get(i), "M").size());
                masculinoTotal = masculinoTotal + FBSalaAcgda.obtenerDatosDadoAnioOcupacionGenero(anio, lst.get(i), "M").size();
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
