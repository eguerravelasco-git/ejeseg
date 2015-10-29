/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.locales.busquedas;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.util.ArrayList;
import static oscunach.locales.busquedas.BusquedasLocales.llenarDatos;
import oscunach.locales.entidades.Locales;

/**
 *
 * @author servidor
 */
public class BusquedasLocalesCircuitos {

    public static ArrayList<Locales> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        Locales datos = null;
        try {
            while (rs.next()) {
                datos = new Locales(
                        rs.getInt("pcodigo"),
                        rs.getInt("pcarga_trabajo"),
                        rs.getInt("pgrupo"),
                        rs.getString("pestado"),
                        rs.getString("pprovincia"),
                        rs.getString("pcanton"),
                        rs.getInt("pparroquia"),
                        rs.getInt("pzona"),
                        rs.getInt("psector"),
                        rs.getInt("pmanzana"),
                        rs.getString("pformulario"),
                        rs.getString("pdireccion"),
                        rs.getString("pbarrio"),
                        rs.getDouble("px"),
                        rs.getDouble("py"),
                        rs.getString("pcircuito"),
                        rs.getString("pcodigo_circuito"),
                        rs.getString("psubcircuito"),
                        rs.getString("pcodigo_subcircuito"),
                        rs.getString("prazon_social"),
                        rs.getString("pactividad_economica"),
                        rs.getString("ptipo_establecimiento"),
                        rs.getInt("pcategoria"),
                        rs.getString("pnombre_del"),
                        rs.getString("pcc"),
                        rs.getString("plicencia_municipal"),
                        rs.getString("plicencia_bomberos"),
                        rs.getString("plicencia_msp"),
                        rs.getString("plicencia_mi"),
                        rs.getString("plicencia_mt"),
                        rs.getString("pruc_rise"),
                        rs.getString("papertura_horario_diurno"),
                        rs.getString("pcierre_horario_diurno"),
                        rs.getString("papertura_horario_nocturno"),
                        rs.getString("pcierre_horario_nocturno"),
                        rs.getString("pobservaciones_jornada_laboral"),
                        rs.getString("pterrenos_valdios"),
                        rs.getString("pespacios_abiertos"),
                        rs.getString("pespecificaciones_entorno_externo"),
                        rs.getString("pvisualizacion"),
                        rs.getString("piluminacion"),
                        rs.getString("pentradas_salidas_emergencia"),
                        rs.getString("precodos_muretes"),
                        rs.getString("plimpieza_local"),
                        rs.getString("psenializacion"),
                        rs.getString("pextintor_incendios"),
                        rs.getString("pobsrv_sistemas_emergencia"),
                        rs.getString("psistema_seguridad"),
                        rs.getString("ptipo"),
                        rs.getInt("pestablecimiento_local"),
                        rs.getInt("pbarrio_comunitarias"),
                        rs.getString("pcamaras_ec911"),
                        rs.getString("pobsrvc_sistema_seguridad"),
                        rs.getString("pinst_educativa"),
                        rs.getInt("pdistancia_ie"),
                        rs.getString("pdireccion_ie"),
                        rs.getString("pobsrvc_ie"),
                        rs.getString("pdigitador"),
                        rs.getString("pobservaciones_generales"));
                lst.add(datos);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuito(String circuito) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito(?)";
            lstP.add(new Parametro(1, circuito));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*
     *** cumplimiento de permisos
     */
    public static ArrayList<Locales> obtenerDatosDadoCircuitoPermisoMunicipio(String circuito, String permiso) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_licencia_municipal(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, permiso));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoPermisoBomberos(String circuito, String permiso) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_licencia_bomberos(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, permiso));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoPermisoMsp(String circuito, String permiso) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_licencia_msp(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, permiso));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoPermisoMinisterioInterior(String circuito, String permiso) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_licencia_mi(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, permiso));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoPermisoMinisterioTurismo(String circuito, String permiso) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_licencia_mt(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, permiso));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoRucRise(String circuito, String permiso) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_ruc_rise(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, permiso));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoTerrenosValdios(String circuito, String entorno) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_terrenos_valdios(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, entorno));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoEspaciosAbiertos(String circuito, String entorno) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_espacios_abiertos(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, entorno));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoVisualizacion(String circuito, String visualizacion) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_visualizacion(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, visualizacion));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoIluminacion(String circuito, String iluminacion) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_iluminacion(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, iluminacion));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoEntradasSalidasEmergencia(String circuito, String entorno) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_entradas_salidas_emergencia(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, entorno));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoRecodosMuretes(String circuito, String entorno) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_recodos_muretes(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, entorno));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoLimpiezaLocal(String circuito, String entorno) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_limpieza_local(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, entorno));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoSenializacion(String circuito, String senializacion) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_senializacion(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, senializacion));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoExtintor(String circuito, String extintor) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_extintor_incendios(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, extintor));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoSistemaSeguridad(String circuito, String sistema) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_sistema_seguridad(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, sistema));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoTipoSistemaSeguridad(String circuito, String sistema, String tipo) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_tipo_sistema_seguridad(?,?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, sistema));
            lstP.add(new Parametro(3, tipo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoCamarasEcu911(String circuito, String sistema) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_camaras_ec911(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, sistema));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Locales> obtenerDatosDadoCircuitoDistanciaInstEducativa(String circuito, int distancia) throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_locales_dado_circuito_distancia_ie(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, distancia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

}
