/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.entidades;

import java.util.Date;

/**
 *
 * @author oscunach jose duchi u.
 */
public class Devif {
    private int ord_;
    private String canton;
    private String codigo_subcircuito;   
    private String distrito;
    private String circuito;
    private String subcircuito;
    private String direccion_infraccion;
    private String sector;
    private String zona;
    private Date fecha_registro;
    private String hora_registro;
    private Date  fecha_infraccion;
    private String mes_infraccion;
    private String dia_infraccion;
    private String hora_infraccion;
    private String rango_hora_infraccion;
    private String caso;
    private String numero_caso;
    private int caso_reincidentes;
    private String origen_informacion;
    private String tipo_violencia;
    private String causa_violencia;
    private String descripcion_hechos;
    private int cedula_victima;
    private String apellidos_nombres_victima;
    private String sexo_victima;
    private int edad_victima;
    private String rango_edad_victima;
    private String estado_civil_victima;
    private String nacionalidad_victima;
    private String profesion_ocupacion_victima;
    private String instruccion_victima;
    private String numero_telefonico_victima;
    private String novedad_denunciante;
    private String apellidos_nombres_agresor;
    private String cedula_agresor;
    private String sexo_agresor;
    private int edad_agresor;
    private String rango_edad_agresor;
    private String estado_civil_agresor;
    private String nacionalidad_agresor;
    private String profesion_agresor;
    private String instruccion_agresor;
    private String numero_telefonico_agresor;
    private String parentezco_victima;
    private String novedad_agresor;
    private String tipo_operativo;
    private String actividad_operativa;
    private int id;
    
    
     /*
     ** Constructor
     */

    public Devif() {
    }

    public Devif(int ord_, String canton, String codigo_subcircuito, String distrito, String circuito, String subcircuito, String direccion_infraccion, String sector, String zona, Date fecha_registro, String hora_registro, Date fecha_infraccion, String mes_infraccion, String dia_infraccion, String hora_infraccion, String rango_hora_infraccion, String caso, String numero_caso, int caso_reincidentes, String origen_informacion, String tipo_violencia, String causa_violencia, String descripcion_hechos, int cedula_victima, String apellidos_nombres_victima, String sexo_victima, int edad_victima, String rango_edad_victima, String estado_civil_victima, String nacionalidad_victima, String profesion_ocupacion_victima, String instruccion_victima, String numero_telefonico_victima, String novedad_denunciante, String apellidos_nombres_agresor, String cedula_agresor, String sexo_agresor, int edad_agresor, String rango_edad_agresor, String estado_civil_agresor, String nacionalidad_agresor, String profesion_agresor, String instruccion_agresor, String numero_telefonico_agresor, String parentezco_victima, String novedad_agresor, String tipo_operativo, String actividad_operativa, int id) {
        this.ord_ = ord_;
        this.canton = canton;
        this.codigo_subcircuito = codigo_subcircuito;
        this.distrito = distrito;
        this.circuito = circuito;
        this.subcircuito = subcircuito;
        this.direccion_infraccion = direccion_infraccion;
        this.sector = sector;
        this.zona = zona;
        this.fecha_registro = fecha_registro;
        this.hora_registro = hora_registro;
        this.fecha_infraccion = fecha_infraccion;
        this.mes_infraccion = mes_infraccion;
        this.dia_infraccion = dia_infraccion;
        this.hora_infraccion = hora_infraccion;
        this.rango_hora_infraccion = rango_hora_infraccion;
        this.caso = caso;
        this.numero_caso = numero_caso;
        this.caso_reincidentes = caso_reincidentes;
        this.origen_informacion = origen_informacion;
        this.tipo_violencia = tipo_violencia;
        this.causa_violencia = causa_violencia;
        this.descripcion_hechos = descripcion_hechos;
        this.cedula_victima = cedula_victima;
        this.apellidos_nombres_victima = apellidos_nombres_victima;
        this.sexo_victima = sexo_victima;
        this.edad_victima = edad_victima;
        this.rango_edad_victima = rango_edad_victima;
        this.estado_civil_victima = estado_civil_victima;
        this.nacionalidad_victima = nacionalidad_victima;
        this.profesion_ocupacion_victima = profesion_ocupacion_victima;
        this.instruccion_victima = instruccion_victima;
        this.numero_telefonico_victima = numero_telefonico_victima;
        this.novedad_denunciante = novedad_denunciante;
        this.apellidos_nombres_agresor = apellidos_nombres_agresor;
        this.cedula_agresor = cedula_agresor;
        this.sexo_agresor = sexo_agresor;
        this.edad_agresor = edad_agresor;
        this.rango_edad_agresor = rango_edad_agresor;
        this.estado_civil_agresor = estado_civil_agresor;
        this.nacionalidad_agresor = nacionalidad_agresor;
        this.profesion_agresor = profesion_agresor;
        this.instruccion_agresor = instruccion_agresor;
        this.numero_telefonico_agresor = numero_telefonico_agresor;
        this.parentezco_victima = parentezco_victima;
        this.novedad_agresor = novedad_agresor;
        this.tipo_operativo = tipo_operativo;
        this.actividad_operativa = actividad_operativa;
        this.id = id;
    }
    
    
    
