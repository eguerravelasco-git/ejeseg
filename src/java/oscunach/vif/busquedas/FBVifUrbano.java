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
import oscunach.vif.entidades.VifUrbano;

/**
 *
 * @author Oscunach
 */
public class FBVifUrbano {

    public static ArrayList<VifUrbano> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        VifUrbano datos = null;
        try {
            while (rs.next()) {
                datos = new VifUrbano(
                        rs.getDate("pfecha_denuncia"),
                        rs.getString("pdenunciante"),
                        rs.getString("pvictima"),
                        rs.getString("psexo_victima"),
                        rs.getString("pdireccion_victima"),
                        rs.getDouble("px"),
                        rs.getDouble("py"),
                        rs.getString("pcircuito"),
                        rs.getString("pcodigo_circuito"),
                        rs.getString("psubcircuito"),
                        rs.getString("pcodigo_subcircuito"),
                        rs.getString("pdomiciliado_victima"),
                        rs.getInt("pedad_victima"),
                        rs.getString("pestado_civil_victima"),
                        rs.getString("pnivel_instruccion_victima"),
                        rs.getString("pocupacion_victima"),
                        rs.getString("pagresor"),
                        rs.getString("psexo_agresor"),
                        rs.getString("pdireccion_agresor"),
                        rs.getString("pedad_agresor"),
                        rs.getString("pdomiciliado_agresor"),
                        rs.getString("pestado_civil_agresor"),
                        rs.getString("pnivel_instruccion_agresor"),
                        rs.getString("pocupacion_agresor"),
                        rs.getString("pparentesco"),
                        rs.getString("phijos_comun"),
                        rs.getString("pdireccion_agresion"),
                        rs.getString("plugar_agresion"),
                        rs.getString("ptipo_de_violencia"),
                        rs.getDate("pfecha_agresion"),
                        rs.getString("phora_de_agresion"),
                        rs.getString("pmedidas_de_amparo"),
                        rs.getString("psentencia"),
                        rs.getString("papelacion"),
                        rs.getString("pboletas_anteriores"),
                        rs.getString("pobservaciones"),
                        rs.getString("pboletas_de_remision"),
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

    public static ArrayList<VifUrbano> obtenerDatos() throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            String sql = "select * from vif.select_vif_urbano()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<VifUrbano> obtenerDatosDadoAnio(int anio) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_urbano_dado_anio(?)";
            lstP.add(new Parametro(1, anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioCircuito(int anio, String circuito) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_urbano_dado_anio_circuito(?,?)";
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

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioCircuitoGenero(int anio, String circuito, String genero) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_urbano_dado_anio_circuito_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, circuito));
            lstP.add(new Parametro(3, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioSubcircuito(int anio, String subcircuito) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_urbano_dado_anio_subcircuito(?,?)";
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

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioSubcircuitoGenero(int anio, String subcircuito, String genero) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_urbano_dado_anio_subcircuito_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, subcircuito));
            lstP.add(new Parametro(3, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<VifUrbano> obtenerTipoViolenciaDadoAnio(int anio) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_tipos_violencia_vif_urbano_dado_anio(?)";
            lstP.add(new Parametro(1, anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioTipoViolencia(int anio, String violencia) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_tipo_violencia(?,?)";
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

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioTipoViolenciaGenero(int anio, String violencia, String genero) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_tipo_violencia_genero(?,?,?)";
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

    public static ArrayList<VifUrbano> obtenerDatosEstadoCivilDadoAnio(int anio) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_estado_civil_dado_anio(?)";
            lstP.add(new Parametro(1, anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioEstadoCivil(int anio, String estadoCivil) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_estado_civil(?,?)";
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

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioEstadoCivilGenero(int anio, String estadoCivil, String genero) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_estado_civil_genero(?,?,?)";
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

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioEdad(int anio, String edad) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_edad(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, edad));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioEdadGenero(int anio, String edad, String genero) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_edad_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, edad));
            lstP.add(new Parametro(3, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioMesDenuncia(int anio, String mes) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_mes_denuncia(?,?)";
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

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioMesDenunciaGenero(int anio, String mes, String genero) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_mes_denuncia_genero(?,?,?)";
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

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioMesAgresion(int anio, String mes) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_mes_agresion(?,?)";
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

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioMesAgresionGenero(int anio, String mes, String genero) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_mes_agresion_genero(?,?,?)";
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

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioDiaAgresion(int anio, String dia) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_dia_agresion(?,?)";
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

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioDiaAgresionGenero(int anio, String dia, String genero) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_dia_agresion_genero(?,?,?)";
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

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioDiaDenuncia(int anio, String dia) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_dia_denuncia(?,?)";
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

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioDiaDenunciaGenero(int anio, String dia, String genero) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_dia_denuncia_genero(?,?,?)";
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

    public static ArrayList<VifUrbano> obtenerParentescoDadoAnio(int anio) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_parentesco_dado_anio(?)";
            lstP.add(new Parametro(1, anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioParentesco(int anio, String parentesco) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_parentesco(?,?)";
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

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioParentescoGenero(int anio, String parentesco, String genero) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_dado_anio_parentesco_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, parentesco));
            lstP.add(new Parametro(3, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioOcupacion(int anio, String ocupacion) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_urbano_dado_anio_ocupacion(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, ocupacion));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<VifUrbano> obtenerDatosDadoAnioOcupacionGenero(int anio, String ocupacion, String genero) throws Exception {
        ArrayList<VifUrbano> lst = new ArrayList<VifUrbano>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_urbano_dado_anio_ocupacion_genero(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, ocupacion));
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
