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
public class CtrlFiscaliaAnioDiaDenuncia {

    private ArrayList<String> lst;
    private int aniosel;
    private CartesianChartModel graficarDiaDenuncia;
    private CartesianChartModel graficarDiaDenunciaGenero;
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

    public CartesianChartModel getGraficarDiaDenuncia() {
        return graficarDiaDenuncia;
    }

    public void setGraficarDiaDenuncia(CartesianChartModel graficarDiaDenuncia) {
        this.graficarDiaDenuncia = graficarDiaDenuncia;
    }

    public CartesianChartModel getGraficarDiaDenunciaGenero() {
        return graficarDiaDenunciaGenero;
    }

    public void setGraficarDiaDenunciaGenero(CartesianChartModel graficarDiaDenunciaGenero) {
        this.graficarDiaDenunciaGenero = graficarDiaDenunciaGenero;
    }

    public CtrlFiscaliaAnioDiaDenuncia() {
        this.lst2 = new ArrayList<FichaVif>();
        this.graficar();
    }

    @PostConstruct
    public void graficar() {
        graficarDiaDenuncia = diaDenuncia(aniosel);
        graficarDiaDenunciaGenero = diaDenunciaGenero(aniosel);

    }

    private CartesianChartModel diaDenuncia(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries dia = new ChartSeries();
            dia.setLabel("dia de denuncia");
            lst = MesesDias.obtenerDias();
            this.lst2 = FBFichaFiscalia.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst2.size();
            for (int i = 0; i < lst.size(); i++) {
                dia.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioDiaDenuncia(anio, lst.get(i)).size());
            }
            model.addSeries(dia);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel diaDenunciaGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = MesesDias.obtenerDias();
            this.lst2 = FBFichaFiscalia.obtenerDatosDadoAnio(anio);
            this.totalDenuncias = lst2.size();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioDiaDenunciaGenero(anio, lst.get(i), "Femenino").size());
                femeninoTotal = femeninoTotal + FBFichaFiscalia.obtenerFichaDadoAnioDiaDenunciaGenero(anio, lst.get(i), "Femenino").size();
            }

            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Maculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioDiaDenunciaGenero(anio, lst.get(i), "Maculino").size());
                masculinoTotal = masculinoTotal + FBFichaFiscalia.obtenerFichaDadoAnioDiaDenunciaGenero(anio, lst.get(i), "Maculino").size();
            }
            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

}
