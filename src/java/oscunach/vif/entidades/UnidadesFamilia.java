/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.entidades;

import java.util.Date;

/**
 *
 * @author Pc-03
 */
public class UnidadesFamilia {

    private int numero_causa;
    private Date fecha_denuncia;
    private String sexo_agresor;
    private String sexo_victima;
    private String barrio_agresor;
    private String barrio_agredida;
    private String edad_agresor;
    private String edad_victima;
    private String instruccion_agresor;
    private String instrucc_victima;
    private String parentesco;
    private double numero_hijos;
    private String lugar_agrecion;
    private double x;
    private double y;
    private String subcircuit;
    private String circuito;
    private String tipo_violencia;
    private String fecha_agresion;
    private String medidas_amparo;
    private String sentencia;
    private String apelacion;
    private String boletas_anteriores;
    private String boletas_remision;
    private String observacio;
    private int pk;

    public UnidadesFamilia() {
    }

    public UnidadesFamilia(int numero_causa, Date fecha_denuncia, String sexo_agresor, String sexo_victima, String barrio_agresor, String barrio_agredida, String edad_agresor, String edad_victima, String instruccion_agresor, String instrucc_victima, String parentesco, double numero_hijos, String lugar_agrecion, double x, double y, String subcircuit, String circuito, String tipo_violencia, String fecha_agresion, String medidas_amparo, String sentencia, String apelacion, String boletas_anteriores, String boletas_remision, String observacio, int pk) {
        this.numero_causa = numero_causa;
        this.fecha_denuncia = fecha_denuncia;
        this.sexo_agresor = sexo_agresor;
        this.sexo_victima = sexo_victima;
        this.barrio_agresor = barrio_agresor;
        this.barrio_agredida = barrio_agredida;
        this.edad_agresor = edad_agresor;
        this.edad_victima = edad_victima;
        this.instruccion_agresor = instruccion_agresor;
        this.instrucc_victima = instrucc_victima;
        this.parentesco = parentesco;
        this.numero_hijos = numero_hijos;
        this.lugar_agrecion = lugar_agrecion;
        this.x = x;
        this.y = y;
        this.subcircuit = subcircuit;
        this.circuito = circuito;
        this.tipo_violencia = tipo_violencia;
        this.fecha_agresion = fecha_agresion;
        this.medidas_amparo = medidas_amparo;
        this.sentencia = sentencia;
        this.apelacion = apelacion;
        this.boletas_anteriores = boletas_anteriores;
        this.boletas_remision = boletas_remision;
        this.observacio = observacio;
        this.pk = pk;
    }

    public int getNumero_causa() {
        return numero_causa;
    }

    public void setNumero_causa(int numero_causa) {
        this.numero_causa = numero_causa;
    }

    public Date getFecha_denuncia() {
        return fecha_denuncia;
    }

    public void setFecha_denuncia(Date fecha_denuncia) {
        this.fecha_denuncia = fecha_denuncia;
    }

    public String getSexo_agresor() {
        return sexo_agresor;
    }

    public void setSexo_agresor(String sexo_agresor) {
        this.sexo_agresor = sexo_agresor;
    }

    public String getSexo_victima() {
        return sexo_victima;
    }

    public void setSexo_victima(String sexo_victima) {
        this.sexo_victima = sexo_victima;
    }

    public String getBarrio_agresor() {
        return barrio_agresor;
    }

    public void setBarrio_agresor(String barrio_agresor) {
        this.barrio_agresor = barrio_agresor;
    }

    public String getBarrio_agredida() {
        return barrio_agredida;
    }

    public void setBarrio_agredida(String barrio_agredida) {
        this.barrio_agredida = barrio_agredida;
    }

    public String getEdad_agresor() {
        return edad_agresor;
    }

    public void setEdad_agresor(String edad_agresor) {
        this.edad_agresor = edad_agresor;
    }

    public String getEdad_victima() {
        return edad_victima;
    }

    public void setEdad_victima(String edad_victima) {
        this.edad_victima = edad_victima;
    }

    public String getInstruccion_agresor() {
        return instruccion_agresor;
    }

    public void setInstruccion_agresor(String instruccion_agresor) {
        this.instruccion_agresor = instruccion_agresor;
    }

    public String getInstrucc_victima() {
        return instrucc_victima;
    }

    public void setInstrucc_victima(String instrucc_victima) {
        this.instrucc_victima = instrucc_victima;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public double getNumero_hijos() {
        return numero_hijos;
    }

    public void setNumero_hijos(double numero_hijos) {
        this.numero_hijos = numero_hijos;
    }

    public String getLugar_agrecion() {
        return lugar_agrecion;
    }

    public void setLugar_agrecion(String lugar_agrecion) {
        this.lugar_agrecion = lugar_agrecion;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getSubcircuit() {
        return subcircuit;
    }

    public void setSubcircuit(String subcircuit) {
        this.subcircuit = subcircuit;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public String getTipo_violencia() {
        return tipo_violencia;
    }

    public void setTipo_violencia(String tipo_violencia) {
        this.tipo_violencia = tipo_violencia;
    }

    public String getFecha_agresion() {
        return fecha_agresion;
    }

    public void setFecha_agresion(String fecha_agresion) {
        this.fecha_agresion = fecha_agresion;
    }

    public String getMedidas_amparo() {
        return medidas_amparo;
    }

    public void setMedidas_amparo(String medidas_amparo) {
        this.medidas_amparo = medidas_amparo;
    }

    public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }

    public String getApelacion() {
        return apelacion;
    }

    public void setApelacion(String apelacion) {
        this.apelacion = apelacion;
    }

    public String getBoletas_anteriores() {
        return boletas_anteriores;
    }

    public void setBoletas_anteriores(String boletas_anteriores) {
        this.boletas_anteriores = boletas_anteriores;
    }

    public String getBoletas_remision() {
        return boletas_remision;
    }

    public void setBoletas_remision(String boletas_remision) {
        this.boletas_remision = boletas_remision;
    }

    public String getObservacio() {
        return observacio;
    }

    public void setObservacio(String observacio) {
        this.observacio = observacio;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }
    
    

}
