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
import oscunach.vif.entidades.UnidadesFamilia;

/**
 *
 * @author Pc-03
 */
public class FBUnidadFamilia {

    //llenar ficha
    public static ArrayList<UnidadesFamilia> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        UnidadesFamilia unidadesfamilia = null;

        try {
            while (rs.next()) {
                unidadesfamilia = new UnidadesFamilia(
                        rs.getDouble("pnumero_causa"),
                        rs.getDate("pfecha_denuncia"),
                        rs.getString("psexo_agresor"),
                        rs.getString("psexo_victima"),
                        rs.getString("pbarrio_agresor"),
                        rs.getString("pbarrio_agredida"),
                        rs.getString("pedad_agresor"),
                        rs.getString("pedad_victima"),
                        rs.getString("pinstruccion_agresor"),
                        rs.getString("pinstrucc_victima"),
                        rs.getString("pparentesco"),
                        rs.getDouble("pnumero_hijos"),
                        rs.getString("plugar_agrecion"),
                        rs.getDouble("px"),
                        rs.getDouble("py"),
                        rs.getString("psubcircuit"),
                        rs.getString("pcircuito"),
                        rs.getString("ptipo_violencia"),
                        rs.getString("pfecha_agresion"),
                        rs.getString("pmedidas_amparo"),
                        rs.getString("psentencia"),
                        rs.getString("papelacion"),
                        rs.getString("pboletas_anteriores"),
                        rs.getString("pboletas_remision"),
                        rs.getString("pobservacio"),
                        rs.getInt("ppk")
                );

                lst.add(unidadesfamilia);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }

        return lst;
    }

    //obtener datos de unidades de familia
    public static ArrayList<UnidadesFamilia> obtenerFichas() throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();

        try {
            String sql = "select * from vif.select_unidades_familia()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    //obtener datos dado anio

    public static ArrayList<UnidadesFamilia> obtenerDatosDadoAnio(int pin_anio) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_unidades_familia_dado_anio(?)";
            lstP.add(new Parametro(1, pin_anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<UnidadesFamilia> obtenerDatosDadoAnioGenero(int pin_anio, String in_sexo_victima) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_unidades_familia_dado_anio_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, in_sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
//OBTENER DADO CIRCUITO

    public static ArrayList<UnidadesFamilia> obtenerDadoCircuito(int pin_anio, String pin_circuito) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_unidades_familia_dado_anio_circuitos(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_circuito));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<UnidadesFamilia> obtenerDadoCircuitoGenero(int pin_anio, String pin_circuito, String pin_sexo_victima) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_unidades_familia_dado_anio_circuitos_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_circuito));
            lstP.add(new Parametro(3, pin_sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<UnidadesFamilia> obtenerDadoDiaDenuncia(int pin_anio, String pin_diadenuncia) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_unidades_familia_dado_anio_dia_denuncia(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_diadenuncia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
      public static ArrayList<UnidadesFamilia> obtenerDadoDiaDenunciaGenero(int pin_anio, String pin_diadenuncia, String pin_sexovictima) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_unidades_familia_dado_anio_dia_denuncia_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_diadenuncia));
            lstP.add(new Parametro(3, pin_sexovictima));      
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
      
         public static ArrayList<UnidadesFamilia> obtenerDadoMesDenuncia(int pin_anio, String in_mesdenucnia) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_unidades_familia_dado_anio_mes_denuncia(?,?)";
            lstP.add(new Parametro(1, pin_anio));
           lstP.add(new Parametro(2, in_mesdenucnia));            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
      
    
        public static ArrayList<UnidadesFamilia> obtenerDadoMesDenunciaGenero(int pin_anio, String in_mesdenucnia, String pinsexo_agred) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_unidades_familia_dado_anio_mes_denuncia(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
           lstP.add(new Parametro(2, in_mesdenucnia));  
            lstP.add(new Parametro(3, pinsexo_agred));  
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
      
        
      public static ArrayList<UnidadesFamilia> obtenerDadoAnioParentesco(int pin_anio, String pin_parentesco) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_unidades_familia_dado_anio_parentesco(?,?)";
            lstP.add(new Parametro(1, pin_anio));
           lstP.add(new Parametro(2,pin_parentesco));  
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }  
      
        public static ArrayList<UnidadesFamilia> obtenerDadoAnioParentesccoGenero(int pin_anio, String pin_parentesco, String pin_genero) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_unidades_familia_dado_anio_parentesco(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
           lstP.add(new Parametro(2,pin_parentesco));  
           lstP.add(new Parametro(3,pin_genero)); 
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }  
      
       public static ArrayList<UnidadesFamilia> obtenerDadoAnioSubcircuito(int pin_anio, String pin_subcircuit) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_unidades_familia_dado_anio_subcircuit(?,?)";
            lstP.add(new Parametro(1, pin_anio));
           lstP.add(new Parametro(2,pin_subcircuit)); 
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    } 
         public static ArrayList<UnidadesFamilia> obtenerDadoAnioSubcircuitoGenero(int pin_anio, String pin_subcircuit,String pinsexo_agred ) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_unidades_familia_dado_anio_subcircuit_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
           lstP.add(new Parametro(2,pin_subcircuit)); 
           lstP.add(new Parametro(3,pinsexo_agred)); 
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    } 
        
    public static ArrayList<UnidadesFamilia> obtenerDadoAnioTipoViolenciaGenero(int pin_anio, String pin_tipo_violencia,String pin_tipo_violencia_genero ) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_unidades_familia_dado_anio_tipo_violencia_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
           lstP.add(new Parametro(2,pin_tipo_violencia)); 
           lstP.add(new Parametro(3,pin_tipo_violencia_genero)); 
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }      
     public static ArrayList<UnidadesFamilia> obtenerDadoAnioTipoViolencia(int pin_anio, String pin_tipo_violencia ) throws Exception {
        ArrayList<UnidadesFamilia> lst = new ArrayList<UnidadesFamilia>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_unidades_familia_dado_anio_tipo_violencia(?,?)";
            lstP.add(new Parametro(1, pin_anio));
           lstP.add(new Parametro(2,pin_tipo_violencia));          
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
         
}
