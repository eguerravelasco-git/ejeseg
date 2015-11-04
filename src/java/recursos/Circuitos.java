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
public class Circuitos {
    
    
  private int  id_circuito;
  private String codigo_circuito;
  private String descripcion;

    public Circuitos() {
    }

    public Circuitos(int id_circuito, String codigo_circuito, String descripcion) {
        this.id_circuito = id_circuito;
        this.codigo_circuito = codigo_circuito;
        this.descripcion = descripcion;
    }

    public int getId_circuito() {
        return id_circuito;
    }

    public void setId_circuito(int id_circuito) {
        this.id_circuito = id_circuito;
    }

    public String getCodigo_circuito() {
        return codigo_circuito;
    }

    public void setCodigo_circuito(String codigo_circuito) {
        this.codigo_circuito = codigo_circuito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
  
    
}
