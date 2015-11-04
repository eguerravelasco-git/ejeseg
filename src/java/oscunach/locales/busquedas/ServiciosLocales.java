/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.locales.busquedas;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import oscunach.locales.entidades.Locales;

/**
 *
 * @author Oscunach
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

    public static ArrayList<Locales> obtenerLocales() throws Exception {
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

    public static boolean insertarFicha(Locales locales) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_insert_locales(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //lstP.add(new Parametro(1, locales.getcodigo()));
            lstP.add(new Parametro(1, locales.getCarga_trabajo()));
            lstP.add(new Parametro(2, locales.getGrupo()));
            lstP.add(new Parametro(3, locales.getEstado()));
            lstP.add(new Parametro(4, locales.getProvincia()));
            lstP.add(new Parametro(5, locales.getCanton()));
            lstP.add(new Parametro(6, locales.getParroquia()));
            lstP.add(new Parametro(7, locales.getZona()));
            lstP.add(new Parametro(8, locales.getSector()));
            lstP.add(new Parametro(9, locales.getManzana()));
            lstP.add(new Parametro(10, locales.getFormulario()));
            lstP.add(new Parametro(11, locales.getDireccion()));
            lstP.add(new Parametro(12, locales.getBarrio()));
            lstP.add(new Parametro(13, locales.getX()));
            lstP.add(new Parametro(14, locales.getY()));
            lstP.add(new Parametro(15, locales.getCircuito()));
            lstP.add(new Parametro(16, locales.getCodigo_circuito()));
            lstP.add(new Parametro(17, locales.getSubcircuito()));
            lstP.add(new Parametro(18, locales.getCodigo_subcircuito()));
            lstP.add(new Parametro(19, locales.getRazon_social()));
            lstP.add(new Parametro(20, locales.getActividad_economica()));
            lstP.add(new Parametro(21, locales.getTipo_establecimiento()));
            lstP.add(new Parametro(22, locales.getCategoria()));
            lstP.add(new Parametro(23, locales.getNombre_del()));
            lstP.add(new Parametro(24, locales.getCc()));
            lstP.add(new Parametro(25, locales.getLicencia_municipal()));
            lstP.add(new Parametro(26, locales.getLicencia_bomberos()));
            lstP.add(new Parametro(27, locales.getLicencia_msp()));
            lstP.add(new Parametro(28, locales.getLicencia_mi()));
            lstP.add(new Parametro(29, locales.getLicencia_mt()));
            lstP.add(new Parametro(30, locales.getRuc_rise()));
            lstP.add(new Parametro(31, locales.getApertura_horario_diurno()));
            lstP.add(new Parametro(32, locales.getCierre_horario_diurno()));
            lstP.add(new Parametro(33, locales.getApertura_horario_nocturno()));
            lstP.add(new Parametro(34, locales.getCierre_horario_nocturno()));
            lstP.add(new Parametro(35, locales.getObservaciones_jornada_laboral()));
            lstP.add(new Parametro(36, locales.getTerrenos_valdios()));
            lstP.add(new Parametro(37, locales.getEspacios_abiertos()));
            lstP.add(new Parametro(38, locales.getEspecificaciones_entorno_externo()));
            lstP.add(new Parametro(39, locales.getVisualizacion()));
            lstP.add(new Parametro(40, locales.getIluminacion()));
            lstP.add(new Parametro(41, locales.getEntradas_salidas_emergencia()));
            lstP.add(new Parametro(42, locales.getRecodos_muretes()));
            lstP.add(new Parametro(43, locales.getLimpieza_local()));
            lstP.add(new Parametro(44, locales.getSenializacion()));
            lstP.add(new Parametro(45, locales.getExtintor_incendios()));
            lstP.add(new Parametro(46, locales.getObsrv_sistemas_emergencia()));
            lstP.add(new Parametro(47, locales.getSistema_seguridad()));
            lstP.add(new Parametro(48, locales.getTipo()));
            lstP.add(new Parametro(49, locales.getEstablecimiento_local()));
            lstP.add(new Parametro(50, locales.getBarrio_comunitarias()));
            lstP.add(new Parametro(51, locales.getCamaras_ec911()));
            lstP.add(new Parametro(52, locales.getObsrvc_sistema_seguridad()));
            lstP.add(new Parametro(53, locales.getInst_educativa()));
            lstP.add(new Parametro(54, locales.getDistancia_ie()));
            lstP.add(new Parametro(55, locales.getDireccion_ie()));
            lstP.add(new Parametro(56, locales.getObsrvc_ie()));
            lstP.add(new Parametro(57, locales.getDigitador()));
            lstP.add(new Parametro(58, locales.getObservaciones_generales()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
    
    public static boolean updateFicha(Locales locales) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_update_locales(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //lstP.add(new Parametro(1, locales.getcodigo()));
            lstP.add(new Parametro(1, locales.getCarga_trabajo()));
            lstP.add(new Parametro(2, locales.getGrupo()));
            lstP.add(new Parametro(3, locales.getEstado()));
            lstP.add(new Parametro(4, locales.getProvincia()));
            lstP.add(new Parametro(5, locales.getCanton()));
            lstP.add(new Parametro(6, locales.getParroquia()));
            lstP.add(new Parametro(7, locales.getZona()));
            lstP.add(new Parametro(8, locales.getSector()));
            lstP.add(new Parametro(9, locales.getManzana()));
            lstP.add(new Parametro(10, locales.getFormulario()));
            lstP.add(new Parametro(11, locales.getDireccion()));
            lstP.add(new Parametro(12, locales.getBarrio()));
            lstP.add(new Parametro(13, locales.getX()));
            lstP.add(new Parametro(14, locales.getY()));
            lstP.add(new Parametro(15, locales.getCircuito()));
            lstP.add(new Parametro(16, locales.getCodigo_circuito()));
            lstP.add(new Parametro(17, locales.getSubcircuito()));
            lstP.add(new Parametro(18, locales.getCodigo_subcircuito()));
            lstP.add(new Parametro(19, locales.getRazon_social()));
            lstP.add(new Parametro(20, locales.getActividad_economica()));
            lstP.add(new Parametro(21, locales.getTipo_establecimiento()));
            lstP.add(new Parametro(22, locales.getCategoria()));
            lstP.add(new Parametro(23, locales.getNombre_del()));
            lstP.add(new Parametro(24, locales.getCc()));
            lstP.add(new Parametro(25, locales.getLicencia_municipal()));
            lstP.add(new Parametro(26, locales.getLicencia_bomberos()));
            lstP.add(new Parametro(27, locales.getLicencia_msp()));
            lstP.add(new Parametro(28, locales.getLicencia_mi()));
            lstP.add(new Parametro(29, locales.getLicencia_mt()));
            lstP.add(new Parametro(30, locales.getRuc_rise()));
            lstP.add(new Parametro(31, locales.getApertura_horario_diurno()));
            lstP.add(new Parametro(32, locales.getCierre_horario_diurno()));
            lstP.add(new Parametro(33, locales.getApertura_horario_nocturno()));
            lstP.add(new Parametro(34, locales.getCierre_horario_nocturno()));
            lstP.add(new Parametro(35, locales.getObservaciones_jornada_laboral()));
            lstP.add(new Parametro(36, locales.getTerrenos_valdios()));
            lstP.add(new Parametro(37, locales.getEspacios_abiertos()));
            lstP.add(new Parametro(38, locales.getEspecificaciones_entorno_externo()));
            lstP.add(new Parametro(39, locales.getVisualizacion()));
            lstP.add(new Parametro(40, locales.getIluminacion()));
            lstP.add(new Parametro(41, locales.getEntradas_salidas_emergencia()));
            lstP.add(new Parametro(42, locales.getRecodos_muretes()));
            lstP.add(new Parametro(43, locales.getLimpieza_local()));
            lstP.add(new Parametro(44, locales.getSenializacion()));
            lstP.add(new Parametro(45, locales.getExtintor_incendios()));
            lstP.add(new Parametro(46, locales.getObsrv_sistemas_emergencia()));
            lstP.add(new Parametro(47, locales.getSistema_seguridad()));
            lstP.add(new Parametro(48, locales.getTipo()));
            lstP.add(new Parametro(49, locales.getEstablecimiento_local()));
            lstP.add(new Parametro(50, locales.getBarrio_comunitarias()));
            lstP.add(new Parametro(51, locales.getCamaras_ec911()));
            lstP.add(new Parametro(52, locales.getObsrvc_sistema_seguridad()));
            lstP.add(new Parametro(53, locales.getInst_educativa()));
            lstP.add(new Parametro(54, locales.getDistancia_ie()));
            lstP.add(new Parametro(55, locales.getDireccion_ie()));
            lstP.add(new Parametro(56, locales.getObsrvc_ie()));
            lstP.add(new Parametro(57, locales.getDigitador()));
            lstP.add(new Parametro(58, locales.getObservaciones_generales()));
            lstP.add(new Parametro(59, locales.getCodigo()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
    
    public static boolean eliminarFicha(int codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_delete_locales(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

}
