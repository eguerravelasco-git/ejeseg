/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.locales.controladores;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import oscunach.locales.entidades.CatastroIntendencia2015;
import oscunach.locales.servicios.ServiciosCatastroIntendencia2015;

/**
 *
 * @author Geovanny
 */
@ManagedBean
public class CtrlCatastroIntendencia {

   private ArrayList<CatastroIntendencia2015> lstDatos;
   
   
    public CtrlCatastroIntendencia() {
        this.init();
        obtenerCatastro();
    }
    
    private void init(){
        this.lstDatos=new ArrayList<CatastroIntendencia2015>();        
    }
    
    @PostConstruct
    public void obtenerCatastro(){
        try {
            lstDatos=ServiciosCatastroIntendencia2015.ObtenerCatastroIntendencia2015();
        } catch (Exception e) {
            System.out.println("obtenerCatastro dice: "+e.getMessage());
        }
    }
            
    
    /*
    ** get y set
    */

    public ArrayList<CatastroIntendencia2015> getLstDatos() {
        return lstDatos;
    }

    public void setLstDatos(ArrayList<CatastroIntendencia2015> lstDatos) {
        this.lstDatos = lstDatos;
    }
    
    
}
