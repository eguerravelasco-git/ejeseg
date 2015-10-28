/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.entidades;

import java.util.Date;

/**
 *
 * @author oscunach
 */
public class VifRural {

    private Date fecha_denuncia;
    private String denunciante;
    private String victima;
    private String sexo_victima;
    private String direccion_victima;
    private Double x;
    private Double y;
    private String circuito;
    private String subcircuito;
    private String codigo_subcircuito;
    private String domiciliado_victima;
    private int edad_victima;
    private String estado_civil_victima;
    private String nivel_instruccion_victima;
    private String ocupacion_victima;
    private String agresor;
    private String sexo_agresor;
    private String direccion_agresor;
    private String edad_agresor;
    private String domiciliado_agresor;
    private String estado_civil_agresor;
    private String nivel_instruccion_agresor;
    private String ocupacion_agresor;
    private String parentesco;
    private String hijos_comun;
    private String lugar_de_agresion;
    private String tipo_de_violencia;
    private String fecha_agresion;
    private String hora_de_agresion;
    private String medidas_de_amparo;
    private String sentencia;
    private String apelacion;
    private String boletas_anteriores;
    private String observaciones;
    private String boletas_de_remision;
    private int id;

    public VifRural() {
    }

    public VifRural(Date fecha_denuncia, String denunciante, String victima, String sexo_victima, String direccion_victima, Double x, Double y, String circuito, String subcircuito, String codigo_subcircuito, String domiciliado_victima, int edad_victima, String estado_civil_victima, String nivel_instruccion_victima, String ocupacion_victima, String agresor, String sexo_agresor, String direccion_agresor, String edad_agresor, String domiciliado_agresor, String estado_civil_agresor, String nivel_instruccion_agresor, String ocupacion_agresor, String parentesco, String hijos_comun, String lugar_de_agresion, String tipo_de_violencia, String fecha_agresion, String hora_de_agresion, String medidas_de_amparo, String sentencia, String apelacion, String boletas_anteriores, String observaciones, String boletas_de_remision, int id) {
        this.fecha_denuncia = fecha_denuncia;
        this.denunciante = denunciante;
        this.victima = victima;
        this.sexo_victima = sexo_victima;
        this.direccion_victima = direccion_victima;
        this.x = x;
        this.y = y;
        this.circuito = circuito;
        this.subcircuito = subcircuito;
        this.codigo_subcircuito = codigo_subcircuito;
        this.domiciliado_victima = domiciliado_victima;
        this.edad_victima = edad_victima;
        this.estado_civil_victima = estado_civil_victima;
        this.nivel_instruccion_victima = nivel_instruccion_victima;
        this.ocupacion_victima = ocupacion_victima;
        this.agresor = agresor;
        this.sexo_agresor = sexo_agresor;
        this.direccion_agresor = direccion_agresor;
        this.edad_agresor = edad_agresor;
        this.domiciliado_agresor = domiciliado_agresor;
        this.estado_civil_agresor = estado_civil_agresor;
        this.nivel_instruccion_agresor = nivel_instruccion_agresor;
        this.ocupacion_agresor = ocupacion_agresor;
        this.parentesco = parentesco;
        this.hijos_comun = hijos_comun;
        this.lugar_de_agresion = lugar_de_agresion;
        this.tipo_de_violencia = tipo_de_violencia;
        this.fecha_agresion = fecha_agresion;
        this.hora_de_agresion = hora_de_agresion;
        this.medidas_de_amparo = medidas_de_amparo;
        this.sentencia = sentencia;
        this.apelacion = apelacion;
        this.boletas_anteriores = boletas_anteriores;
        this.observaciones = observaciones;
        this.boletas_de_remision = boletas_de_remision;
        this.id = id;
    }

    public Date getFecha_denuncia() {
        return fecha_denuncia;
    }

    public void setFecha_denuncia(Date fecha_denuncia) {
        this.fecha_denuncia = fecha_denuncia;
    }

