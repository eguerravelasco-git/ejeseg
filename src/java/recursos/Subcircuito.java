/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

/**
 *
 * @author ICITS SALA5
 */
public class Subcircuito {
    private int id_subcircuito;
    private String codigo_subcircuito;
    private String descripcion;
    private Circuitos id_circuito;
    
     public Subcircuito() {
    }

    public Subcircuito(int id_subcircuito, String codigo_subcircuito, String descripcion, Circuitos id_circuito) {
        this.id_subcircuito = id_subcircuito;
        this.codigo_subcircuito = codigo_subcircuito;
        this.descripcion = descripcion;
        this.id_circuito = id_circuito;
    }

    public int getId_subcircuito() {
        return id_subcircuito;
    }

    public void setId_subcircuito(int id_subcircuito) {
        this.id_subcircuito = id_subcircuito;
    }

    public String getCodigo_subcircuito() {
        return codigo_subcircuito;
    }

    public void setCodigo_subcircuito(String codigo_subcircuito) {
        this.codigo_subcircuito = codigo_subcircuito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Circuitos getId_circuito() {
        return id_circuito;
    }

    public void setId_circuito(Circuitos id_circuito) {
        this.id_circuito = id_circuito;
    }

    
}
