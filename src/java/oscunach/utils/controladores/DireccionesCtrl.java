/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.utils.controladores;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.DefaultRequestContext;
import oscunach.utils.entidades.Circuito;
import oscunach.utils.entidades.Direcciones;
import oscunach.utils.entidades.Subcircuito;
import oscunach.utils.servicios.FCircuito;
import oscunach.utils.servicios.FDirecciones;
import oscunach.utils.servicios.FSubcircuito;
import recursos.Util;

/**
 *
 * @author servidor
 */
@ManagedBean
@RequestScoped
public class DireccionesCtrl {

    /**
     * Creates a new instance of DireccionesCtrl
     */
    private ArrayList<Direcciones> lstDirecciones;
    private Direcciones direccionesSel;
    private Direcciones objDirecciones;
    private boolean mostrarActualizar;
    private ArrayList<Circuito> lstCircuitos;
    private ArrayList<Subcircuito> lstSubcircuitos;
    private Subcircuito subcircSel;
    private String criterioBusqueda;
    private String direccionBuscar;

    public String getDireccionBuscar() {
        return direccionBuscar;
    }

    public void setDireccionBuscar(String direccionBuscar) {
        this.direccionBuscar = direccionBuscar;
    }

    public String getCriterioBusqueda() {
        return criterioBusqueda;
    }

    public void setCriterioBusqueda(String criterioBusqueda) {
        this.criterioBusqueda = criterioBusqueda;
    }

    public Subcircuito getSubcircSel() {
        return subcircSel;
    }

    public void setSubcircSel(Subcircuito subcircSel) {
        this.subcircSel = subcircSel;
    }

    public ArrayList<Circuito> getLstCircuitos() {
        return lstCircuitos;
    }

    public void setLstCircuitos(ArrayList<Circuito> lstCircuitos) {
        this.lstCircuitos = lstCircuitos;
    }

    public ArrayList<Subcircuito> getLstSubcircuitos() {
        return lstSubcircuitos;
    }

    public void setLstSubcircuitos(ArrayList<Subcircuito> lstSubcircuitos) {
        this.lstSubcircuitos = lstSubcircuitos;
    }

    public ArrayList<Direcciones> getLstDirecciones() {
        return lstDirecciones;
    }

    public void setLstDirecciones(ArrayList<Direcciones> lstDirecciones) {
        this.lstDirecciones = lstDirecciones;
    }

    public Direcciones getDireccionesSel() {
        return direccionesSel;
    }

    public void setDireccionesSel(Direcciones direccionesSel) {
        this.direccionesSel = direccionesSel;
    }

    public Direcciones getObjDirecciones() {
        return objDirecciones;
    }

    public void setObjDirecciones(Direcciones objDirecciones) {
        this.objDirecciones = objDirecciones;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    private void reinit() {
        this.direccionesSel = new Direcciones();
        this.objDirecciones = new Direcciones();
        this.lstCircuitos = new ArrayList<Circuito>();
        this.lstDirecciones = new ArrayList<Direcciones>();
        this.lstSubcircuitos = new ArrayList<Subcircuito>();
        this.cargarCircuitos();
        this.cargarDirecciones();
        this.cargarSubcircuitos();
    }

    public DireccionesCtrl() {
        this.reinit();
    }

    public void cargarDirecciones() {
        try {
            this.lstDirecciones = FDirecciones.obtenerDirecciones();
            this.direccionesSel = lstDirecciones.get(0);
            System.out.println(lstCircuitos.get(0).getId_circuito());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtnerCircuito dice:" + e.getMessage());
            System.out.println("public void obtnerCircuito dice:" + e.getMessage());
        }
    }

    public void cargarCircuitos() {
        try {
            this.lstCircuitos = FCircuito.obtenerCircuito();
            System.out.println(lstCircuitos.get(0).getId_circuito());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtnerCircuito dice:" + e.getMessage());
            System.out.println("public void obtnerCircuito dice:" + e.getMessage());
        }
    }

    public void cargarSubcircuitos() {
        try {
            this.lstSubcircuitos = FSubcircuito.obtenerSubcircuito();
            this.subcircSel = lstSubcircuitos.get(0);
            System.out.println(lstSubcircuitos.get(0).getId_subcircuito());
        } catch (Exception e) {
            Util.addErrorMessage("public void cargarSubcircuitos dice: " + e.getMessage());
            System.err.println("public void cargarSubcircuitos dice: " + e.getMessage());
        }
    }

    public void transferirCircuitos() {
        try {
            this.objDirecciones.setCircuito(subcircSel.getId_circuito().getDescripcion());
            this.objDirecciones.setCodigo_circuito(subcircSel.getId_circuito().getCodigo_circuito());
            this.objDirecciones.setSubcircuito(subcircSel.getDescripcion());
            this.objDirecciones.setCodigo_subcircuito(subcircSel.getCodigo_subcircuito());
            DefaultRequestContext.getCurrentInstance().execute("wdlgSubcircuitos.hide()");
            Util.addSuccessMessage("Información transferida con éxito");
            Util.addSuccessMessage("Circuito: " + subcircSel.getId_circuito().getDescripcion());
            Util.addSuccessMessage("Subcircuito: " + subcircSel.getDescripcion());
        } catch (Exception e) {
            Util.addErrorMessage("public void transferirCircuitos() dice: " + e.getMessage());
            System.err.println("public void transferirCircuitos() dice: " + e.getMessage());
        }
    }

    public void insertarDireccion() {
        try {

            this.transferirCircuitos();
            if (FDirecciones.insertarDirecciones(objDirecciones)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevaDireccion.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("  public void insertarDireccion():Información guardada con éxito");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarDireccion(): Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("public void insertarDireccion(): " + e.getMessage());
            System.out.println("public void insertarDireccion(): " + e.getMessage());
        }
    }

    public void obtenerDireccionesPorCalle() {
        try {
            this.lstDirecciones = FDirecciones.obtenerLstDireccionesDadoCalles(direccionBuscar);
            this.direccionesSel = lstDirecciones.get(0);
            System.out.println(lstDirecciones.get(0).getCalles());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtenerDireccionesPorCalle() dice: " + e.getMessage());
            System.out.println("public void obtenerDireccionesPorCalle() dice: " + e.getMessage());
        }
    }
    
    
}
