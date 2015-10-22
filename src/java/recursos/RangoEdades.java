/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

/**
 *
 * @author Oscunach
 */
public class RangoEdades {

    private String rango;
    private String especificacion;

    public RangoEdades() {
    }

    public RangoEdades(String rango, String especificacion) {
        this.rango = rango;
        this.especificacion = especificacion;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

}
