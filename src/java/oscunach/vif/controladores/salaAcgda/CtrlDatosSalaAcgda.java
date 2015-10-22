/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.salaAcgda;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import oscunach.vif.busquedas.FBSalaAcgda;
import oscunach.vif.entidades.SalaAcgda;
import recursos.Util;

/**
 *
 * @author Oscunach
 */
@ManagedBean
@RequestScoped
public class CtrlDatosSalaAcgda implements Serializable {

    /**
     * Creates a new instance of CtrlDatosSalaAcgda
     */
    private ArrayList<SalaAcgda> lstDatos;
    private int anioSel;

    public ArrayList<SalaAcgda> getLstDatos() {
        return lstDatos;
    }

    public void setLstDatos(ArrayList<SalaAcgda> lstDatos) {
        this.lstDatos = lstDatos;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CtrlDatosSalaAcgda() {
        this.reinit();
    }

    private void reinit() {
        this.lstDatos = new ArrayList<SalaAcgda>();
        this.obtenerDatos();
    }

    public void obtenerDatos() {
        try {
            this.lstDatos = FBSalaAcgda.obtenerDatos();
            System.out.println(lstDatos.get(0).getApellidos_victima());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtenerDatos() dice: " + e.getMessage());
            System.out.println("public void obtenerDatos() dice: " + e.getMessage());
        }
    }

 
    public void obtenerDatosDadoAnio() {
        try {
            this.lstDatos = FBSalaAcgda.obtenerDatosDadoAnio(anioSel);
            System.out.println(lstDatos.get(0).getApellidos_victima());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtenerDatosDadoAnio() dice: " + e.getMessage());
            System.out.println("public void obtenerDatosDadoAnio() dice: " + e.getMessage());
        }
    }

}
