/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.controladores.ficha;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.DefaultRequestContext;
import oscunach.utils.entidades.Circuito;
import oscunach.utils.entidades.Direcciones;
import oscunach.utils.entidades.Subcircuito;
import oscunach.utils.servicios.FDirecciones;
import oscunach.vif.entidades.FichaVif;
import oscunach.vif.servicios.ServiciosFichaVif;
import recursos.StringToDate;
import recursos.Util;

/**
 *
 * @author servidor
 */
@ManagedBean
@RequestScoped
public class FicheBean {

    /**
     * Creates a new instance of FicheBean
     */
    private FichaVif objFicha;
    private FichaVif fichaSel;
    private ArrayList<Circuito> lstCircuito;
    private ArrayList<Subcircuito> lstSubcircuito;
    private ArrayList<FichaVif> lstFicha;
    private Date fechaDenuncia;
    private Date fechaAgresion;
    private Date horaAgresion;
    private ArrayList<Direcciones> lstDirecciones;
    private Direcciones direccionSel;
    private String direccionBuscar;
    private ArrayList<Direcciones> lstBuscarDirecciones;
    private boolean mostrarActualizar;

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public ArrayList<Direcciones> getLstBuscarDirecciones() {
        return lstBuscarDirecciones;
    }

    public void setLstBuscarDirecciones(ArrayList<Direcciones> lstBuscarDirecciones) {
        this.lstBuscarDirecciones = lstBuscarDirecciones;
    }

    public String getDireccionBuscar() {
        return direccionBuscar;
    }

    public void setDireccionBuscar(String direccionBuscar) {
        this.direccionBuscar = direccionBuscar;
    }

    public Direcciones getDireccionSel() {
        return direccionSel;
    }

    public void setDireccionSel(Direcciones direccionSel) {
        this.direccionSel = direccionSel;
    }

    public ArrayList<Direcciones> getLstDirecciones() {
        return lstDirecciones;
    }

    public void setLstDirecciones(ArrayList<Direcciones> lstDirecciones) {
        this.lstDirecciones = lstDirecciones;
    }

    public Date getHoraAgresion() {
        return horaAgresion;
    }

    public void setHoraAgresion(Date horaAgresion) {
        this.horaAgresion = horaAgresion;
    }

    public Date getFechaAgresion() {
        return fechaAgresion;
    }

    public void setFechaAgresion(Date fechaAgresion) {
        this.fechaAgresion = fechaAgresion;
    }

    public Date getFechaDenuncia() {
        return fechaDenuncia;
    }

    public void setFechaDenuncia(Date fechaDenuncia) {
        this.fechaDenuncia = fechaDenuncia;
    }

    public ArrayList<FichaVif> getLstFicha() {
        return lstFicha;
    }

    public void setLstFicha(ArrayList<FichaVif> lstFicha) {
        this.lstFicha = lstFicha;
    }

    public FichaVif getObjFicha() {
        return objFicha;
    }

    public void setObjFicha(FichaVif objFicha) {
        this.objFicha = objFicha;
    }

    public FichaVif getFichaSel() {
        return fichaSel;
    }

    public void setFichaSel(FichaVif fichaSel) {
        this.fichaSel = fichaSel;
    }

    public ArrayList<Circuito> getLstCircuito() {
        return lstCircuito;
    }

    public void setLstCircuito(ArrayList<Circuito> lstCircuito) {
        this.lstCircuito = lstCircuito;
    }

    public ArrayList<Subcircuito> getLstSubcircuito() {
        return lstSubcircuito;
    }

    public void setLstSubcircuito(ArrayList<Subcircuito> lstSubcircuito) {
        this.lstSubcircuito = lstSubcircuito;
    }

    private void reinit() {
        this.objFicha = new FichaVif();
        this.fichaSel = new FichaVif();
        this.direccionSel = new Direcciones();
        this.lstFicha = new ArrayList<FichaVif>();
        this.lstCircuito = new ArrayList<Circuito>();
        this.lstSubcircuito = new ArrayList<Subcircuito>();
        this.lstDirecciones = new ArrayList<Direcciones>();
        this.obtnerFichas();
        this.obtnerDirecciones();
    }

    public FicheBean() {
        this.reinit();
    }

