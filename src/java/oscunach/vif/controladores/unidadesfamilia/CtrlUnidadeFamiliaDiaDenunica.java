/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.unidadesfamilia;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import oscunach.vif.busquedas.FBUnidadFamilia;
import recursos.MesesDias;

/**
 *
 * @author Pc-03
 */
@ManagedBean
@RequestScoped
public class CtrlUnidadeFamiliaDiaDenunica {

    private int anioSel;
    private CartesianChartModel graficarDiaDenuncia;
    private CartesianChartModel graficarDiaDenunciaGenero;

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
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

    public CtrlUnidadeFamiliaDiaDenunica() {
        graficar();
    }

     @PostConstruct
     public void graficar(){
     this.graficarDiaDenuncia=diaDenuncia(anioSel);
     this.graficarDiaDenunciaGenero=diaDenunciaGenero(anioSel);

      }
    
    
    private CartesianChartModel diaDenuncia (int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
              ChartSeries diaDenuncia = new ChartSeries();
            diaDenuncia.setLabel("diaDenuncia");
            for(int i=0;i< MesesDias.obtenerDias().size();i++){
            diaDenuncia.set(MesesDias.obtenerDias().get(i), FBUnidadFamilia.obtenerDadoDiaDenuncia(anio, MesesDias.obtenerDias().get(i)).size());
            }
            model.addSeries(diaDenuncia);
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
    
    return model;
    }
    
    private CartesianChartModel diaDenunciaGenero(int anio ){
    CartesianChartModel model = new CartesianChartModel();
     
        try {
            ChartSeries masculino= new ChartSeries();
            masculino.setLabel("MASCULINO");
           for(int i=0;i< MesesDias.obtenerDias().size();i++){
            masculino.set(MesesDias.obtenerDias().get(i), FBUnidadFamilia.obtenerDadoDiaDenunciaGenero(anio, MesesDias.obtenerDias().get(i), "MASCULINO").size());
            }
            
            ChartSeries femenino= new ChartSeries();
            femenino.setLabel("femenino");
           for(int i=0;i< MesesDias.obtenerDias().size();i++){
            femenino.set(MesesDias.obtenerDias().get(i), FBUnidadFamilia.obtenerDadoDiaDenunciaGenero(anio, MesesDias.obtenerDias().get(i), "FEMENINO").size());
            }
            model.addSeries(masculino);
            model.addSeries(femenino);
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
    return  model;
     
    }
    
    
}
