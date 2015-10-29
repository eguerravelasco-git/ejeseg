/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.entidades;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @ Edwin Maigua
 */
public class FichaVif {

    private int id_ficha;
    private String nombres_victima;
    private String apellidos_victima;
    private String sexo_victima;
    private String direccion_victima;
    private String domiciliado_victima;
    private int edad_victima;
    private String estado_civil_victima;
    private String nivel_instruccion_victima;
    private String ocupacion_victima;
    private String sexo_agresor;
    private String direccion_agresor;
    private int edad_agresor;
    private String domiciliado_agresor;
    private String estado_civil_agresor;
    private String nivel_instruccion_agresor;
    private String ocupaccion_agresor;
    private String parentesco_victima_agresor;
    private int numero_hijos_comun;
    private String tiempo_convivencia;
    private String lugar_agresion;
    private String tipo_violencia;
    private Date fecha_agresion;
    private Time hora_agresion;
    private String reincidencia_agresion;
    private String objeto_agresion;
    private String estado_conciencia_agresor;
    private String direccion_agresion;
    private Double x;
    private Double y;
    private String circuito;
    private String codigo_circuito;
    private String subcircuito;
    private String codigo_subcircuito;
    private Date fecha_denuncia;
    private String denunciante;
    private String medidas_amparo;
    private String sentencia;
    private String apelacion;
    private String boletas_anteriores;
    private String observaciones;
    private String boletas_remision;
    private String agresor;

//CONTRUCTOR 
    public FichaVif() {
    }

    public FichaVif(int id_ficha, String nombres_victima, String apellidos_victima, String sexo_victima, String direccion_victima, String domiciliado_victima, int edad_victima, String estado_civil_victima, String nivel_instruccion_victima, String ocupacion_victima, String sexo_agresor, String direccion_agresor, int edad_agresor, String domiciliado_agresor, String estado_civil_agresor, String nivel_instruccion_agresor, String ocupaccion_agresor, String parentesco_victima_agresor, int numero_hijos_comun, String tiempo_convivencia, String lugar_agresion, String tipo_violencia, Date fecha_agresion, Time hora_agresion, String reincidencia_agresion, String objeto_agresion, String estado_conciencia_agresor, String direccion_agresion, Double x, Double y, String circuito, String codigo_circuito, String subcircuito, String codigo_subcircuito, Date fecha_denuncia, String denunciante, String medidas_amparo, String sentencia, String apelacion, String boletas_anteriores, String observaciones, String boletas_remision, String agresor) {
        this.id_ficha = id_ficha;
        this.nombres_victima = nombres_victima;
        this.apellidos_victima = apellidos_victima;
        this.sexo_victima = sexo_victima;
        this.direccion_victima = direccion_victima;
        this.domiciliado_victima = domiciliado_victima;
        this.edad_victima = edad_victima;
        this.estado_civil_victima = estado_civil_victima;
        this.nivel_instruccion_victima = nivel_instruccion_victima;
        this.ocupacion_victima = ocupacion_victima;
        this.sexo_agresor = sexo_agresor;
        this.direccion_agresor = direccion_agresor;
        this.edad_agresor = edad_agresor;
        this.domiciliado_agresor = domiciliado_agresor;
        this.estado_civil_agresor = estado_civil_agresor;
        this.nivel_instruccion_agresor = nivel_instruccion_agresor;
        this.ocupaccion_agresor = ocupaccion_agresor;
        this.parentesco_victima_agresor = parentesco_victima_agresor;
        this.numero_hijos_comun = numero_hijos_comun;
        this.tiempo_convivencia = tiempo_convivencia;
        this.lugar_agresion = lugar_agresion;
        this.tipo_violencia = tipo_violencia;
        this.fecha_agresion = fecha_agresion;
        this.hora_agresion = hora_agresion;
        this.reincidencia_agresion = reincidencia_agresion;
        this.objeto_agresion = objeto_agresion;
        this.estado_conciencia_agresor = estado_conciencia_agresor;
        this.direccion_agresion = direccion_agresion;
        this.x = x;
        this.y = y;
        this.circuito = circuito;
        this.codigo_circuito = codigo_circuito;
        this.subcircuito = subcircuito;
        this.codigo_subcircuito = codigo_subcircuito;
        this.fecha_denuncia = fecha_denuncia;
        this.denunciante = denunciante;
        this.medidas_amparo = medidas_amparo;
        this.sentencia = sentencia;
        this.apelacion = apelacion;
        this.boletas_anteriores = boletas_anteriores;
        this.observaciones = observaciones;
        this.boletas_remision = boletas_remision;
        this.agresor = agresor;
    }

