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
import recursos.MesesDias;

/**
 *
 * @author Geovanny
 */
@ManagedBean
@RequestScoped
public class CtrlRuralDiaAgresion {

    private ArrayList<String> lst;
    private CartesianChartModel graficaDias;
    private CartesianChartModel graficaDiasGenero;
    private int anioSel;

    public ArrayList<String> getLst() {
        return lst;
    }

    public void setLst(ArrayList<String> lst) {
        this.lst = lst;
    }

    public CartesianChartModel getGraficaDias() {
        return graficaDias;
    }

    public void setGraficaDias(CartesianChartModel graficaDias) {
        this.graficaDias = graficaDias;
    }

    public CartesianChartModel getGraficaDiasGenero() {
        return graficaDiasGenero;
    }

    public void setGraficaDiasGenero(CartesianChartModel graficaDiasGenero) {
        this.graficaDiasGenero = graficaDiasGenero;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CtrlRuralDiaAgresion() {
        this.reinit();
    }

    private void reinit() {
        this.lst = new ArrayList<String>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        graficaDias = diasDenuncia(anioSel);
        graficaDiasGenero = diasDenunciaGenero(anioSel);

    }

    private CartesianChartModel diasDenuncia(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries dias = new ChartSeries();
            dias.setLabel("Agresiones por días");
            lst = MesesDias.enlistarDias();
            for (String lst1 : lst) {
                dias.set(lst1, FBVifRural.obtenerDatosDadoAnioMesAgresion(anio, lst1).size());
            }
            model.addSeries(dias);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel diasDenunciaGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = MesesDias.enlistarDias();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (String lst1 : lst) {
                femenino.set(lst1, FBVifRural.obtenerDatosDadoAnioMesAgresionGenero(anio, lst1, "F").size());
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (String lst1 : lst) {
                masculino.set(lst1, FBVifRural.obtenerDatosDadoAnioMesAgresionGenero(anio, lst1, "M").size());
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
