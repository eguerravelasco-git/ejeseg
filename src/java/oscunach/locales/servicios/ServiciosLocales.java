/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.locales.servicios;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import java.sql.SQLException;
import java.util.ArrayList;
import oscunach.locales.entidades.Locales;

/**
 *
 * @author servidor
 */
public class ServiciosLocales {

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
    
    
    public static ArrayList<Locales> ObtenerLocales() throws Exception {
        ArrayList<Locales> lst = new ArrayList<Locales>();
        try {
            String sql = "select * from locales.f_select_locales()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

}