    /*
    metodos get y set
    */

    public int getOrd() {
        return ord_;
    }

    public void setOrd(int ord) {
        this.ord_ = ord;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getCodigo_subcircuito() {
        return codigo_subcircuito;
    }

    public void setCodigo_subcircuito(String codigo_subcircuito) {
        this.codigo_subcircuito = codigo_subcircuito;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
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

    public String getDireccion_infraccion() {
        return direccion_infraccion;
    }

    public void setDireccion_infraccion(String direccion_infraccion) {
        this.direccion_infraccion = direccion_infraccion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_infraccion() {
        return fecha_infraccion;
    }

    public void setFecha_infraccion(Date fecha_infraccion) {
        this.fecha_infraccion = fecha_infraccion;
    }

    public String getHora_registro() {
        return hora_registro;
    }

    public void setHora_registro(String hora_registro) {
        this.hora_registro = hora_registro;
    }

    public String getMes_infraccion() {
        return mes_infraccion;
    }

    public void setMes_infraccion(String mes_infraccion) {
        this.mes_infraccion = mes_infraccion;
    }

    public String getDia_infraccion() {
        return dia_infraccion;
    }

    public void setDia_infraccion(String dia_infraccion) {
        this.dia_infraccion = dia_infraccion;
    }

    public String getHora_infraccion() {
        return hora_infraccion;
    }

    public void setHora_infraccion(String hora_infraccion) {
        this.hora_infraccion = hora_infraccion;
    }

    public String getRango_hora_infraccion() {
        return rango_hora_infraccion;
    }

    public void setRango_hora_infraccion(String rango_hora_infraccion) {
        this.rango_hora_infraccion = rango_hora_infraccion;
    }

    public String getCaso() {
        return caso;
    }

    public void setCaso(String caso) {
        this.caso = caso;
    }

    public String getNumero_caso() {
        return numero_caso;
    }

    public void setNumero_caso(String numero_caso) {
        this.numero_caso = numero_caso;
    }

    public int getCaso_reincidentes() {
        return caso_reincidentes;
    }

    public void setCaso_reincidentes(int caso_reincidentes) {
        this.caso_reincidentes = caso_reincidentes;
    }

    public String getOrigen_informacion() {
        return origen_informacion;
    }

    public void setOrigen_informacion(String origen_informacion) {
        this.origen_informacion = origen_informacion;
    }

    public String getTipo_violencia() {
        return tipo_violencia;
    }

    public void setTipo_violencia(String tipo_violencia) {
        this.tipo_violencia = tipo_violencia;
    }

    public String getCausa_violencia() {
        return causa_violencia;
    }

    public void setCausa_violencia(String causa_violencia) {
        this.causa_violencia = causa_violencia;
    }

    public String getDescripcion_hechos() {
        return descripcion_hechos;
    }

    public void setDescripcion_hechos(String descripcion_hechos) {
        this.descripcion_hechos = descripcion_hechos;
    }

    public int getCedula_victima() {
        return cedula_victima;
    }

    public void setCedula_victima(int cedula_victima) {
        this.cedula_victima = cedula_victima;
    }

    public String getApellidos_nombres_victima() {
        return apellidos_nombres_victima;
    }

    public void setApellidos_nombres_victima(String apellidos_nombres_victima) {
        this.apellidos_nombres_victima = apellidos_nombres_victima;
    }

    public String getSexo_victima() {
        return sexo_victima;
    }

    public void setSexo_victima(String sexo_victima) {
        this.sexo_victima = sexo_victima;
    }

    public int getEdad_victima() {
        return edad_victima;
    }

    public void setEdad_victima(int edad_victima) {
        this.edad_victima = edad_victima;
    }

    public String getRango_edad_victima() {
        return rango_edad_victima;
    }

    public void setRango_edad_victima(String rango_edad_victima) {
        this.rango_edad_victima = rango_edad_victima;
    }

    public String getEstado_civil_victima() {
        return estado_civil_victima;
    }

    public void setEstado_civil_victima(String estado_civil_victima) {
        this.estado_civil_victima = estado_civil_victima;
    }

    public String getNacionalidad_victima() {
        return nacionalidad_victima;
    }

    public void setNacionalidad_victima(String nacionalidad_victima) {
        this.nacionalidad_victima = nacionalidad_victima;
    }

    public String getProfesion_ocupacion_victima() {
        return profesion_ocupacion_victima;
    }

    public void setProfesion_ocupacion_victima(String profesion_ocupacion_victima) {
        this.profesion_ocupacion_victima = profesion_ocupacion_victima;
    }

    public String getInstruccion_victima() {
        return instruccion_victima;
    }

    public void setInstruccion_victima(String instruccion_victima) {
        this.instruccion_victima = instruccion_victima;
    }

    public String getNumero_telefonico_victima() {
        return numero_telefonico_victima;
    }

    public void setNumero_telefonico_victima(String numero_telefonico_victima) {
        this.numero_telefonico_victima = numero_telefonico_victima;
    }

    public String getNovedad_denunciante() {
        return novedad_denunciante;
    }

    public void setNovedad_denunciante(String novedad_denunciante) {
        this.novedad_denunciante = novedad_denunciante;
    }

    public String getApellidos_nombres_agresor() {
        return apellidos_nombres_agresor;
    }

    public void setApellidos_nombres_agresor(String apellidos_nombres_agresor) {
        this.apellidos_nombres_agresor = apellidos_nombres_agresor;
    }

    public String getCedula_agresor() {
        return cedula_agresor;
    }

    public void setCedula_agresor(String cedula_agresor) {
        this.cedula_agresor = cedula_agresor;
    }

    public String getSexo_agresor() {
        return sexo_agresor;
    }

    public void setSexo_agresor(String sexo_agresor) {
        this.sexo_agresor = sexo_agresor;
    }

    public int getEdad_agresor() {
        return edad_agresor;
    }

    public void setEdad_agresor(int edad_agresor) {
        this.edad_agresor = edad_agresor;
    }

    public String getRango_edad_agresor() {
        return rango_edad_agresor;
    }

    public void setRango_edad_agresor(String rango_edad_agresor) {
        this.rango_edad_agresor = rango_edad_agresor;
    }

    public String getEstado_civil_agresor() {
        return estado_civil_agresor;
    }

    public void setEstado_civil_agresor(String estado_civil_agresor) {
        this.estado_civil_agresor = estado_civil_agresor;
    }

    public String getNacionalidad_agresor() {
        return nacionalidad_agresor;
    }

    public void setNacionalidad_agresor(String nacionalidad_agresor) {
        this.nacionalidad_agresor = nacionalidad_agresor;
    }

    public String getProfesion_agresor() {
        return profesion_agresor;
    }

    public void setProfesion_agresor(String profesion_agresor) {
        this.profesion_agresor = profesion_agresor;
    }

    public String getInstruccion_agresor() {
        return instruccion_agresor;
    }

    public void setInstruccion_agresor(String instruccion_agresor) {
        this.instruccion_agresor = instruccion_agresor;
    }

    public String getNumero_telefonico_agresor() {
        return numero_telefonico_agresor;
    }

    public void setNumero_telefonico_agresor(String numero_telefonico_agresor) {
        this.numero_telefonico_agresor = numero_telefonico_agresor;
    }

    public String getParentezco_victima() {
        return parentezco_victima;
    }

    public void setParentezco_victima(String parentezco_victima) {
        this.parentezco_victima = parentezco_victima;
    }

    public String getNovedad_agresor() {
        return novedad_agresor;
    }

    public void setNovedad_agresor(String novedad_agresor) {
        this.novedad_agresor = novedad_agresor;
    }

    public String getTipo_operativo() {
        return tipo_operativo;
    }

    public void setTipo_operativo(String tipo_operativo) {
        this.tipo_operativo = tipo_operativo;
    }

    public String getActividad_operativa() {
        return actividad_operativa;
    }

    public void setActividad_operativa(String actividad_operativa) {
        this.actividad_operativa = actividad_operativa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
           
    
    
}
