/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.entidades;

/**
 *
 * @author Geovanny
 */
public class Reincidencias {

    private int reincidencia;
    private String victima;
    private String sexo_victima;

    public Reincidencias() {
    }

    public Reincidencias(int reincidencia, String victima, String sexo_victima) {
        this.reincidencia = reincidencia;
        this.victima = victima;
        this.sexo_victima = sexo_victima;
    }

    public int getReincidencia() {
        return reincidencia;
    }

    public void setReincidencia(int reincidencia) {
        this.reincidencia = reincidencia;
    }

    public String getVictima() {
        return victima;
    }

    public void setVictima(String victima) {
        this.victima = victima;
    }

    public String getSexo_victima() {
        return sexo_victima;
    }

    public void setSexo_victima(String sexo_victima) {
        this.sexo_victima = sexo_victima;
    }

}
