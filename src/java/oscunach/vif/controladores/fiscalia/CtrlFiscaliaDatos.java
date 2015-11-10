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
import oscunach.vif.busquedas.FBFichaFiscalia;
import oscunach.vif.entidades.FichaVif;
import recursos.Util;

/**
 *
 * @author servidor
 */
@ManagedBean
@RequestScoped
public class CtrlFiscaliaDatos {

    private ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
    private int anioSel;

    public CtrlFiscaliaDatos() {
        //anioSel=2014;
        //this.reinit();
        //this.lst = new ArrayList<FichaVif>();   
    }

   /* private void reinit() {
        this.lst = new ArrayList<FichaVif>();        
    }
*/
    
    public void obtenerDatosDadoAnio() {
        try {
            this.lst = FBFichaFiscalia.obtenerDatosDadoAnio(anioSel);
            System.out.println(lst.get(0).getApellidos_victima());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtenerDatosDadoAnio() dice: " + e.getMessage());
            System.out.println("public void obtenerDatosDadoAnio() dice: " + e.getMessage());
        }
    }

    /*
     ** Get y set
     */
    public ArrayList<FichaVif> getLst() {
        return lst;
    }

    public void setLst(ArrayList<FichaVif> lst) {
        this.lst = lst;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

}
