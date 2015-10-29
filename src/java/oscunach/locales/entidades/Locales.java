/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.locales.entidades;

/**
 *
 * @author servidor
 */
public class Locales {

    private int codigo;
    private int carga_trabajo;
    private int grupo;
    private String estado;
    private String provincia;
    private String canton;
    private int parroquia;
    private int zona;
    private int sector;
    private int manzana;
    private String formulario;
    private String direccion;
    private String barrio;
    private double x;
    private double y;
    private String circuito;
    private String codigo_circuito;
    private String subcircuito;
    private String codigo_subcircuito;
    private String razon_social;
    private String actividad_economica;
    private String tipo_establecimiento;
    private int categoria;
    private String nombre_del;
    private String cc;
    private String licencia_municipal;
    private String licencia_bomberos;
    private String licencia_msp;
    private String licencia_mi;
    private String licencia_mt;
    private String ruc_rise;
    private String apertura_horario_diurno;
    private String cierre_horario_diurno;
    private String apertura_horario_nocturno;
    private String cierre_horario_nocturno;
    private String observaciones_jornada_laboral;
    private String terrenos_valdios;
    private String espacios_abiertos;
    private String especificaciones_entorno_externo;
    private String visualizacion;
    private String iluminacion;
    private String entradas_salidas_emergencia;
    private String recodos_muretes;
    private String limpieza_local;
    private String senializacion;
    private String extintor_incendios;
    private String obsrv_sistemas_emergencia;
    private String sistema_seguridad;
    private String tipo;
    private int establecimiento_local;
    private int barrio_comunitarias;
    private String camaras_ec911;
    private String obsrvc_sistema_seguridad;
    private String inst_educativa;
    private int distancia_ie;
    private String direccion_ie;
    private String obsrvc_ie;
    private String digitador;
    private String observaciones_generales;

    public Locales() {
    }

