/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.unidadesfamilia;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import oscunach.vif.busquedas.FBUnidadFamilia;
import oscunach.vif.entidades.UnidadesFamilia;

/**
 *
 * @author oscunach
 */
@ManagedBean
@RequestScoped
public class CtrlUnidFmliaDatos {

    private int anioSel;
    private ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
    
    
    public CtrlUnidFmliaDatos() {
        this.obtenerDatos();
    }
                 
    public void obtenerDatosDadoAnio(){
        try {
            lst=FBUnidadFamilia.obtenerDatosDadoAnio(anioSel);
            System.out.println(lst.get(0).getEdad_victima());
        } catch (Exception e) {
            System.out.println("obtenerDatos dice: "+e.getMessage());
        }
    }
            
    
    public void obtenerDatos(){
        try {
            lst=FBUnidadFamilia.obtenerDatos();
            System.out.println(lst.get(0).getEdad_victima());
        } catch (Exception e) {
            System.out.println("obtenerDatosDadoAnio dice: "+e.getMessage());
        }
    }
    
    
    /*
    ** gettes y setters
    */

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }

    public ArrayList<UnidadesFamilia> getLst() {
        return lst;
    }

    public void setLst(ArrayList<UnidadesFamilia> lst) {
        this.lst = lst;
    }
    
    
    
}
