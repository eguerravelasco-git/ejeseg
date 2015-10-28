/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.urbano;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import oscunach.vif.busquedas.FBVifUrbano;

/**
 *
 * @author servidor
 */
@ManagedBean
@RequestScoped
public class CtrlContrastesGeneral {

    private CartesianChartModel graficaContraste;
    private CartesianChartModel graficaContrasteGenero;

    public CartesianChartModel getGraficaContraste() {
        return graficaContraste;
    }

    public void setGraficaContraste(CartesianChartModel graficaContraste) {
        this.graficaContraste = graficaContraste;
    }

    public CartesianChartModel getGraficaContrasteGenero() {
        return graficaContrasteGenero;
    }

    public void setGraficaContrasteGenero(CartesianChartModel graficaContrasteGenero) {
        this.graficaContrasteGenero = graficaContrasteGenero;
    }

    public CtrlContrastesGeneral() {
        this.graficar();

    }

    @PostConstruct
    public void graficar() {
        this.graficaContraste = contrasteGeneral();
    }

    public CartesianChartModel contrasteGeneral() {
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries contraste = new ChartSeries();
            contraste.set(2010, FBVifUrbano.obtenerDatosDadoAnio(2010).size());
            contraste.set(2011, FBVifUrbano.obtenerDatosDadoAnio(2011).size());
            contraste.set(2012, FBVifUrbano.obtenerDatosDadoAnio(2012).size());
            model.addSeries(contraste);
        } catch (Exception e) {
        }
        return model;

    }
}
