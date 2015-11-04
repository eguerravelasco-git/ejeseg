/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.locales.controladores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import oscunach.locales.entidades.Locales;

/**
 *
 * @author Oscunach
 */
@ManagedBean
@RequestScoped
public class CtrlFichaLocales {

    private Locales objlocales;

    public Locales getObjlocales() {
        return objlocales;
    }

    public void setObjlocales(Locales objlocales) {
        this.objlocales = objlocales;
    }

    public CtrlFichaLocales() {
    }
    
    public void insertarFicha(){
        try {
            objlocales.setProvincia("CHIMBORAZO");
            objlocales.setCanton("RIOBAMBA");
        } catch (Exception e) {
        }
    }

}
