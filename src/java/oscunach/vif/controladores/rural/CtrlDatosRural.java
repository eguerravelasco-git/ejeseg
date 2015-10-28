/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.rural;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import oscunach.vif.busquedas.FBVifRural;
import oscunach.vif.entidades.VifRural;

/**
 *
 * @author oscunach
 */
@ManagedBean
@RequestScoped
public class CtrlDatosRural {

    private ArrayList<VifRural> lst;
    private int anioSel;

    public ArrayList<VifRural> getLst() {
        return lst;
    }

    public void setLst(ArrayList<VifRural> lst) {
        this.lst = lst;
    }

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public CtrlDatosRural() {
       this.lst=new ArrayList<VifRural>();
    }

    public void cargarDatos()
    {
        try {
            lst=FBVifRural.obtenerDatosDadoAnio(anioSel);
        } catch (Exception e) {
        }
    }
}
