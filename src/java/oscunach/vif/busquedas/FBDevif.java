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
import oscunach.vif.entidades.Devif;

/**
 *
 * @author oscunach jose duchi
 */
public class FBDevif {

    public static ArrayList<Devif> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        Devif datos = null;
        try {
            while (rs.next()) {
                datos = new Devif(
                        rs.getInt("pord_"),
                        rs.getString("pcanton"),
                        rs.getString("pcodigo_subcircuito"),
                        rs.getString("pdistrito"),
                        rs.getString("pcircuito"),
                        rs.getString("psubcircuito"),
                        rs.getString("pdireccion_infraccion"),
                        rs.getString("psector"),
                        rs.getString("pzona"),
                        rs.getDate("pfecha_registro"),
                        rs.getString("phora_registro"),
                        rs.getDate("pfecha_infraccion"),
                        rs.getString("pmes_infraccion"),
                        rs.getString("pdia_infraccion"),
                        rs.getString("phora_infraccion"),
                        rs.getString("prango_hora_infraccion"),
                        rs.getString("pcaso"),
                        rs.getString("pnumero_caso"),
                        rs.getInt("pcaso_reincidentes"),
                        rs.getString("porigen_informacion"),
                        rs.getString("ptipo_violencia"),
                        rs.getString("pcausa_violencia"),
                        rs.getString("pdescripcion_hechos"),
                        rs.getInt("pcedula_victima"),
                        rs.getString("papellidos_nombres_victima"),
                        rs.getString("psexo_victima"),
                        rs.getInt("pedad_victima"),
                        rs.getString("prango_edad_victima"),
                        rs.getString("pestado_civil_victima"),
                        rs.getString("pnacionalidad_victima"),
                        rs.getString("pprofesion_ocupacion_victima"),
                        rs.getString("pinstruccion_victima"),
                        rs.getString("pnumero_telefonico_victima"),
                        rs.getString("pnovedad_denunciante"),
                        rs.getString("papellidos_nombres_agresor"),
                        rs.getString("pcedula_agresor"),
                        rs.getString("psexo_agresor"),
                        rs.getInt("pedad_agresor"),
                        rs.getString("prango_edad_agresor"),
                        rs.getString("pestado_civil_agresor"),
                        rs.getString("pnacionalidad_agresor"),
                        rs.getString("pprofesion_agresor"),
                        rs.getString("pinstruccion_agresor"),
                        rs.getString("pnumero_telefonico_agresor"),
                        rs.getString("pparentezco_victima"),
                        rs.getString("pnovedad_agresor"),
                        rs.getString("ptipo_operativo"),
                        rs.getString("pactividad_operativa"),
                        rs.getInt("pid")
                );
                lst.add(datos);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

     public static ArrayList<Devif> obtenerDatos() throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            String sql = "select * from vif.select_vif_devif()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    /*Buscar por anio*/
    public static ArrayList<Devif> obtenerDatosDadoAnio(int anio) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from if.select_vif_devif_anio(?)";
            lstP.add(new Parametro(1, anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y circuitoo*/
    public static ArrayList<Devif> obtenerDatosDadoAnioCircuito(int anio, String circuito) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_circuito(?,?)";
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

    /*buscar por anioo, circuitoo y genero*/
    public static ArrayList<Devif> obtenerDatosDadoAnioCircuitoGenero(int anio, String circuito, String sexo_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_circuito_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, circuito));
            lstP.add(new Parametro(3, sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<Devif> obtenerEstadoCivilDadoAnio(int anio) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_estado_civil_dado_anio(?)";
            lstP.add(new Parametro(1, anio));            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y estado civil*/
    public static ArrayList<Devif> obtenerDatosDadoAnioEstadoCivil(int anio, String estado_civil_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_estado_civil(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, estado_civil_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo, estado civil y genero*/
    public static ArrayList<Devif> obtenerDatosDadoAnioEstadoCivilGenero(int anio, String estado_civil_victima, String sexo_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_estado_civil_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, estado_civil_victima));
            lstP.add(new Parametro(3, sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<Devif> obtenerOcupacionesDadoAnio(int anio) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_devif_ocupacion_dado_anio(?)";
            lstP.add(new Parametro(1, anio));            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo, ocupacion*/
    public static ArrayList<Devif> obtenerDatosDadoAnioOcupacion(int anio, String profesion_ocupacion_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_ocupacion(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, profesion_ocupacion_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo, ocupacion, genero*/
    public static ArrayList<Devif> obtenerDatosDadoAnioOcupacionGenero(int anio, String profesion_ocupacion_victima, String sexo_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_ocupacion_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, profesion_ocupacion_victima));
            lstP.add(new Parametro(3, sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y subcircuitoo*/
    public static ArrayList<Devif> obtenerDatosDadoAnioSubCircuito(int anio, String subcircuito) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_subcircuito(?,?)";
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

    /*buscar por anioo y subcircuitoo, genero*/
    public static ArrayList<Devif> obtenerDatosDadoAnioSubCircuitoGenero(int anio, String subcircuito, String sexo_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_subcircuito_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, subcircuito));
            lstP.add(new Parametro(3, sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<Devif> obtenerTipoViolenciaDadoAnio(int anio) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_tipo_violencia_devif_dado_anio_(?)";
            lstP.add(new Parametro(1, anio));            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }    
    
    /*buscar por anioo y tipo violencia*/
    public static ArrayList<Devif> obtenerDatosDadoAnioTipoViolencia(int anio, String tipo_violencia) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_tipo_violencia(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, tipo_violencia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y tipo violencia*/
    public static ArrayList<Devif> obtenerDatosDadoAnioTipoViolenciaGenero(int anio, String tipo_violencia, String sexo_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_tipo_violencia_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, tipo_violencia));
            lstP.add(new Parametro(3, sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y rango edad*/
    public static ArrayList<Devif> obtenerDatosDadoAnioRangoEdad(int anio, String edad_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_rango_edad(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, edad_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y rango edad, genero*/
    public static ArrayList<Devif> obtenerDatosDadoAnioRangoEdadGenero(int anio, String edad_victima, String sexo_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_rango_edad_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, edad_victima));
            lstP.add(new Parametro(3, sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y reincidencia denuncias genero*/
    public static ArrayList<Devif> obtenerDatosDadoAnioReincidenciasDenunciaGenero(int anio, String caso_reincidentes, String sexo_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_reincidencia_denuncias(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, caso_reincidentes));
            lstP.add(new Parametro(3, sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y reincidencia denuncias*/
    public static ArrayList<Devif> obtenerDatosDadoAnioReincidenciasDenuncia(int anio, String caso_reincidentes) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_reincidencia_denuncias_genero(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, caso_reincidentes));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y denunciasmes*/
    public static ArrayList<Devif> obtenerDatosDadoAnioDenunciasMes(int anio, String fecha_registro) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_mes_denuncia(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, fecha_registro));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y denunciasmes, genero*/
    public static ArrayList<Devif> obtenerDatosDadoAnioDenunciasMesGenero(int anio, String fecha_registro, String sexo_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_mes_denuncia(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, fecha_registro));
            lstP.add(new Parametro(3, sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y denuncias dia*/
    public static ArrayList<Devif> obtenerDatosDadoAnioDenunciasDia(int anio, String fecha_registro) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_dia_denunciaa(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, fecha_registro));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y denuncias dia*/
    public static ArrayList<Devif> obtenerDatosDadoAnioDenunciasDiaGenero(int anio, String fecha_registro, String sexo_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_dia_denunciaa(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, fecha_registro));
            lstP.add(new Parametro(3, sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y agresion mes*/
    public static ArrayList<Devif> obtenerDatosDadoAnioMesAgrecion(int anio, String mes_infraccion) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_mes_agresion(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, mes_infraccion));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y agresion mes, genero*/
    public static ArrayList<Devif> obtenerDatosDadoAnioMesAgrecionGenero(int anio, String mes_infraccion, String sexo_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_mes_agresion_genero(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, mes_infraccion));
            lstP.add(new Parametro(3, sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y agresion dia*/
    public static ArrayList<Devif> obtenerDatosDadoAnioDiaAgresion(int anio, String dia_infraccion) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_dia_agresion(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, dia_infraccion));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y agresion dia*/
    public static ArrayList<Devif> obtenerDatosDadoAnioDiaAgresionGenero(int anio, String dia_infraccion, String sexo_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_dia_agresion_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, dia_infraccion));
            lstP.add(new Parametro(3, sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }   
    
    
    
    public static ArrayList<Devif> obtenerParentescoDadoAnio(int anio) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_parentesco_dado_anio(?)";
            lstP.add(new Parametro(1, anio));            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }    
    
    /*buscar por anioo y tipo violencia*/
    public static ArrayList<Devif> obtenerDatosDadoAnioParentesco(int anio, String parentesco) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_parentesco(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, parentesco));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    /*buscar por anioo y tipo violencia*/
    public static ArrayList<Devif> obtenerDatosDadoAnioParentescoGenero(int anio, String parentesco, String sexo_victima) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_parentesco_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, parentesco));
            lstP.add(new Parametro(3, sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
     public static ArrayList<Devif> obtenerRangosEdadDadoAnio(int anio) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_devif_rango_edad_dado_anio(?)";
            lstP.add(new Parametro(1, anio));            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
     public static ArrayList<Devif> obtenerDatosDadoRangosEdadDadoAnio(int anio,String rango) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_rango_edad(?,?)";
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
     
     public static ArrayList<Devif> obtenerDatosDadoRangosEdadDadoAnioGenero(int anio,String rango,String genero) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_anio_rango_edad_genero(?,?,?)";
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
     
     public static ArrayList<Devif> obtenerDatosDadoAnioDiaDenuncia(int anio,String dia) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_dia_denuncia(?,?)";
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
     public static ArrayList<Devif> obtenerDatosDadoAnioDiaDenunciaGenero(int anio,String dia,String genero) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_dia_denuncia_genero(?,?,?)";
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
     
     public static ArrayList<Devif> obtenerDatosDadoAnioMesDenuncia(int anio,String dia) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_mes_denuncia(?,?)";
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
     public static ArrayList<Devif> obtenerDatosDadoAnioMesDenunciaGenero(int anio,String dia,String genero) throws Exception {
        ArrayList<Devif> lst = new ArrayList<Devif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_devif_dado_anio_mes_denuncia_genero(?,?,?)";
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