    public String getAgresor() {
        return agresor;
    }

    public void setAgresor(String agresor) {
        this.agresor = agresor;
    }

    public int getId_ficha() {
        return id_ficha;
    }

    public void setId_ficha(int id_ficha) {
        this.id_ficha = id_ficha;
    }

    public String getNombres_victima() {
        return nombres_victima;
    }

    public void setNombres_victima(String nombres_victima) {
        this.nombres_victima = nombres_victima;
    }

    public String getApellidos_victima() {
        return apellidos_victima;
    }

    public void setApellidos_victima(String apellidos_victima) {
        this.apellidos_victima = apellidos_victima;
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

    public int getEdad_agresor() {
        return edad_agresor;
    }

    public void setEdad_agresor(int edad_agresor) {
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

    public String getOcupaccion_agresor() {
        return ocupaccion_agresor;
    }

    public void setOcupaccion_agresor(String ocupaccion_agresor) {
        this.ocupaccion_agresor = ocupaccion_agresor;
    }

    public String getParentesco_victima_agresor() {
        return parentesco_victima_agresor;
    }

    public void setParentesco_victima_agresor(String parentesco_victima_agresor) {
        this.parentesco_victima_agresor = parentesco_victima_agresor;
    }

    public int getNumero_hijos_comun() {
        return numero_hijos_comun;
    }

    public void setNumero_hijos_comun(int numero_hijos_comun) {
        this.numero_hijos_comun = numero_hijos_comun;
    }

    public String getTiempo_convivencia() {
        return tiempo_convivencia;
    }

    public void setTiempo_convivencia(String tiempo_convivencia) {
        this.tiempo_convivencia = tiempo_convivencia;
    }

    public String getLugar_agresion() {
        return lugar_agresion;
    }

    public void setLugar_agresion(String lugar_agresion) {
        this.lugar_agresion = lugar_agresion;
    }

    public String getTipo_violencia() {
        return tipo_violencia;
    }

    public void setTipo_violencia(String tipo_violencia) {
        this.tipo_violencia = tipo_violencia;
    }

    public Date getFecha_agresion() {
        return fecha_agresion;
    }

    public void setFecha_agresion(Date fecha_agresion) {
        this.fecha_agresion = fecha_agresion;
    }

    public Time getHora_agresion() {
        return hora_agresion;
    }

    public void setHora_agresion(Time hora_agresion) {
        this.hora_agresion = hora_agresion;
    }

    public String getReincidencia_agresion() {
        return reincidencia_agresion;
    }

    public void setReincidencia_agresion(String reincidencia_agresion) {
        this.reincidencia_agresion = reincidencia_agresion;
    }

    public String getObjeto_agresion() {
        return objeto_agresion;
    }

    public void setObjeto_agresion(String objeto_agresion) {
        this.objeto_agresion = objeto_agresion;
    }

    public String getEstado_conciencia_agresor() {
        return estado_conciencia_agresor;
    }

    public void setEstado_conciencia_agresor(String estado_conciencia_agresor) {
        this.estado_conciencia_agresor = estado_conciencia_agresor;
    }

    public String getDireccion_agresion() {
        return direccion_agresion;
    }

    public void setDireccion_agresion(String direccion_agresion) {
        this.direccion_agresion = direccion_agresion;
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

    public String getCodigo_circuito() {
        return codigo_circuito;
    }

    public void setCodigo_circuito(String codigo_circuito) {
        this.codigo_circuito = codigo_circuito;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getBoletas_remision() {
        return boletas_remision;
    }

    public void setBoletas_remision(String boletas_remision) {
        this.boletas_remision = boletas_remision;
    }

}
