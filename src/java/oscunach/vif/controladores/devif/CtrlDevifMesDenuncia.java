/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.devif;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import oscunach.vif.busquedas.FBDevif;
import oscunach.vif.entidades.Devif;
import recursos.MesesDias;

/**
 *
 * @author Geovanny
 */
@ManagedBean
@RequestScoped
public class CtrlDevifMesDenuncia {

    private ArrayList<String> lst;
    private CartesianChartModel graficaMeses;
    private CartesianChartModel graficaMesesGenero;
    private int anioSel;
    private ArrayList<Devif> lst1;
    private int totalDenuncias;
    private int femeninoTotal;
    private int masculinoTotal;

    public ArrayList<Devif> getLst1() {
        return lst1;
    }

    public void setLst1(ArrayList<Devif> lst1) {
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
    
    public ArrayList<String> getLst() {
        return lst;
    }

    public void setLst(ArrayList<String> lst) {
        this.lst = lst;
    }

    public CartesianChartModel getGraficaMeses() {
        return graficaMeses;
    }

    public void setGraficaMeses(CartesianChartModel graficaMeses) {
        this.graficaMeses = graficaMeses;
    }

    public CartesianChartModel getGraficaMesesGenero() {
        return graficaMesesGenero;
    }

    public void setGraficaMesesGenero(CartesianChartModel graficaMesesGenero) {
        this.graficaMesesGenero = graficaMesesGenero;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CtrlDevifMesDenuncia() {
        this.reinit();
    }
    
    private void reinit() {
        this.lst1 = new ArrayList<Devif>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        graficaMeses = diasAtencion(anioSel);
        graficaMesesGenero = diasAtencionGenero(anioSel);

    }

    private CartesianChartModel diasAtencion(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = MesesDias.obtenerMeses();
            ChartSeries dias = new ChartSeries();
            dias.setLabel("Meses de Denuncia");
            this.lst1 = FBDevif.obtenerDatosDadoAnio(anioSel);
            this.totalDenuncias = lst1.size();
            for (int i = 0; i < lst.size(); i++) {
                dias.set(lst.get(i), FBDevif.obtenerDatosDadoAnioMesDenuncia(anio, lst.get(i)).size());
            }
            model.addSeries(dias);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel diasAtencionGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = MesesDias.obtenerMeses();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            this.lst1 = FBDevif.obtenerDatosDadoAnio(anioSel);
            this.totalDenuncias = lst1.size();
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i), FBDevif.obtenerDatosDadoAnioMesDenunciaGenero(anio, lst.get(i), "F").size());
                femeninoTotal = femeninoTotal + FBDevif.obtenerDatosDadoAnioMesDenunciaGenero(anio, lst.get(i), "F").size();
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i), FBDevif.obtenerDatosDadoAnioMesDenunciaGenero(anio, lst.get(i), "M").size());
                masculinoTotal = masculinoTotal + FBDevif.obtenerDatosDadoAnioMesDenunciaGenero(anio, lst.get(i), "M").size();
            }

            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
