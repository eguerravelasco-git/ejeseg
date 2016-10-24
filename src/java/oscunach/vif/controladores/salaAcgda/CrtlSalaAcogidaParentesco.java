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
 * @author oscunach
 */
@ManagedBean
@RequestScoped
public class CrtlSalaAcogidaParentesco {

    /**
     * Creates a new instance of CrtlSalaAcogidaParentesco
     */
    private ArrayList<SalaAcgda> lst;
    private int anioSel;
    private CartesianChartModel graficaParentesco;
    private CartesianChartModel graficaParentescoGenero;
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
    
    

    public CartesianChartModel getGraficaParentesco() {
        return graficaParentesco;
    }

//    public CartesianChartModel getGraficaGraficaParentescoGenero() {
//        return graficaParentescoGenero;
//    }

    public void setGraficaParentesco(CartesianChartModel graficaParentesco) {
        this.graficaParentesco = graficaParentesco;
    }

    public CartesianChartModel getGraficaParentescoGenero() {
        return graficaParentescoGenero;
    }

    public void setGraficaParentescoGenero(CartesianChartModel graficaParentescoGenero) {
        this.graficaParentescoGenero = graficaParentescoGenero;
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

    public CrtlSalaAcogidaParentesco() {
        this.lst = new ArrayList<SalaAcgda>();
        this.lst1 = new ArrayList<SalaAcgda>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        graficaParentesco = parentesco(anioSel);
        graficaParentescoGenero = parentescoGenero(anioSel);

    }

    private CartesianChartModel parentesco(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries parentesco = new ChartSeries();
            parentesco.setLabel("Parentesco");
            lst = FBSalaAcgda.obteneranioParentesco(anio);
            this.lst1 = FBSalaAcgda.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst1.size();
            for (int i = 0; i < lst1.size(); i++) {
                parentesco.set(lst1.get(i).getParentesco(), FBSalaAcgda.obtenerDatosDadoAnioParentesco(anio, lst1.get(i).getParentesco()).size());
            }
            model.addSeries(parentesco);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
    
    private CartesianChartModel parentescoGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = FBSalaAcgda.obteneranioParentesco(anio);
            this.lst1 = FBSalaAcgda.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst1.size();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i), FBSalaAcgda.obtenerDatosDadoAnioParentescoGenero(anio, lst.get(i).getParentesco(), "F").size());
                femeninoTotal= femeninoTotal+FBSalaAcgda.obtenerDatosDadoAnioSubcircuitoGenero(anio, lst.get(i).getParentesco(), "F").size();
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i), FBSalaAcgda.obtenerDatosDadoAnioParentescoGenero(anio, lst.get(i).getParentesco(), "M").size());
                masculinoTotal=masculinoTotal+FBSalaAcgda.obtenerDatosDadoAnioParentescoGenero(anio, lst.get(i).getParentesco(), "M").size();
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
}
