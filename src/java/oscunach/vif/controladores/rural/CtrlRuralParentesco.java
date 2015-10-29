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
public class CtrlRuralParentesco {

    private CartesianChartModel graficaParentesco;
    private CartesianChartModel graficaParentescoGenero;
    private int anioSel;
    private ArrayList<VifRural> lst;

    public CartesianChartModel getGraficaParentesco() {
        return graficaParentesco;
    }

    public void setGraficaParentesco(CartesianChartModel graficaParentesco) {
        this.graficaParentesco = graficaParentesco;
    }

    public CartesianChartModel getGraficaParentescoGenero() {
        return graficaParentescoGenero;
    }

    public void setGraficaParentescoGenero(CartesianChartModel graficaParentescoGenero) {
        this.graficaParentescoGenero = graficaParentescoGenero;
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
    
    
    
    public CtrlRuralParentesco() {
        this.reinit();
    }
    
    private void reinit() {
        this.lst=new ArrayList<VifRural>();
        this.graficar();
    }
    @PostConstruct
    public void graficar() {
        this.graficaParentesco=parentesco(anioSel);
        this.graficaParentescoGenero=parentescoGenero(anioSel);

    }
    
     private CartesianChartModel parentesco(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = FBVifRural.obtenerDatosParentescoDadoAnio(anio);
            ChartSeries parentesco = new ChartSeries();
            parentesco.setLabel("Parentesco");
            for (int i = 0; i < lst.size(); i++) {
                parentesco.set(lst.get(i).getParentesco(), FBVifRural.obtenerDatosDadoAnioParentesco(anio, lst.get(i).getParentesco()).size());
            }
            model.addSeries(parentesco);
        } catch (Exception e) {
        }
        return model;

    }

    private CartesianChartModel parentescoGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = FBVifRural.obtenerDatosParentescoDadoAnio(anio);
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i).getParentesco(), FBVifRural.obtenerDatosDadoAnioParentescoGenero(anio, lst.get(i).getParentesco(), "F").size());
            }
            
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i).getParentesco(), FBVifRural.obtenerDatosDadoAnioParentescoGenero(anio, lst.get(i).getParentesco(), "M").size());
            }
            
            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
        }
        return model;

    }
}
