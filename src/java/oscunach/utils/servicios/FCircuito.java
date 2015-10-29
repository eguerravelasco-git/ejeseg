/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.utils.servicios;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import oscunach.utils.entidades.Circuito;

/**
 *
 * @author Virt-ICITS-2
 */
public class FCircuito {

    //llenar datos
    public static ArrayList<Circuito> llenarCircuito(ConjuntoResultado rs) throws Exception {
        ArrayList<Circuito> lst = new ArrayList<Circuito>();
        Circuito circuito = null;
        try {
            while (rs.next()) {
                circuito = new Circuito(rs.getInt("pid_circuito"), rs.getString("pcodigo_circuito"), rs.getString("pdescripcion"));
                lst.add(circuito);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Circuito> obtenerCircuito() throws Exception {
        ArrayList<Circuito> lst = new ArrayList<Circuito>();
        try {
            String sql = "select * from vif.f_select_circuito()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarCircuito(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }

        return lst;
    }

    public static boolean insertarCircuito(Circuito circuito) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.f_insert_circuito(?,?)";
            lstP.add(new Parametro(1, circuito.getCodigo_circuito()));
            lstP.add(new Parametro(2, circuito.getDescripcion()));
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


    public static boolean actualizarCircuito(Circuito circuito) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.f_update_circuito(?,?,?)";
            lstP.add(new Parametro(1, circuito.getCodigo_circuito()));
            lstP.add(new Parametro(2, circuito.getDescripcion()));
            lstP.add(new Parametro(3, circuito.getId_circuito()));
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
            String sql = "select * from vif.f_delete_circuito(?)";
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
    
    
     public static Circuito ObtenerCircuitoDadoDescripcion(String descripcion) throws Exception {
        Circuito lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.f_select_circuito_dado_descripcion(?)";
            lstP.add(new Parametro(1, descripcion));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Circuito();
            lst = llenarCircuito(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Circuito ObtenerCircuitoDadoId(int id) throws Exception {
        Circuito lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.f_select_circuito_dado_id(?)";
            lstP.add(new Parametro(1, id));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Circuito();
            lst = llenarCircuito(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

}
