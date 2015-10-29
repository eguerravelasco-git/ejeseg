/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.utils.controladores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import org.primefaces.context.DefaultRequestContext;
import oscunach.utils.entidades.Circuito;
import oscunach.utils.entidades.Subcircuito;
import oscunach.utils.servicios.FCircuito;
import oscunach.utils.servicios.FSubcircuito;
import recursos.Util;


/**
 *
 * @author Virt-ICITS-2
 */
@ManagedBean
@RequestScoped
public class SubcircuitoControlador {

    private Subcircuito objSubcircuito;
    private Subcircuito subcircuitoSel;
    private ArrayList<Subcircuito> lstSubcircuito;
    private ArrayList<Circuito> lstCircuito;
    private boolean mostrarActualizar;
    private int valorCSeleccionado;
    private Circuito codigoCircuitoSel;   

    public void ccodigoCircSel() {
        try {
            codigoCircuitoSel = FCircuito.ObtenerCircuitoDadoId(valorCSeleccionado);
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
            System.out.println("" + e.getMessage());
        }

    }

    public Circuito getCodigoCircuitoSel() {
        return codigoCircuitoSel;
    }

    public void setCodigoCircuitoSel(Circuito codigoCircuitoSel) {
        this.codigoCircuitoSel = codigoCircuitoSel;
    }

    public Subcircuito getObjSubcircuito() {
        return objSubcircuito;
    }

    public void setObjSubcircuito(Subcircuito objSubcircuito) {
        this.objSubcircuito = objSubcircuito;
    }

    public Subcircuito getSubcircuitoSel() {
        return subcircuitoSel;
    }

    public void setSubcircuitoSel(Subcircuito subcircuitoSel) {
        this.subcircuitoSel = subcircuitoSel;
    }

    public ArrayList<Subcircuito> getLstSubcircuito() {
        return lstSubcircuito;
    }

    public void setLstSubcircuito(ArrayList<Subcircuito> lstSubcircuito) {
        this.lstSubcircuito = lstSubcircuito;
    }

    public ArrayList<Circuito> getLstCircuito() {
        return lstCircuito;
    }

    public void setLstCircuito(ArrayList<Circuito> lstCircuito) {
        this.lstCircuito = lstCircuito;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorCSeleccionado() {
        return valorCSeleccionado;
    }

    public void setValorCSeleccionado(int valorCSeleccionado) {
        this.valorCSeleccionado = valorCSeleccionado;
    }

    public SubcircuitoControlador() {
        this.reinit();
    }

    private void reinit() {
        this.objSubcircuito = new Subcircuito();
        this.subcircuitoSel = new Subcircuito();
        this.lstCircuito = new ArrayList<Circuito>();
        this.lstSubcircuito = new ArrayList<Subcircuito>();
        this.cargarCircuitos();
        this.cargarSubcircuitos();
        this.ccodigoCircSel();

    }

    public void cargarSubcircuitos() {
        try {
            this.lstSubcircuito = FSubcircuito.obtenerSubcircuito();
            this.subcircuitoSel = lstSubcircuito.get(0);
            System.out.println(lstSubcircuito.get(0).getId_subcircuito());
        } catch (Exception e) {
            Util.addErrorMessage("public void cargarSubcircuitos dice: " + e.getMessage());
            System.err.println("public void cargarSubcircuitos dice: " + e.getMessage());
        }
    }

    private void cargarCircuitos() {
        try {
            this.lstCircuito = FCircuito.obtenerCircuito();
            System.out.println(lstCircuito.get(0).getId_circuito());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCircuitos dice: " + e.getMessage());
            System.out.println("private void cargarCircuitos dice: " + e.getMessage());
        }
    }

    public void insertarSubcircuito() {
        try {
            //if (FCircuito.insertarCircuito(objCircuito)) {
            objSubcircuito.setId_circuito(FCircuito.ObtenerCircuitoDadoId(valorCSeleccionado));
            if (FSubcircuito.insertarSubcircuito(objSubcircuito)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoSubcircuito.hide()");
                Util.addSuccessMessage("Información Guarda con éxito");
                System.out.println("public void insertarSubcircuito dice: Información Guardada con éxito");

            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarSubcircuito dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage(" public void insertarSubcircuito dice: " + e.getMessage());
            System.out.println(" public void insertarSubcircuito dice: " + e.getMessage());
        }
    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarSubcircuito() {
        try {
            subcircuitoSel.setId_subcircuito(subcircuitoSel.getId_subcircuito());
            if (FSubcircuito.actualizarSubcircuito(subcircuitoSel)) {
                subcircuitoSel = new Subcircuito();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarSubcircuito.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarSubcircuito dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarSubcircuito dice: nformación guardada con éxito!!");
            }
        } catch (Exception e) {
            Util.addErrorMessage("public void actualizarSubcircuito dice: " + e.getMessage());
            System.out.println("public void actualizarSubcircuito dice: " + e.getMessage());
        }
    }

    public void eliminarSubcircuito() {
        try {
            //if (FEstudiante.eliminar((int) estudianteSel.getCodigo())) {
            if (FSubcircuito.eliminar((int) subcircuitoSel.getId_subcircuito())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarSubcircuito.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarSubcircuito dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarSubcircuito dice: Información Eliminada!!!");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarSubcircuito dice: " + e.getMessage());
            System.out.println("private void eliminarSubcircuito dice: " + e.getMessage());
        }

    }

}
