/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.locales.controladores;

import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import oscunach.locales.entidades.CatastroIntendencia2015;
import oscunach.locales.servicios.ServiciosCatastroIntendencia2015;
import recursos.Util;

/**
 *
 * @EdwinMaiguia
 */
@ManagedBean
@RequestScoped
public class BeanCatastroIntendencia2015 {

    private ArrayList<CatastroIntendencia2015> lstCatastro;
    private CatastroIntendencia2015 catastro;
    private int codigo;
    private String propietarioSel;
    private int codigoSel;

    public int getCodigoSel() {
        return codigoSel;
    }

    public void setCodigoSel(int codigoSel) {
        this.codigoSel = codigoSel;
    }

    public String getPropietarioSel() {
        return propietarioSel;
    }

    public void setPropietarioSel(String propietarioSel) {
        this.propietarioSel = propietarioSel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public CatastroIntendencia2015 getCatastro() {
        return catastro;
    }

    public void setCatastro(CatastroIntendencia2015 catastro) {
        this.catastro = catastro;
    }

    public ArrayList<CatastroIntendencia2015> getLstCatastro() {
        return lstCatastro;
    }

    public void setLstCatastro(ArrayList<CatastroIntendencia2015> lstCatastro) {
        this.lstCatastro = lstCatastro;
    }

    public BeanCatastroIntendencia2015() {
        this.reinit();
        //this.cargarDatos();
    }

    private void reinit() {
        this.catastro = new CatastroIntendencia2015();
        this.lstCatastro = new ArrayList<CatastroIntendencia2015>();
    }

    public void cargarDatos() {
        try {
            lstCatastro = ServiciosCatastroIntendencia2015.ObtenerCatastroIntendencia2015();
            System.out.println(lstCatastro.get(0).getRazon_social());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertar() {
        try {
            if (ServiciosCatastroIntendencia2015.insertar(catastro)) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingresado Correctamente", null);
                FacesContext.getCurrentInstance().addMessage(null, mensaje);

            } else {
            }
        } catch (Exception e) {
        }
        catastro = new CatastroIntendencia2015();
    }

    public void actualizar() {
        try {
            catastro.setCodigo(codigo);
            if (ServiciosCatastroIntendencia2015.actualizar(catastro)) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizado Correctamente", null);
                FacesContext.getCurrentInstance().addMessage(null, mensaje);

            }
        } catch (Exception e) {
        }
    }

    public void eliminar() {
        try {
            catastro.setCodigo(codigo);
            ServiciosCatastroIntendencia2015.eliminar(codigo);
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado Correctamente", null);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);

        } catch (Exception e) {
        }
    }

    public void obtenerDatosDadoPropietario() {
        try {
            lstCatastro = ServiciosCatastroIntendencia2015.ObtenerCatastroIntendencia2015DatoPropietario(propietarioSel);
            System.out.println(lstCatastro.get(0).getPropietario());
        } catch (Exception e) {
            Util.addErrorMessage("public void ObtenerCatastroIntendencia2015DatoPropietario() dice: " + e.getMessage());
            System.out.println("public void ObtenerCatastroIntendencia2015DatoPropietario() dice: " + e.getMessage());
        }
    }

    public void obtenerDatosDadosCodigo() {
        try {
            lstCatastro = ServiciosCatastroIntendencia2015.ObtenerCatastroIntendencia2015DadoCodigo(codigoSel);
            System.out.println(lstCatastro.get(0).getPropietario());
        } catch (Exception e) {
            Util.addErrorMessage("public void ObtenerCatastroIntendencia2015DadoCodigo() dice: " + e.getMessage());
            System.out.println("public void ObtenerCatastroIntendencia2015DadoCodigo() dice: " + e.getMessage());
        }
    }

}
