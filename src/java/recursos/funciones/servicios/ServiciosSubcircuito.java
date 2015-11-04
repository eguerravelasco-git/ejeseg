/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.funciones.servicios;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import recursos.Circuitos;
import recursos.Subcircuito;
import static recursos.funciones.servicios.ServiciosCircuitos.llenarCircuito;

/**
 *
 * @author ICITS SALA5
 */
public class ServiciosSubcircuito {
    
//llenar datos
    public static ArrayList<Subcircuito> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Subcircuito> lst = new ArrayList<Subcircuito>();
        Subcircuito subcircuito = null;
        try {
            while (rs.next()) {
                subcircuito = new Subcircuito(rs.getInt("pid_subcircuito"), rs.getString("pcodigo_subcircuito"), rs.getString("pdescripcion"),
                        ServiciosCircuitos.ObtenerCircuitoDadoId(rs.getInt("pid_circuito")));
                lst.add(subcircuito);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
    
    public static ArrayList<Subcircuito> obtenerSubcircuito() throws Exception {
        ArrayList<Subcircuito> lst = new ArrayList<Subcircuito>();
        try {
            String sql = "select * from utiles.f_select_subcircuito()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
            
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        
        return lst;
    }
    
    public static boolean insertarSubcircuito(Subcircuito subcircuito) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from utiles.f_insert_subcircuito(?,?,?)";
            lstP.add(new Parametro(1, subcircuito.getCodigo_subcircuito()));
            lstP.add(new Parametro(2, subcircuito.getDescripcion()));
            lstP.add(new Parametro(3, subcircuito.getId_circuito().getId_circuito()));
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
    
    public static boolean actualizarSubcircuito(Subcircuito subcircuito) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from utiles.f_update_subcircuito(?,?,?,?)";
            lstP.add(new Parametro(1, subcircuito.getCodigo_subcircuito()));
            lstP.add(new Parametro(2, subcircuito.getDescripcion()));
            lstP.add(new Parametro(3, subcircuito.getId_circuito().getId_circuito()));
            lstP.add(new Parametro(4, subcircuito.getId_subcircuito()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return eje;
    }
    
    public static boolean eliminar(int codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from utiles.f_delete_subcircuito(?)";
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
    
    public static Subcircuito ObtenerSubcircuitoDadoId(int id) throws Exception {
        Subcircuito lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from utiles.f_select_subcircuito_dado_id(?)";
            lstP.add(new Parametro(1, id));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Subcircuito();
            lst = llenarDatos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Subcircuito obtenerSubcircuitoDadoCodigoCircuito(int id) throws Exception {
        Subcircuito lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from utiles.f_select_subcircuito_dado_codigo_circuito(?)";
            lstP.add(new Parametro(1, id));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Subcircuito();
            lst = llenarDatos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<Subcircuito> obtenerSubcircuitoDadoIdCircuito(int id) throws Exception {
         ArrayList<Subcircuito> lst = new ArrayList<Subcircuito>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from utiles.f_select_subcircuito_dado_codigo_circuito(?)";
            lstP.add(new Parametro(1, id));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);            
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    


 
}
