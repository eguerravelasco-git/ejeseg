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
import recursos.MesesDias;

/**
 *
 * @author ICITS SALA5
 */
@ManagedBean
@RequestScoped
public class CtrlFiscaliaAnioMesAgrecion {

    private ArrayList<String> lts;
    private int aniosel;
    private CartesianChartModel graficarMes;
    private CartesianChartModel graficarMesGenero;
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

    public ArrayList<String> getLts() {
        return lts;
    }

    public void setLts(ArrayList<String> lts) {
        this.lts = lts;
    }

    public int getAniosel() {
        return aniosel;
    }

    public void setAniosel(int aniosel) {
        this.aniosel = aniosel;
    }

    public CartesianChartModel getGraficarMes() {
        return graficarMes;
    }

    public void setGraficarMes(CartesianChartModel graficarMes) {
        this.graficarMes = graficarMes;
    }

    public CartesianChartModel getGraficarMesGenero() {
        return graficarMesGenero;
    }

    public void setGraficarMesGenero(CartesianChartModel graficarMesGenero) {
        this.graficarMesGenero = graficarMesGenero;
    }

    public CtrlFiscaliaAnioMesAgrecion() {
        this.lst2 = new ArrayList<FichaVif>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        graficarMes = mesAgrecion(aniosel);
        graficarMesGenero = mesAgrecionGenero(aniosel);
    }

    private CartesianChartModel mesAgrecion(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lts = MesesDias.obtenerMeses();
            this.lst2 = FBFichaFiscalia.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst2.size();
            ChartSeries mes = new ChartSeries();
            mes.setLabel("Mes Agrecion");
            for (int i = 0; i < lts.size(); i++) {

                mes.set(lts.get(i), FBFichaFiscalia.obtenerFichaDadoAnioMesAgresion(anio, lts.get(i)).size());
            }
            model.addSeries(mes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return model;

    }

    private CartesianChartModel mesAgrecionGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lts = MesesDias.obtenerMeses();
            this.lst2 = FBFichaFiscalia.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst2.size();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lts.size(); i++) {
                femenino.set(lts.get(i), FBFichaFiscalia.obtenerFichaDadoAnioMesAgresionGenero(anio, lts.get(i), "Femenino").size());
                femeninoTotal= femeninoTotal+FBFichaFiscalia.obtenerFichaDadoAnioMesAgresionGenero(anio, lts.get(i), "Femenino").size();
            }
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lts.size(); i++) {
                masculino.set(lts.get(i), FBFichaFiscalia.obtenerFichaDadoAnioMesAgresionGenero(anio, lts.get(i), "Maculino").size());
                masculinoTotal=masculinoTotal+FBFichaFiscalia.obtenerFichaDadoAnioMesAgresionGenero(anio, lts.get(i), "Maculino").size();
            }
            model.addSeries(femenino);
            model.addSeries(masculino);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;

    }

}
