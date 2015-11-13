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
import oscunach.locales.busquedas.BusquedasLocales;
import oscunach.locales.entidades.Locales;

/**
 *
 * @author Geovanny
 */
@ManagedBean
@RequestScoped
public class CtrlDatosLocales {

    private ArrayList<Locales> lst;

    public CtrlDatosLocales() {
        this.init();
        obtenerDatos();
    }
    
    private void init(){
        this.lst=new ArrayList<Locales>();
    }
    public void obtenerDatos() {
        try {
            lst = BusquedasLocales.obtenerLocales();
        } catch (Exception e) {
            System.out.println("obtenerDatos dice: "+e.getMessage());
        }
    }

    /*
     ** metodos get y set
     */
    public ArrayList<Locales> getLst() {
        return lst;
    }

    public void setLst(ArrayList<Locales> lst) {
        this.lst = lst;
    }

}
