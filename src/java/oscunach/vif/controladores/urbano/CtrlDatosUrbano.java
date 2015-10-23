/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.urbano;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import oscunach.vif.busquedas.FBVifUrbano;
import oscunach.vif.entidades.VifUrbano;
import recursos.Util;

/**
 *
 * @author Oscunach
 */
@ManagedBean
@RequestScoped
public class CtrlDatosUrbano {

    /**
     * Creates a new instance of CtrlDatosUrbano
     */
    private ArrayList<VifUrbano> lst;
    private int anioSel;

    public ArrayList<VifUrbano> getLst() {
        return lst;
    }

    public void setLst(ArrayList<VifUrbano> lst) {
        this.lst = lst;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CtrlDatosUrbano() {
        this.reinit();
    }
    
    private void reinit() {
        this.lst = new ArrayList<VifUrbano>();
        this.obtenerDatos();
    }

    public void obtenerDatos() {
        try {
            this.lst= FBVifUrbano.obtenerDatos();
            System.out.println(lst.get(0).getVictima());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtenerDatos() dice: " + e.getMessage());
            System.out.println("public void obtenerDatos() dice: " + e.getMessage());
        }
    }

 
    public void obtenerDatosDadoAnio() {
        try {
            this.lst = FBVifUrbano.obtenerDatosDadoAnio(anioSel);
            System.out.println(lst.get(0).getVictima());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtenerDatosDadoAnio() dice: " + e.getMessage());
            System.out.println("public void obtenerDatosDadoAnio() dice: " + e.getMessage());
        }
    }

}
