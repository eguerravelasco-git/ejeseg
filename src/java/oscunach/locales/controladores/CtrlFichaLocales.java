/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.locales.controladores;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import oscunach.locales.entidades.Locales;
import recursos.Circuitos;
import recursos.Subcircuito;
import recursos.Util;
import recursos.funciones.servicios.ServiciosCircuitos;
import recursos.funciones.servicios.ServiciosSubcircuito;

/**
 *
 * @author Oscunach
 */
@ManagedBean
@RequestScoped
public class CtrlFichaLocales {

    private Locales objlocales;
    private int codigoCircuito;
    private int codigoSubcircuito;
    private ArrayList<Subcircuito> lstSubcircuito;
    private ArrayList<Circuitos> lstCircuito;
    private Date horarioDiurno;
    private Date horarioNocturno;

    public Date getHorarioDiurno() {
        return horarioDiurno;
    }

    public void setHorarioDiurno(Date horarioDiurno) {
        this.horarioDiurno = horarioDiurno;
    }

    public Date getHorarioNocturno() {
        return horarioNocturno;
    }

    public void setHorarioNocturno(Date horarioNocturno) {
        this.horarioNocturno = horarioNocturno;
    }

    public int getCodigoSubcircuito() {
        return codigoSubcircuito;
    }

    public void setCodigoSubcircuito(int codigoSubcircuito) {
        this.codigoSubcircuito = codigoSubcircuito;
    }

    public ArrayList<Subcircuito> getLstSubcircuito() {
        return lstSubcircuito;
    }

    public void setLstSubcircuito(ArrayList<Subcircuito> lstSubcircuito) {
        this.lstSubcircuito = lstSubcircuito;
    }

    public ArrayList<Circuitos> getLstCircuito() {
        return lstCircuito;
    }

    public void setLstCircuito(ArrayList<Circuitos> lstCircuito) {
        this.lstCircuito = lstCircuito;
    }

    public int getCodigoCircuito() {
        return codigoCircuito;
    }

    public void setCodigoCircuito(int codigoCircuito) {
        this.codigoCircuito = codigoCircuito;
    }

    public Locales getObjlocales() {
        return objlocales;
    }

    public void setObjlocales(Locales objlocales) {
        this.objlocales = objlocales;
    }

    public CtrlFichaLocales() {
        this.reinit();
    }

    private void reinit() {
        this.objlocales = new Locales();
        this.lstCircuito = new ArrayList<Circuitos>();
        this.cargarCircuitos();
        //this.cargarSubcircuitos();

    }

    public void insertarFicha() {
        try {
            objlocales.setProvincia("CHIMBORAZO");
            objlocales.setCanton("RIOBAMBA");
            objlocales.setCodigo_circuito("actualizar");
            objlocales.setCodigo_subcircuito("actualizar");
        } catch (Exception e) {
        }
    }

    private void cargarCircuitos() {
        try {
            this.lstCircuito = ServiciosCircuitos.obtenerCircuito();
            System.out.println(lstCircuito.get(0).getId_circuito());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCircuitos dice: " + e.getMessage());
            System.out.println("private void cargarCircuitos dice: " + e.getMessage());
        }
    }

    private void cargarSubcircuitos() {
        try {
            this.lstSubcircuito = ServiciosSubcircuito.obtenerSubcircuito();
            System.out.println(lstCircuito.get(0).getId_circuito());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCircuitos dice: " + e.getMessage());
            System.out.println("private void cargarCircuitos dice: " + e.getMessage());
        }
    }

    public void cargarSubcircuitosDadoCodigoCircuito() {
        try {
            this.lstSubcircuito = ServiciosSubcircuito.obtenerSubcircuitoDadoIdCircuito(codigoCircuito);
            System.out.println(lstCircuito.get(0).getId_circuito());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCircuitos dice: " + e.getMessage());
            System.out.println("private void cargarCircuitos dice: " + e.getMessage());
        }
    }

}