    public String getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(String denunciante) {
        this.denunciante = denunciante;
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

    public String getDireccion_victima() {
        return direccion_victima;
    }

    public void setDireccion_victima(String direccion_victima) {
        this.direccion_victima = direccion_victima;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public String getSubcircuito() {
        return subcircuito;
    }

    public void setSubcircuito(String subcircuito) {
        this.subcircuito = subcircuito;
    }

    public String getCodigo_subcircuito() {
        return codigo_subcircuito;
    }

    public void setCodigo_subcircuito(String codigo_subcircuito) {
        this.codigo_subcircuito = codigo_subcircuito;
    }

    public String getDomiciliado_victima() {
        return domiciliado_victima;
    }

    public void setDomiciliado_victima(String domiciliado_victima) {
        this.domiciliado_victima = domiciliado_victima;
    }

    public int getEdad_victima() {
        return edad_victima;
    }

    public void setEdad_victima(int edad_victima) {
        this.edad_victima = edad_victima;
    }

    public String getEstado_civil_victima() {
        return estado_civil_victima;
    }

    public void setEstado_civil_victima(String estado_civil_victima) {
        this.estado_civil_victima = estado_civil_victima;
    }

    public String getNivel_instruccion_victima() {
        return nivel_instruccion_victima;
    }

    public void setNivel_instruccion_victima(String nivel_instruccion_victima) {
        this.nivel_instruccion_victima = nivel_instruccion_victima;
    }

    public String getOcupacion_victima() {
        return ocupacion_victima;
    }

    public void setOcupacion_victima(String ocupacion_victima) {
        this.ocupacion_victima = ocupacion_victima;
    }

    public String getAgresor() {
        return agresor;
    }

    public void setAgresor(String agresor) {
        this.agresor = agresor;
    }

    public String getSexo_agresor() {
        return sexo_agresor;
    }

    public void setSexo_agresor(String sexo_agresor) {
        this.sexo_agresor = sexo_agresor;
    }

    public String getDireccion_agresor() {
        return direccion_agresor;
    }

    public void setDireccion_agresor(String direccion_agresor) {
        this.direccion_agresor = direccion_agresor;
    }

    public String getEdad_agresor() {
        return edad_agresor;
    }

    public void setEdad_agresor(String edad_agresor) {
        this.edad_agresor = edad_agresor;
    }

    public String getDomiciliado_agresor() {
        return domiciliado_agresor;
    }

    public void setDomiciliado_agresor(String domiciliado_agresor) {
        this.domiciliado_agresor = domiciliado_agresor;
    }

    public String getEstado_civil_agresor() {
        return estado_civil_agresor;
    }

    public void setEstado_civil_agresor(String estado_civil_agresor) {
        this.estado_civil_agresor = estado_civil_agresor;
    }

    public String getNivel_instruccion_agresor() {
        return nivel_instruccion_agresor;
    }

    public void setNivel_instruccion_agresor(String nivel_instruccion_agresor) {
        this.nivel_instruccion_agresor = nivel_instruccion_agresor;
    }

    public String getOcupacion_agresor() {
        return ocupacion_agresor;
    }

    public void setOcupacion_agresor(String ocupacion_agresor) {
        this.ocupacion_agresor = ocupacion_agresor;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getHijos_comun() {
        return hijos_comun;
    }

    public void setHijos_comun(String hijos_comun) {
        this.hijos_comun = hijos_comun;
    }

    public String getLugar_de_agresion() {
        return lugar_de_agresion;
    }

    public void setLugar_de_agresion(String lugar_de_agresion) {
        this.lugar_de_agresion = lugar_de_agresion;
    }

    public String getTipo_de_violencia() {
        return tipo_de_violencia;
    }

    public void setTipo_de_violencia(String tipo_de_violencia) {
        this.tipo_de_violencia = tipo_de_violencia;
    }

    public String getFecha_agresion() {
        return fecha_agresion;
    }

    public void setFecha_agresion(String fecha_agresion) {
        this.fecha_agresion = fecha_agresion;
    }

    public String getHora_de_agresion() {
        return hora_de_agresion;
    }

    public void setHora_de_agresion(String hora_de_agresion) {
        this.hora_de_agresion = hora_de_agresion;
    }

    public String getMedidas_de_amparo() {
        return medidas_de_amparo;
    }

    public void setMedidas_de_amparo(String medidas_de_amparo) {
        this.medidas_de_amparo = medidas_de_amparo;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getBoletas_de_remision() {
        return boletas_de_remision;
    }

    public void setBoletas_de_remision(String boletas_de_remision) {
        this.boletas_de_remision = boletas_de_remision;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