    public Locales(int codigo, int carga_trabajo, int grupo, String estado, String provincia, String canton, int parroquia, int zona, int sector, int manzana, String formulario, String direccion, String barrio, double x, double y, String circuito, String codigo_circuito, String subcircuito, String codigo_subcircuito, String razon_social, String actividad_economica, String tipo_establecimiento, int categoria, String nombre_del, String cc, String licencia_municipal, String licencia_bomberos, String licencia_msp, String licencia_mi, String licencia_mt, String ruc_rise, String apertura_horario_diurno, String cierre_horario_diurno, String apertura_horario_nocturno, String cierre_horario_nocturno, String observaciones_jornada_laboral, String terrenos_valdios, String espacios_abiertos, String especificaciones_entorno_externo, String visualizacion, String iluminacion, String entradas_salidas_emergencia, String recodos_muretes, String limpieza_local, String senializacion, String extintor_incendios, String obsrv_sistemas_emergencia, String sistema_seguridad, String tipo, int establecimiento_local, int barrio_comunitarias, String camaras_ec911, String obsrvc_sistema_seguridad, String inst_educativa, int distancia_ie, String direccion_ie, String obsrvc_ie, String digitador, String observaciones_generales) {
        this.codigo = codigo;
        this.carga_trabajo = carga_trabajo;
        this.grupo = grupo;
        this.estado = estado;
        this.provincia = provincia;
        this.canton = canton;
        this.parroquia = parroquia;
        this.zona = zona;
        this.sector = sector;
        this.manzana = manzana;
        this.formulario = formulario;
        this.direccion = direccion;
        this.barrio = barrio;
        this.x = x;
        this.y = y;
        this.circuito = circuito;
        this.codigo_circuito = codigo_circuito;
        this.subcircuito = subcircuito;
        this.codigo_subcircuito = codigo_subcircuito;
        this.razon_social = razon_social;
        this.actividad_economica = actividad_economica;
        this.tipo_establecimiento = tipo_establecimiento;
        this.categoria = categoria;
        this.nombre_del = nombre_del;
        this.cc = cc;
        this.licencia_municipal = licencia_municipal;
        this.licencia_bomberos = licencia_bomberos;
        this.licencia_msp = licencia_msp;
        this.licencia_mi = licencia_mi;
        this.licencia_mt = licencia_mt;
        this.ruc_rise = ruc_rise;
        this.apertura_horario_diurno = apertura_horario_diurno;
        this.cierre_horario_diurno = cierre_horario_diurno;
        this.apertura_horario_nocturno = apertura_horario_nocturno;
        this.cierre_horario_nocturno = cierre_horario_nocturno;
        this.observaciones_jornada_laboral = observaciones_jornada_laboral;
        this.terrenos_valdios = terrenos_valdios;
        this.espacios_abiertos = espacios_abiertos;
        this.especificaciones_entorno_externo = especificaciones_entorno_externo;
        this.visualizacion = visualizacion;
        this.iluminacion = iluminacion;
        this.entradas_salidas_emergencia = entradas_salidas_emergencia;
        this.recodos_muretes = recodos_muretes;
        this.limpieza_local = limpieza_local;
        this.senializacion = senializacion;
        this.extintor_incendios = extintor_incendios;
        this.obsrv_sistemas_emergencia = obsrv_sistemas_emergencia;
        this.sistema_seguridad = sistema_seguridad;
        this.tipo = tipo;
        this.establecimiento_local = establecimiento_local;
        this.barrio_comunitarias = barrio_comunitarias;
        this.camaras_ec911 = camaras_ec911;
        this.obsrvc_sistema_seguridad = obsrvc_sistema_seguridad;
        this.inst_educativa = inst_educativa;
        this.distancia_ie = distancia_ie;
        this.direccion_ie = direccion_ie;
        this.obsrvc_ie = obsrvc_ie;
        this.digitador = digitador;
        this.observaciones_generales = observaciones_generales;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCarga_trabajo() {
        return carga_trabajo;
    }

    public void setCarga_trabajo(int carga_trabajo) {
        this.carga_trabajo = carga_trabajo;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public int getParroquia() {
        return parroquia;
    }

    public void setParroquia(int parroquia) {
        this.parroquia = parroquia;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public int getManzana() {
        return manzana;
    }

    public void setManzana(int manzana) {
        this.manzana = manzana;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
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

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getActividad_economica() {
        return actividad_economica;
    }

    public void setActividad_economica(String actividad_economica) {
        this.actividad_economica = actividad_economica;
    }

    public String getTipo_establecimiento() {
        return tipo_establecimiento;
    }

    public void setTipo_establecimiento(String tipo_establecimiento) {
        this.tipo_establecimiento = tipo_establecimiento;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getNombre_del() {
        return nombre_del;
    }

    public void setNombre_del(String nombre_del) {
        this.nombre_del = nombre_del;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getLicencia_municipal() {
        return licencia_municipal;
    }

    public void setLicencia_municipal(String licencia_municipal) {
        this.licencia_municipal = licencia_municipal;
    }

    public String getLicencia_bomberos() {
        return licencia_bomberos;
    }

    public void setLicencia_bomberos(String licencia_bomberos) {
        this.licencia_bomberos = licencia_bomberos;
    }

    public String getLicencia_msp() {
        return licencia_msp;
    }

    public void setLicencia_msp(String licencia_msp) {
        this.licencia_msp = licencia_msp;
    }

    public String getLicencia_mi() {
        return licencia_mi;
    }

    public void setLicencia_mi(String licencia_mi) {
        this.licencia_mi = licencia_mi;
    }

    public String getLicencia_mt() {
        return licencia_mt;
    }

    public void setLicencia_mt(String licencia_mt) {
        this.licencia_mt = licencia_mt;
    }

    public String getRuc_rise() {
        return ruc_rise;
    }

    public void setRuc_rise(String ruc_rise) {
        this.ruc_rise = ruc_rise;
    }

    public String getApertura_horario_diurno() {
        return apertura_horario_diurno;
    }

    public void setApertura_horario_diurno(String apertura_horario_diurno) {
        this.apertura_horario_diurno = apertura_horario_diurno;
    }

    public String getCierre_horario_diurno() {
        return cierre_horario_diurno;
    }

    public void setCierre_horario_diurno(String cierre_horario_diurno) {
        this.cierre_horario_diurno = cierre_horario_diurno;
    }

    public String getApertura_horario_nocturno() {
        return apertura_horario_nocturno;
    }

    public void setApertura_horario_nocturno(String apertura_horario_nocturno) {
        this.apertura_horario_nocturno = apertura_horario_nocturno;
    }

    public String getCierre_horario_nocturno() {
        return cierre_horario_nocturno;
    }

    public void setCierre_horario_nocturno(String cierre_horario_nocturno) {
        this.cierre_horario_nocturno = cierre_horario_nocturno;
    }

    public String getObservaciones_jornada_laboral() {
        return observaciones_jornada_laboral;
    }

    public void setObservaciones_jornada_laboral(String observaciones_jornada_laboral) {
        this.observaciones_jornada_laboral = observaciones_jornada_laboral;
    }

    public String getTerrenos_valdios() {
        return terrenos_valdios;
    }

    public void setTerrenos_valdios(String terrenos_valdios) {
        this.terrenos_valdios = terrenos_valdios;
    }

    public String getEspacios_abiertos() {
        return espacios_abiertos;
    }

    public void setEspacios_abiertos(String espacios_abiertos) {
        this.espacios_abiertos = espacios_abiertos;
    }

    public String getEspecificaciones_entorno_externo() {
        return especificaciones_entorno_externo;
    }

    public void setEspecificaciones_entorno_externo(String especificaciones_entorno_externo) {
        this.especificaciones_entorno_externo = especificaciones_entorno_externo;
    }

    public String getVisualizacion() {
        return visualizacion;
    }

    public void setVisualizacion(String visualizacion) {
        this.visualizacion = visualizacion;
    }

    public String getIluminacion() {
        return iluminacion;
    }

    public void setIluminacion(String iluminacion) {
        this.iluminacion = iluminacion;
    }

    public String getEntradas_salidas_emergencia() {
        return entradas_salidas_emergencia;
    }

    public void setEntradas_salidas_emergencia(String entradas_salidas_emergencia) {
        this.entradas_salidas_emergencia = entradas_salidas_emergencia;
    }

    public String getRecodos_muretes() {
        return recodos_muretes;
    }

    public void setRecodos_muretes(String recodos_muretes) {
        this.recodos_muretes = recodos_muretes;
    }

    public String getLimpieza_local() {
        return limpieza_local;
    }

    public void setLimpieza_local(String limpieza_local) {
        this.limpieza_local = limpieza_local;
    }

    public String getSenializacion() {
        return senializacion;
    }

    public void setSenializacion(String senializacion) {
        this.senializacion = senializacion;
    }

    public String getExtintor_incendios() {
        return extintor_incendios;
    }

    public void setExtintor_incendios(String extintor_incendios) {
        this.extintor_incendios = extintor_incendios;
    }

    public String getObsrv_sistemas_emergencia() {
        return obsrv_sistemas_emergencia;
    }

    public void setObsrv_sistemas_emergencia(String obsrv_sistemas_emergencia) {
        this.obsrv_sistemas_emergencia = obsrv_sistemas_emergencia;
    }

    public String getSistema_seguridad() {
        return sistema_seguridad;
    }

    public void setSistema_seguridad(String sistema_seguridad) {
        this.sistema_seguridad = sistema_seguridad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstablecimiento_local() {
        return establecimiento_local;
    }

    public void setEstablecimiento_local(int establecimiento_local) {
        this.establecimiento_local = establecimiento_local;
    }

    public int getBarrio_comunitarias() {
        return barrio_comunitarias;
    }

    public void setBarrio_comunitarias(int barrio_comunitarias) {
        this.barrio_comunitarias = barrio_comunitarias;
    }

    public String getCamaras_ec911() {
        return camaras_ec911;
    }

    public void setCamaras_ec911(String camaras_ec911) {
        this.camaras_ec911 = camaras_ec911;
    }

    public String getObsrvc_sistema_seguridad() {
        return obsrvc_sistema_seguridad;
    }

    public void setObsrvc_sistema_seguridad(String obsrvc_sistema_seguridad) {
        this.obsrvc_sistema_seguridad = obsrvc_sistema_seguridad;
    }

    public String getInst_educativa() {
        return inst_educativa;
    }

    public void setInst_educativa(String inst_educativa) {
        this.inst_educativa = inst_educativa;
    }

    public int getDistancia_ie() {
        return distancia_ie;
    }

    public void setDistancia_ie(int distancia_ie) {
        this.distancia_ie = distancia_ie;
    }

    public String getDireccion_ie() {
        return direccion_ie;
    }

    public void setDireccion_ie(String direccion_ie) {
        this.direccion_ie = direccion_ie;
    }

    public String getObsrvc_ie() {
        return obsrvc_ie;
    }

    public void setObsrvc_ie(String obsrvc_ie) {
        this.obsrvc_ie = obsrvc_ie;
    }

    public String getDigitador() {
        return digitador;
    }

    public void setDigitador(String digitador) {
        this.digitador = digitador;
    }

    public String getObservaciones_generales() {
        return observaciones_generales;
    }

    public void setObservaciones_generales(String observaciones_generales) {
        this.observaciones_generales = observaciones_generales;
    }

}
