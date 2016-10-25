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
    private ArrayList<FichaVif> lst2;
    private int totalDenuncias;
    private int femeninoTotal;
    private int masculinoTotal;

    public ArrayList<FichaVif> getLst2() {
        return lst2;
    }

    public void setLst2(ArrayList<FichaVif> lst2) {
        this.lst2 = lst2;
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
        this.lst2 = new ArrayList<FichaVif>();
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
            this.lst2 = FBFichaFiscalia.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst2.size();
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
            this.lst2 = FBFichaFiscalia.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst2.size();
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst1.size(); i++) {
                masculino.set(lst1.get(i), FBFichaFiscalia.obtenerFichaDadoAnioOcupacionGenero(anio, lst1.get(i), "Masculino").size());
                masculinoTotal=masculinoTotal+FBFichaFiscalia.obtenerFichaDadoAnioOcupacionGenero(anio, lst1.get(i), "Masculino").size();
            }
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst1.size(); i++) {
                femenino.set(lst1.get(i), FBFichaFiscalia.obtenerFichaDadoAnioOcupacionGenero(anio, lst1.get(i), "Femenino").size());
                femeninoTotal= femeninoTotal+FBFichaFiscalia.obtenerFichaDadoAnioOcupacionGenero(anio, lst1.get(i), "Femenino").size();
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
}
