/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.urbano;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import oscunach.vif.busquedas.FBReincidencias;
import oscunach.vif.entidades.Reincidencias;

/**
 *
 * @author Geovanny
 */
@ManagedBean
@RequestScoped
public class CtrlReincidencias implements Serializable{

    private ArrayList<Reincidencias> lst;
    private CartesianChartModel graficaReincidencias;
    private CartesianChartModel graficaReincidenciasGenero;
    private int anioSel;

    public ArrayList<Reincidencias> getLst() {
        return lst;
    }

    public void setLst(ArrayList<Reincidencias> lst) {
        this.lst = lst;
    }

    public CartesianChartModel getGraficaReincidencias() {
        return graficaReincidencias;
    }

    public void setGraficaReincidencias(CartesianChartModel graficaReincidencias) {
        this.graficaReincidencias = graficaReincidencias;
    }

    public CartesianChartModel getGraficaReincidenciasGenero() {
        return graficaReincidenciasGenero;
    }

    public void setGraficaReincidenciasGenero(CartesianChartModel graficaReincidenciasGenero) {
        this.graficaReincidenciasGenero = graficaReincidenciasGenero;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CtrlReincidencias() {
        this.reinit();
    }

    private void reinit() {
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        this.graficaReincidencias = reincidencias(anioSel);
        this.graficaReincidenciasGenero = reincidenciasGenero(anioSel);

    }

    private CartesianChartModel reincidencias(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries reincidencias = new ChartSeries();
            reincidencias.setLabel("Reincidencias");

            if (anio == 2010) {
                lst = FBReincidencias.obtenerDatos2010();
                for (int i = 0; i < lst.size(); i++) {
                    reincidencias.set(lst.get(i).getReincidencia(), FBReincidencias.obtenerDatosDadoReincidencias2010(lst.get(i).getReincidencia()).size());
                }
            }
            if (anio == 2011) {
                lst = FBReincidencias.obtenerDatos2011();
                for (int i = 0; i < lst.size(); i++) {
                    reincidencias.set(lst.get(i).getReincidencia(), FBReincidencias.obtenerDatosDadoReincidencias2011(lst.get(i).getReincidencia()).size());
                }

            }
            if (anio == 2012) {
                lst = FBReincidencias.obtenerDatos2012();
                for (int i = 0; i < lst.size(); i++) {
                    reincidencias.set(lst.get(i).getReincidencia(), FBReincidencias.obtenerDatosDadoReincidencias2012(lst.get(i).getReincidencia()).size());
                }

            }
            model.addSeries(reincidencias);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel reincidenciasGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");

            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");

            if (anio == 2010) {
                lst = FBReincidencias.obtenerDatos2010();
                for (int i = 0; i < lst.size(); i++) {
                    femenino.set(lst.get(i).getReincidencia(), FBReincidencias.ObtenerDatosDadoReincidenciasSexo2010(lst.get(i).getReincidencia(), "F").size());
                }
                
                for (int i = 0; i < lst.size(); i++) {
                    masculino.set(lst.get(i).getReincidencia(), FBReincidencias.ObtenerDatosDadoReincidenciasSexo2010(lst.get(i).getReincidencia(), "M").size());
                }
            }
            
            if (anio == 2011) {
                lst = FBReincidencias.obtenerDatos2011();
                for (int i = 0; i < lst.size(); i++) {
                    femenino.set(lst.get(i).getReincidencia(), FBReincidencias.ObtenerDatosDadoReincidenciasSexo2011(lst.get(i).getReincidencia(), "F").size());
                }
                
                for (int i = 0; i < lst.size(); i++) {
                    masculino.set(lst.get(i).getReincidencia(), FBReincidencias.ObtenerDatosDadoReincidenciasSexo2011(lst.get(i).getReincidencia(), "M").size());
                }
            }
            
            if (anio == 2012) {
                lst = FBReincidencias.obtenerDatos2012();
                for (int i = 0; i < lst.size(); i++) {
                    femenino.set(lst.get(i).getReincidencia(), FBReincidencias.ObtenerDatosDadoReincidenciasSexo2012(lst.get(i).getReincidencia(), "F").size());
                }
                
                for (int i = 0; i < lst.size(); i++) {
                    masculino.set(lst.get(i).getReincidencia(), FBReincidencias.ObtenerDatosDadoReincidenciasSexo2012(lst.get(i).getReincidencia(), "M").size());
                }
            }

            model.addSeries(femenino);
            model.addSeries(masculino);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
