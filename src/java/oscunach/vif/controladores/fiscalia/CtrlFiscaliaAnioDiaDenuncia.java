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
public class CtrlFiscaliaAnioDiaDenuncia {

    private ArrayList<String> lst;
    private int aniosel;
    private CartesianChartModel graficarDiaDenuncia;
    private CartesianChartModel graficarDiaDenunciaGenero;

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
        this.graficar();
    }

    @PostConstruct
    public void graficar(){
     graficarDiaDenuncia= diaDenuncia(aniosel);
     graficarDiaDenunciaGenero=diaDenunciaGenero(aniosel);
     
    }
    
    private CartesianChartModel diaDenuncia(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries dia = new ChartSeries();
            dia.setLabel("dia de denuncia");
            lst = MesesDias.obtenerDias();
            for (int i = 0; i < lst.size(); i++) {
                dia.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioDiaDenuncia(anio, lst.get(i)).size());
            }
            model.addSeries(dia);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel diaDenunciaGenero (int anio){
    CartesianChartModel model = new CartesianChartModel();
        try {
            lst= MesesDias.obtenerDias();
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("Femenino");
            for(int i=0;i<lst.size();i++ ){
                femenino.set(lst.get(i), FBFichaFiscalia.obtenerFichaDadoAnioDiaDenunciaGenero(anio, lst.get(i), "Femenino").size());
            }
            
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("Maculino");
            for(int i=0;i<lst.size(); i++){
            masculino.set(lst.get(i),FBFichaFiscalia.obtenerFichaDadoAnioDiaDenunciaGenero(anio, lst.get(i), "Maculino").size());
            }
            model.addSeries(femenino);
            model.addSeries(masculino);
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
    return model;
    }
    
}
