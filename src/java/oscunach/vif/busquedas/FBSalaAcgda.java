/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.busquedas;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import oscunach.vif.entidades.SalaAcgda;

/**
 *
 * @author Geovanny Cudco
 */
public class FBSalaAcgda {

    public static ArrayList<SalaAcgda> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        SalaAcgda datos = null;
        try {
            while (rs.next()) {
                datos = new SalaAcgda(
                        rs.getInt("pcodigo"),
                        rs.getInt("pnumero_ficha"),
                        rs.getString("pprovincia"),
                        rs.getString("pcanton"),
                        rs.getString("pbarrio"),
                        rs.getString("pinstitucion"),
                        rs.getDate("pfecha_atencion"),
                        rs.getString("papellidos_victima"),
                        rs.getString("pnombres_victima"),
                        rs.getInt("pedad_victima"),
                        rs.getString("psexo_victima"),
                        rs.getString("pinstruccion_victima"),
                        rs.getString("pestado_civil_victima"),
                        rs.getString("pocupacion_victima"),
                        rs.getString("ptelefono_victima"),
                        rs.getString("pcanton_domicilio"),
                        rs.getString("pparroquia_domicilio"),
                        rs.getString("pdireccion_domicilio_victima"),
                        rs.getDouble("px"),
                        rs.getDouble("py"),
                        rs.getString("pcircuito"),
                        rs.getString("psubcircuito"),
                        rs.getString("pdireccion_trabajo_victima"),
                        rs.getString("ptelefono_trabajo_victima"),
                        rs.getString("ptipo_agresion"),
                        rs.getString("pfrecuencia"),
                        rs.getString("plugar_agresion"),
                        rs.getDate("pfecha_agresion"),
                        rs.getString("phora_agresion"),
                        rs.getString("pasociacion_agresion"),
                        rs.getString("pobjeto_agresion"),
                        rs.getString("pestado_conciencia"),
                        rs.getString("papellidos_agresor"),
                        rs.getString("pnombres_agresor"),
                        rs.getInt("pedad_agresor"),
                        rs.getString("psexo_agresor"),
                        rs.getString("pestado_civil_agresor"),
                        rs.getString("pinstruccion_agresor"),
                        rs.getString("pdireccion_domicilio_agresor"),
                        rs.getString("pocupacion_agresor"),
                        rs.getString("pdireccion_trabajo_agresor"),
                        rs.getString("ptelefono_trabajo_agresor"),
                        rs.getString("pparentesco"),
                        rs.getString("ptratamiento"),
                        rs.getString("pcaso_medico"),
                        rs.getString("preferido")
                );
                lst.add(datos);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatos() throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            String sql = "select * from vif.select_spa()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoAnio(int anio) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio(?)";
            lstP.add(new Parametro(1, anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoAnioCircuito(int anio, String circuito) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_circuito(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, circuito));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoAnioCircuitoGenero(int anio, String circuito, String sexo) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_circuito_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, circuito));
            lstP.add(new Parametro(3, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoAnioSubcircuito(int anio, String subcircuito) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_subcircuito(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, subcircuito));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoAnioSubcircuitoGenero(int anio, String subcircuito, String sexo) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_subcircuito_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, subcircuito));
            lstP.add(new Parametro(3, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerTiposDeViolencia(int anio) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_tipos_violencia(?)";
            lstP.add(new Parametro(1, anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoAnioTipoViolencia(int anio, String violencia) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_tipo_vioelncia(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, violencia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoAnioTipoViolenciaGenero(int anio, String violencia, String genero) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_tipo_vioelncia_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, violencia));
            lstP.add(new Parametro(3, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoAnioEstadoCivil(int anio, String estadoCivil) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_estado_civil(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, estadoCivil));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoAnioEstadoCivilGenero(int anio, String estadoCivil, String genero) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_estado_civil_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, estadoCivil));
            lstP.add(new Parametro(3, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerEstadosCiviles(int anio) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_estado_civil(?)";
            lstP.add(new Parametro(1, anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoAnioRangoEdad(int anio, String rango) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_rango_edad(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, rango));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoAnioRangoEdadGenero(int anio, String rango, String genero) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_rango_edad_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, rango));
            lstP.add(new Parametro(3, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoMesAtencion(int anio, String mes) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_mes_atencion(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, mes));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoMesAtencionGenero(int anio, String mes, String genero) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_mes_atencion_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, mes));
            lstP.add(new Parametro(3, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoMesAgresion(int anio, String mes) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  vif.select_spa_dado_anio_mes_agresion(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, mes));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoMesAgresionGenero(int anio, String mes, String genero) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_mes_agresion_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, mes));
            lstP.add(new Parametro(3, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoDiaAtencion(int anio, String dia) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_dia_atencion(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, dia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoDiaAtencionGenero(int anio, String Dia, String genero) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_dia_atencion_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, Dia));
            lstP.add(new Parametro(3, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoDiaAgresion(int anio, String dia) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  vif.select_spa_dado_anio_dia_agresion(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, dia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<SalaAcgda> obtenerDatosDadoDiaAgresionGenero(int anio, String dia, String genero) throws Exception {
        ArrayList<SalaAcgda> lst = new ArrayList<SalaAcgda>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_spa_dado_anio_dia_agresion_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, dia));
            lstP.add(new Parametro(3, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

}
