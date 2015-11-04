/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.utiles.controladores;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Circuitos;
import recursos.Util;
import recursos.funciones.servicios.ServiciosCircuitos;

/**
 *
 * @author ICITS SALA5
 */
@ManagedBean
@RequestScoped
public class ControladorCircuitoBeans {

    /**
     * Creates a new instance of ControladorCircuitoBeans
     */
    
    private Circuitos objCircuito;
    private Circuitos circuitoSel;
    private ArrayList<Circuitos> lstCircuito;
    private boolean mostrarActualizar;
    private int id_circ;

    public int getId_circ() {
        return id_circ;
    }

    public void setId_circ(int id_circ) {
        this.id_circ = id_circ;
    }

    public Circuitos getObjCircuito() {
        return objCircuito;
    }

    public void setObjCircuito(Circuitos objCircuito) {
        this.objCircuito = objCircuito;
    }

    public Circuitos getCircuitoSel() {
        return circuitoSel;
    }

    public void setCircuitoSel(Circuitos circuitoSel) {
        this.circuitoSel = circuitoSel;
    }

    public ArrayList<Circuitos> getLstCircuito() {
        return lstCircuito;
    }

    public void setLstCircuito(ArrayList<Circuitos> lstCircuito) {
        this.lstCircuito = lstCircuito;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public ControladorCircuitoBeans() {
        this.reinit();
    }

    public void reinit() {
        this.objCircuito = new Circuitos();
        this.circuitoSel = new Circuitos();
        this.lstCircuito = new ArrayList<Circuitos>();
        this.obtnerCircuito();
    }

    public void obtnerCircuito() {
        try {
            this.lstCircuito = ServiciosCircuitos.obtenerCircuito();
            this.circuitoSel = lstCircuito.get(0);
            System.out.println(lstCircuito.get(0).getId_circuito());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtnerCircuito dice:" + e.getMessage());
            System.out.println("public void obtnerCircuito dice:" + e.getMessage());
        }

    }

    public void insertarCircuito() {
        try {
            if (ServiciosCircuitos.insertarCircuito(objCircuito)) {
                //this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCircuito.hide()");
                Util.addSuccessMessage("Información Guarda con éxito");
                System.out.println("public void insertarCircuito dice: ");

            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarCircuito dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage(" public void insertarCircuito dice: " + e.getMessage());
            System.out.println(" public void insertarCircuito dice: " + e.getMessage());
        }
        objCircuito=new Circuitos();
    }
    
    
    

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarCircuito() {
        try {
            //victimaSel.setId_victima(victimaSel.getId_victima());
            circuitoSel.setId_circuito(circuitoSel.getId_circuito());
            if (ServiciosCircuitos.actualizarCircuito(circuitoSel)) {
                circuitoSel = new Circuitos();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarCircuito.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarCircuito dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarCircuito dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("public void actualizarCircuito dice: " + e.getMessage());
            System.out.println("public void actualizarCircuito dice: " + e.getMessage());
        }
    }

    public void eliminarCircuito() {
        try {
            //if(FAgresor.eliminarAgresor((int)agresorSel.getId_agresor())){
            if (ServiciosCircuitos.eliminar((int) circuitoSel.getId_circuito())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCircuito.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarCircuito dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarCircuito dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarCircuito dice: " + e.getMessage());
            System.out.println("private void eliminarCircuito dice: " + e.getMessage());
        }
    }

//     public void obtenerEscuelasDadoCodigoFacultad() {
//        try {
//            lstEscuelas.clear();
//            lstEscuelas = FEscuela.ObtenerEscuelaDadoCodigoFacultad(valorFSeleccionada);
//        } catch (Exception e) {
//            Util.addErrorMessage("private void cargarEscuelasDadoCodigoFacultad: " + e.getMessage());
//            System.out.println("private void cargarEscuelasDadoCodigoFacultad: " + e.getMessage());
//        }
//    }
    public void obtenerCircuitoDadoId() {
        try {
            circuitoSel = ServiciosCircuitos.ObtenerCircuitoDadoId(id_circ);
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
            System.out.println(""+e.getMessage());
        }
    }
}

