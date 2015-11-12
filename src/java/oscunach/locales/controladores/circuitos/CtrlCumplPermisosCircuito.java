/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.locales.controladores.circuitos;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import oscunach.locales.busquedas.BusquedasLocalesCircuitos;
import recursos.CircuitoSubcircuitoUrbano;

/**
 *
 * @author servidor
 */
@ManagedBean
@RequestScoped
public class CtrlCumplPermisosCircuito {

    private CartesianChartModel permisoMunicipal;
    private CartesianChartModel permisoBomberos;
    private CartesianChartModel permisoMsp;
    private CartesianChartModel permisoMi;
    private CartesianChartModel permisoMt;
    private CartesianChartModel rucRise;

    public CtrlCumplPermisosCircuito() {
        this.graficar();
    }
    
    @PostConstruct
    private void graficar(){
        this.permisoMunicipal=pMunicipio();
        this.permisoBomberos=pBomberos();
        this.permisoMi=pMi();
        this.permisoMsp=pMsp();
        this.permisoMt=pMt();
        this.rucRise=rucRise();
    }
    
    
    private CartesianChartModel pMunicipio(){
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries abierto=new ChartSeries();
            abierto.setLabel("Si presenta");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                abierto.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        BusquedasLocalesCircuitos.obtenerDatosDadoCircuitoPermisoMunicipio(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "Si").size());
            }
            
            ChartSeries nopresenta=new ChartSeries();
            nopresenta.setLabel("No presenta");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                nopresenta.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        BusquedasLocalesCircuitos.obtenerDatosDadoCircuitoPermisoMunicipio(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "No").size());
            }
            model.addSeries(abierto);
            model.addSeries(nopresenta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
    
     private CartesianChartModel pBomberos(){
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries abierto=new ChartSeries();
            abierto.setLabel("Si presenta");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                abierto.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        BusquedasLocalesCircuitos.obtenerDatosDadoCircuitoPermisoBomberos(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "Si").size());
            }
            
            ChartSeries nopresenta=new ChartSeries();
            nopresenta.setLabel("No presenta");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                nopresenta.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        BusquedasLocalesCircuitos.obtenerDatosDadoCircuitoPermisoBomberos(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "No").size());
            }
            model.addSeries(abierto);
            model.addSeries(nopresenta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
    private CartesianChartModel pMsp(){
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries abierto=new ChartSeries();
            abierto.setLabel("Si presenta");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                abierto.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        BusquedasLocalesCircuitos.obtenerDatosDadoCircuitoPermisoMsp(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "Si").size());
            }
            
            ChartSeries nopresenta=new ChartSeries();
            nopresenta.setLabel("No presenta");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                nopresenta.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        BusquedasLocalesCircuitos.obtenerDatosDadoCircuitoPermisoMsp(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "No").size());
            }
            model.addSeries(abierto);
            model.addSeries(nopresenta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    private CartesianChartModel pMi(){
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries abierto=new ChartSeries();
            abierto.setLabel("Si presenta");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                abierto.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        BusquedasLocalesCircuitos.obtenerDatosDadoCircuitoPermisoMinisterioInterior(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "Si").size());
            }
            
            ChartSeries nopresenta=new ChartSeries();
            nopresenta.setLabel("No presenta");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                nopresenta.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        BusquedasLocalesCircuitos.obtenerDatosDadoCircuitoPermisoMinisterioInterior(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "No").size());
            }
            model.addSeries(abierto);
            model.addSeries(nopresenta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
    
    private CartesianChartModel pMt(){
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries abierto=new ChartSeries();
            abierto.setLabel("Si presenta");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                abierto.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        BusquedasLocalesCircuitos.obtenerDatosDadoCircuitoPermisoMinisterioTurismo(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "Si").size());
            }
            
            ChartSeries nopresenta=new ChartSeries();
            nopresenta.setLabel("No presenta");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                nopresenta.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        BusquedasLocalesCircuitos.obtenerDatosDadoCircuitoPermisoMinisterioTurismo(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "No").size());
            }
            model.addSeries(abierto);
            model.addSeries(nopresenta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
    
    private CartesianChartModel rucRise(){
        CartesianChartModel model = new CartesianChartModel();
        try {
            ChartSeries abierto=new ChartSeries();
            abierto.setLabel("RUC");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                abierto.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        BusquedasLocalesCircuitos.obtenerDatosDadoCircuitoRucRise(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "RUC").size());
            }
            
            ChartSeries nopresenta=new ChartSeries();
            nopresenta.setLabel("RISE");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                nopresenta.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        BusquedasLocalesCircuitos.obtenerDatosDadoCircuitoRucRise(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "RISE").size());
            }
            
            ChartSeries ninguno=new ChartSeries();
            ninguno.setLabel("Ninguno");
            for (int i=0;i<CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().size();i++){
                ninguno.set(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), 
                        BusquedasLocalesCircuitos.obtenerDatosDadoCircuitoRucRise(CircuitoSubcircuitoUrbano.obtenerCircuitoUrbano().get(i), "Ninguno").size());
            }
            model.addSeries(abierto);
            model.addSeries(nopresenta);
            model.addSeries(ninguno);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
    
    
    /*
    ** get y set
    */
    public CartesianChartModel getPermisoMunicipal() {
        return permisoMunicipal;
    }

    public void setPermisoMunicipal(CartesianChartModel permisoMunicipal) {
        this.permisoMunicipal = permisoMunicipal;
    }

    public CartesianChartModel getPermisoBomberos() {
        return permisoBomberos;
    }

    public void setPermisoBomberos(CartesianChartModel permisoBomberos) {
        this.permisoBomberos = permisoBomberos;
    }

    public CartesianChartModel getPermisoMsp() {
        return permisoMsp;
    }

    public void setPermisoMsp(CartesianChartModel permisoMsp) {
        this.permisoMsp = permisoMsp;
    }

    public CartesianChartModel getPermisoMi() {
        return permisoMi;
    }

    public void setPermisoMi(CartesianChartModel permisoMi) {
        this.permisoMi = permisoMi;
    }

    public CartesianChartModel getPermisoMt() {
        return permisoMt;
    }

    public void setPermisoMt(CartesianChartModel permisoMt) {
        this.permisoMt = permisoMt;
    }

    public CartesianChartModel getRucRise() {
        return rucRise;
    }

    public void setRucRise(CartesianChartModel rucRise) {
        this.rucRise = rucRise;
    }
    
    
    
    
}
