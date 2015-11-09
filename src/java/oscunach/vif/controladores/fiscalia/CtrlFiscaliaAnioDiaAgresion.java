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
import recursos.MesesDias;

/**
 *
 * @author ICITS SALA5
 */
@ManagedBean
@RequestScoped
public class CtrlFiscaliaAnioDiaAgresion {

    private ArrayList<String> lst;
    private int aniosel;
    private CartesianChartModel graficarDiaAgrecion;
    private CartesianChartModel graficarDiaAgrecionGenero;

    public ArrayList<String> getLst() {
        return lst;
    }

    public void setLst(ArrayList<String> lst) {
        this.lst = lst;
    }

    public int getAniosel() {
        return aniosel;
    }

    public void setAniosel(int aniosel) {
        this.aniosel = aniosel;
    }

    public CartesianChartModel getGraficarDiaAgrecion() {
        return graficarDiaAgrecion;
    }

    public void setGraficarDiaAgrecion(CartesianChartModel graficarDiaAgrecion) {
        this.graficarDiaAgrecion = graficarDiaAgrecion;
    }

    public CartesianChartModel getGraficarDiaAgrecionGenero() {
        return graficarDiaAgrecionGenero;
    }

    public void setGraficarDiaAgrecionGenero(CartesianChartModel graficarDiaAgrecionGenero) {
        this.graficarDiaAgrecionGenero = graficarDiaAgrecionGenero;
    }

    public CtrlFiscaliaAnioDiaAgresion() {

        this.reinit();
    }

    private void reinit() {
        this.lst = new ArrayList<String>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        graficarDiaAgrecion = diaAgresion2(aniosel);
        graficarDiaAgrecionGenero = diaAgrecionGenero(aniosel);
    }

    private CartesianChartModel diaAgresion(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = MesesDias.obtenerDias();
            ChartSeries dias = new ChartSeries();
            dias.setLabel("Dia de Agresion");
            for (int i = 0; i < lst.size(); i++) {
                dias.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioDiaAgrecion(anio, lst.get(i)).size());
                System.out.println("dia: " + lst.get(i) + " Dimensión: " + FBFichaFiscalia.obtenerFichaDadoAnioDiaAgrecion(anio, lst.get(i)).size());
            }
            model.addSeries(dias);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    
    private CartesianChartModel diaAgresion2(int anio){
        CartesianChartModel grafico = new CartesianChartModel();
        try {
            lst=MesesDias.obtenerDias();
            ChartSeries t=new ChartSeries();
            t.setLabel("Dias de agresión");
            for (int i=0;i<lst.size();i++){
                t.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioDiaAgrecion(anio, lst.get(i)).size());
                System.out.println("dia: "+lst.get(i)+" dimensión: "+ FBFichaFiscalia.obtenerFichaDadoAnioDiaAgrecion(anio, lst.get(i)).size());
            }
            grafico.addSeries(t);
        } catch (Exception e) {
        }
        return  grafico;
    }
    private CartesianChartModel diaAgrecionGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = MesesDias.obtenerDias();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioDiaAgrecionGenero(anio, lst.get(i), "Femenino").size());
            }
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioDiaAgrecionGenero(anio, lst.get(i), "Masculino").size());
            }
            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
        }
        return model;
    }

}
