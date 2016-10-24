/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.devif;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import oscunach.vif.busquedas.FBDevif;
import oscunach.vif.entidades.Devif;
import recursos.Util;

/**
 *
 * @author Geovanny
 */
@ManagedBean
@RequestScoped
public class CtrlDatosDevif {

    private ArrayList<Devif> lst;
    private int anioSel;
    private int totalDenuncias;

    public int getTotalDenuncias() {
        return totalDenuncias;
    }

    public void setTotalDenuncias(int totalDenuncias) {
        this.totalDenuncias = totalDenuncias;
    }
    
    public ArrayList<Devif> getLst() {
        return lst;
    }

    public void setLst(ArrayList<Devif> lst) {
        this.lst = lst;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CtrlDatosDevif() {
        this.reinit();
    }
    
    private void reinit() {
        this.lst = new ArrayList<Devif>();
        this.obtenerDatos();
    }

    public void obtenerDatos() {
        try {
            this.lst= FBDevif.obtenerDatos();
            this.totalDenuncias=lst.size();
            System.out.println(lst.get(0).getApellidos_nombres_victima());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtenerDatos() dice: " + e.getMessage());
            System.out.println("public void obtenerDatos() dice: " + e.getMessage());
        }
    }
 
    public void obtenerDatosDadoAnio() {
        try {
            this.lst = FBDevif.obtenerDatosDadoAnio(anioSel);
             this.totalDenuncias=lst.size();
            System.out.println(lst.get(0).getApellidos_nombres_victima());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtenerDatosDadoAnio() dice: " + e.getMessage());
            System.out.println("public void obtenerDatosDadoAnio() dice: " + e.getMessage());
        }
    }

}
