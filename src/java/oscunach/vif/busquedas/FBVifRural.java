/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.busquedas;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.util.ArrayList;
import static oscunach.vif.busquedas.FBVifUrbano.llenarDatos;
import oscunach.vif.entidades.VifRural;
import oscunach.vif.entidades.VifUrbano;

/**
 *
 * @author oscunach
 */
public class FBVifRural {

    public static ArrayList<VifRural> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        VifRural datos = null;
        try {
            while (rs.next()) {
                datos = new VifRural(
                        rs.getDate("pfecha_denuncia"),
                        rs.getString("pdenunciante"),
                        rs.getString("pvictima"),
                        rs.getString("psexo_victima"),
                        rs.getString("pdireccion_victima"),
                        rs.getDouble("px"),
                        rs.getDouble("py"),
                        rs.getString("pcircuito"),
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
                        rs.getString("plugar_de_agresion"),
                        rs.getString("ptipo_de_violencia"),
                        rs.getString("pfecha_agresion"),
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
    /* busqueda por anio*/
    
    public static ArrayList<VifRural> obtenerDatosDadoAnio(int anio) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio(?)";
            lstP.add(new Parametro(1, anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    /*Busqueda por anio circuito*/
    
    public static ArrayList<VifRural> obtenerDatosDadoAnioCircuito(int pin_anio, String pin_circuito) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_circuito(?,?)";
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
    
    /*Busqueda por anio circuito genero*/
    
     public static ArrayList<VifRural> obtenerDatosDadoAnioCircuitoGenero(int pin_anio, String pin_circuito,String pin_genero ) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_circuito_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_circuito));
            lstP.add(new Parametro(3, pin_genero ));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    
     /*Busqueda por anio estado civil*/
    
    public static ArrayList<VifRural> obtenerDatosDadoAnioEstadoCivil(int pin_anio, String estado_civil) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_estado_civil(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, estado_civil));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    
    /*Busqueda por anio estado civil genero*/
    
    public static ArrayList<VifRural> obtenerDatosDadoAnioEstadoCivilGenero(int pin_anio, String estado_civil, String genero) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_estado_civil_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, estado_civil));
             lstP.add(new Parametro(3, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    /*Busqueda por anio genero*/
    
    public static ArrayList<VifRural> obtenerDatosDadoAnioGenero(int pin_anio, String genero) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_genero(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    /*Busqueda por anio mes denuncia */
    
    public static ArrayList<VifRural> obtenerDatosDadoAnioMesDenuncia(int pin_anio, String mes_denuncia) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_mes_denuncia(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, mes_denuncia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    /*Busqueda por anio mes denuncia y genero*/
    
     public static ArrayList<VifRural> obtenerDatosDadoAnioMesDenunciaGenero(int pin_anio, String mes_denuncia,String pin_Genero) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_mes_denuncia_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, mes_denuncia));
            lstP.add(new Parametro(3, pin_Genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
       /*Busqueda por anio rango-edad genero */
    
    public static ArrayList<VifRural> obtenerDatosDadoAnioRangoEdad(int pin_anio, String rango_edad) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_rango_edad(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, rango_edad));            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
        
            
    }
    
    public static ArrayList<VifRural> obtenerDatosDadoAnioRangoEdadGenero(int pin_anio, String rango_edad, String genero ) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_rango_edad_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, rango_edad));
            lstP.add(new Parametro(3, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
        
            
    }
    
    /*Busqueda por anio subcircuito */
    
    
    public static ArrayList<VifRural> obtenerDatosDadoAnioSubCircuito(int pin_anio, String pin_circuito) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_subcircuito(?,?)";
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
    
     /*Busqueda por anio subcircuito genero*/
    
    
     public static ArrayList<VifRural> obtenerDatosDadoAnioSubCircuitoGenero(int pin_anio, String pin_circuito, String pin_sexo) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_subcircuito_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_circuito));
            lstP.add(new Parametro(3, pin_sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
     
     /*Busqueda por anio tipo violencia*/
     
     public static ArrayList<VifRural> obtenerDatosDadoAnioTipoViolencia(int pin_anio, String tipo_violencia) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_tipo_violencia(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, tipo_violencia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
     
     /*Busqueda por anio tipo violencia genero*/
     
      public static ArrayList<VifRural> obtenerDatosDadoAnioTipoViolenciaGenero(int pin_anio, String tipo_violencia, String genero) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_tipo_violencia_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, tipo_violencia));
            lstP.add(new Parametro(3, genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
      
      
       /*Busqueda por estado civil victima dado anio*/
      public static ArrayList<VifRural> obtenerDatosDadoEstadoCivilVictimaDadoAnio(int pin_anio) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_estado_civil_victima_dado_anio(?)";
            lstP.add(new Parametro(1, pin_anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
      
      /*Busqueda pparentesco dado anio*/
      public static ArrayList<VifRural> obtenerDatosParentescoDadoAnio(int pin_anio) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_parentesco_dado_anio(?)";
            lstP.add(new Parametro(1, pin_anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
     
      /*Busqueda tipo violencia dado anio*/
      public static ArrayList<VifRural> obtenerTipoViolenciaDadoAnio(int pin_anio) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_tipo_de_violencia_dado_anio(?)";
            lstP.add(new Parametro(1, pin_anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
        /*Busqueda anio parentesco*/
       public static ArrayList<VifRural> obtenerDatosDadoAnioParentesco(int pin_anio, String pin_parentesco) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_parentesco(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_parentesco));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
       /*Busqueda anio parentesco genero*/
     public static ArrayList<VifRural> obtenerDatosDadoAnioParentescoGenero(int pin_anio, String pin_parentesco,String pin_genero) throws Exception {
        ArrayList<VifRural> lst = new ArrayList<VifRural>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_vif_rural_dado_anio_parentesco_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_parentesco));
            lstP.add(new Parametro(3, pin_genero));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
     
}
