/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoportal.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import geoportal.logica.clases.DenunciasPj;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author servidor
 */
public class FDenunciasPj {
    
    public static ArrayList<DenunciasPj> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<DenunciasPj> lst = new ArrayList<DenunciasPj>();
        DenunciasPj datos = null;
        try {
            while (rs.next()) {
                datos = new DenunciasPj(rs.getInt("pid"),rs.getString("pcanton"),rs.getString("pcodigo_subcircuito"),rs.getString("pdistrito"),
                        rs.getString("pcircuito"),rs.getString("psubcircuito"),rs.getString("pdireccion_agresion"),rs.getString("psector"),
                        rs.getString("pzona"),rs.getDate("pfecha_de_registro"),rs.getString("phora_de_registro"),
                        rs.getDate("pfecha_de_infraccion"),rs.getString("pmes_infraccion"),rs.getString("pdia_infraccion"),
                        rs.getString("phora_de_infraccion"),rs.getString("prango_hora"),rs.getString("pcaso"),
                        rs.getString("pnumero_de_caso"),rs.getInt("pcaso_reincidente"),rs.getString("porigen_de_informacion"),
                        rs.getString("ptipo_de_violencia"),rs.getString("pcausa_de_violencia"),rs.getString("pdescripcion_de_hechos"),
                        rs.getInt("pci_victima"),rs.getString("papellidos_victima"),rs.getString("psexo_victima"),
                        rs.getInt("pedad_victima"),rs.getString("prango_edad_victima"),rs.getString("pestado_civil_victima"),
                        rs.getString("pnacionalid_victima"),rs.getString("pprofesion_victima"),rs.getString("pinstruccion_victima"),
                        rs.getString("pnumero_telefono_victima"),rs.getString("pnovedad_con_denunciante"),rs.getString("papellidos_agresor"),
                        rs.getString("pci_agresor"),rs.getString("psexo_agresor"),rs.getInt("pedad_agresor"),
                        rs.getString("prango_edad_agresor"),rs.getString("pestado_civil_agresor"),rs.getString("pnacionalidad_agresor"),
                        rs.getString("pprofesion_agresor"),rs.getString("pinstruccion_agresor"),rs.getString("ptelefono_agresor"),
                        rs.getString("pparentezco_con_victima"),rs.getString("pnovedad_con_agresor"),rs.getString("ptipo_de_operativo"),
                        rs.getString("pactividad_operativa"),rs.getDouble("px"),rs.getDouble("py"));

                lst.add(datos);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<DenunciasPj> ObtenerDatosDenunciasPjDadoAnio(int anio) throws Exception {
        ArrayList<DenunciasPj> lst = new ArrayList<DenunciasPj>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_denunciaspj_dado_anio(?)";
            lstP.add(new Parametro(1, anio));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
    
    public static ArrayList<DenunciasPj> ObtenerDatosDenunciasPjDadoAnioCircuito(int anio,String circuito) throws Exception {
        ArrayList<DenunciasPj> lst = new ArrayList<DenunciasPj>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_denunciaspj_dado_anio_circuito(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, circuito));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
    
     public static ArrayList<DenunciasPj> ObtenerDatosDenunciasPjDadoAnioCircuitoSexo(int anio,String circuito,String sexo) throws Exception {
        ArrayList<DenunciasPj> lst = new ArrayList<DenunciasPj>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_denunciaspj_dado_anio_circuito_sexo_victima(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, circuito));
            lstP.add(new Parametro(2, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
     
     public static ArrayList<DenunciasPj> ObtenerDatosDenunciasPjDadoAnioSexo(int anio,String sexo) throws Exception {
        ArrayList<DenunciasPj> lst = new ArrayList<DenunciasPj>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_denunciaspj_dado_anio_sexo_victima(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
     
     public static ArrayList<DenunciasPj> ObtenerDatosDenunciasPjDadoAnioSubcircuito(int anio,String subcircuito) throws Exception {
        ArrayList<DenunciasPj> lst = new ArrayList<DenunciasPj>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_denunciaspj_dado_anio_subcircuito(?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, subcircuito));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
     
     public static ArrayList<DenunciasPj> ObtenerDatosDenunciasPjDadoAnioSubcircuitoSexo(int anio,String subcircuito,String sexo) throws Exception {
        ArrayList<DenunciasPj> lst = new ArrayList<DenunciasPj>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_denunciaspj_dado_anio_subcircuito_sexo_victima(?,?,?)";
            lstP.add(new Parametro(1, anio));
            lstP.add(new Parametro(2, subcircuito));
            lstP.add(new Parametro(2, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
}