    public void obtnerFichas() {
        try {
            this.lstFicha = ServiciosFichaVif.obtenerFichas();
            this.fichaSel = lstFicha.get(0);
            System.out.println("Denunciante: " + lstFicha.get(0).getDenunciante() + "Víctima: " + lstFicha.get(0).getNombres_victima());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtnerFichas dice:" + e.getMessage());
            System.out.println("public void obtnerFichas dice:" + e.getMessage());
        }

    }

    public void obtnerDirecciones() {
        try {
            this.lstDirecciones = FDirecciones.obtenerDirecciones();
            this.direccionSel = lstDirecciones.get(0);
            System.out.println("Calles: " + lstDirecciones.get(0).getCalles() + "Circuito: " + lstDirecciones.get(0).getCircuito());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtnerFichas dice:" + e.getMessage());
            System.out.println("public void obtnerFichas dice:" + e.getMessage());
        }

    }

    public void obtenerDireccionesPorCalle() {
        try {
            this.lstDirecciones = FDirecciones.obtenerLstDireccionesDadoCalles(direccionBuscar);
            this.direccionSel = lstDirecciones.get(0);
            System.out.println(lstDirecciones.get(0).getCalles());
        } catch (Exception e) {
            Util.addErrorMessage("public void obtenerDireccionesPorCalle() dice: " + e.getMessage());
            System.out.println("public void obtenerDireccionesPorCalle() dice: " + e.getMessage());
        }
    }

    public void insertarFicha() {
        try {
            objFicha.setFecha_agresion(StringToDate.devolverFecha(fechaAgresion));
            objFicha.setFecha_denuncia(StringToDate.devolverFecha(fechaDenuncia));
            objFicha.setHora_agresion(StringToDate.devolverHora(horaAgresion));
            this.transferirDirecciones();
            if (ServiciosFichaVif.insertarFicha(objFicha)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevaFicha.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarFicha dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarFicha dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarFicha dice: " + e.getMessage());
            System.out.println("private void insertarFicha dice: " + e.getMessage());
        }
        direccionSel = new Direcciones();
    }

    public void transferirDirecciones() {
        try {
            this.objFicha.setDireccion_agresion(direccionSel.getCalles());
            this.objFicha.setCircuito(direccionSel.getCircuito());
            this.objFicha.setCodigo_circuito(direccionSel.getCodigo_circuito());
            this.objFicha.setSubcircuito(direccionSel.getSubcircuito());
            this.objFicha.setCodigo_subcircuito(direccionSel.getCodigo_subcircuito());
            this.objFicha.setX(direccionSel.getX());
            this.objFicha.setY(direccionSel.getY());
            DefaultRequestContext.getCurrentInstance().execute("wdlgDirecciones.hide()");
            Util.addSuccessMessage("Información transferida con éxito");
        } catch (Exception e) {
        }

    }
    
    
    public void transferirActualizarDirecciones(){
        try {
            this.fichaSel.setDireccion_agresion(direccionSel.getCalles());
            this.fichaSel.setCircuito(direccionSel.getCircuito());
            this.fichaSel.setCodigo_circuito(direccionSel.getCodigo_circuito());
            this.fichaSel.setSubcircuito(direccionSel.getSubcircuito());
            this.fichaSel.setCodigo_subcircuito(direccionSel.getCodigo_subcircuito());
            this.fichaSel.setX(direccionSel.getX());
            this.fichaSel.setY(direccionSel.getY());
            DefaultRequestContext.getCurrentInstance().execute("wdlgDirecciones.hide()");
            Util.addSuccessMessage("Información transferida con éxito");
        } catch (Exception e) {
        }
    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void editarFicha() {
        try {
            fichaSel.setFecha_agresion(StringToDate.devolverFecha(fechaAgresion));
            fichaSel.setFecha_denuncia(StringToDate.devolverFecha(fechaDenuncia));
            fichaSel.setHora_agresion(StringToDate.devolverHora(horaAgresion));
            this.transferirActualizarDirecciones();

            if (ServiciosFichaVif.actualizarFicha(fichaSel)) {
                fichaSel = new FichaVif();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarFicha.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void editarFicha() dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void editarFicha() dice: Información guardada con éxito!!");
            }
        } catch (Exception e) {
            Util.addErrorMessage("public void editarFicha() dice: " + e.getMessage());
            System.out.println("public void editarFicha() dice: " + e.getMessage());
        }
    }

}
