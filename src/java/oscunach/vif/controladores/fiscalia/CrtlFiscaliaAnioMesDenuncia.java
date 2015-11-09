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
public class CrtlFiscaliaAnioMesDenuncia {
   private ArrayList<String>lst;
    private int aniosel;
   private CartesianChartModel graficarMesDenuncia;
   private CartesianChartModel graficarMesDenunciaGenero;

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

    public CartesianChartModel getGraficarMesDenuncia() {
        return graficarMesDenuncia;
    }

    public void setGraficarMesDenuncia(CartesianChartModel graficarMesDenuncia) {
        this.graficarMesDenuncia = graficarMesDenuncia;
    }

    public CartesianChartModel getGraficarMesDenunciaGenero() {
        return graficarMesDenunciaGenero;
    }

    public void setGraficarMesDenunciaGenero(CartesianChartModel graficarMesDenunciaGenero) {
        this.graficarMesDenunciaGenero = graficarMesDenunciaGenero;
    }   
     
    public CrtlFiscaliaAnioMesDenuncia() {
        this.graficar();
    }
    
   @PostConstruct
    public void graficar(){
        graficarMesDenuncia=mesDenuncia(aniosel);
        graficarMesDenunciaGenero=mesDenunciaGenero(aniosel);
    }

    
    private CartesianChartModel mesDenuncia(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst = MesesDias.obtenerMeses();
            ChartSeries mes = new ChartSeries();
            mes.setLabel("Denuncia");
            for (int i = 0; i < lst.size(); i++) {

                mes.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioMesDenuncia(anio, lst.get(i)).size());
            }
            model.addSeries(mes);
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }

        return model;

    }

    private CartesianChartModel mesDenunciaGenero(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lst =MesesDias.obtenerMeses();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for (int i = 0; i < lst.size(); i++) {
                femenino.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioMesAgresionGenero(anio, lst.get(i), "Femenino").size());
            }
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Masculino");
            for (int i = 0; i < lst.size(); i++) {
                masculino.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioMesDenunciaGenero(anio, lst.get(i), "Maculino").size());
            }
            model.addSeries(femenino);
            model.addSeries(masculino);

        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
        return model;

    }
}
