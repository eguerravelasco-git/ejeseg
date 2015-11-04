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
public class CtrlRuralDiasDenuncia {

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

    public CtrlRuralDiasDenuncia() {
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
            dias.setLabel("Dias de Denuncia");
            lst = MesesDias.obtenerDias();
            for (int i = 0; i < lst.size(); i++) {
                dias.set(lst.get(i), FBVifRural.obtenerDatosDadoAnioDiaDenuncia(anio, lst.get(i)).size());
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
            lst = MesesDias.obtenerDias();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i), FBVifRural.obtenerDatosDadoAnioDiaDenunciaGenero(anio, lst.get(i), "F").size());
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i), FBVifRural.obtenerDatosDadoAnioDiaDenunciaGenero(anio, lst.get(i), "M").size());
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
