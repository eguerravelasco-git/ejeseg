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
import oscunach.utils.entidades.Direcciones;


/**
 *
 * @author servidor
 */
public class FDirecciones {

    public static ArrayList<Direcciones> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Direcciones> lst = new ArrayList<Direcciones>();
        Direcciones direcciones = null;
        try {
            while (rs.next()) {
                direcciones = new Direcciones(
                        rs.getString("pcalles"),
                        rs.getDouble("px"),
                        rs.getDouble("py"),
                        rs.getString("pcircuito"),
                        rs.getString("pcodigo_circuito"),
                        rs.getString("psubcircuito"),
                        rs.getString("pcodigo_subcircuito"),
                        rs.getInt("ppk")
                );
                lst.add(direcciones);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Direcciones> obtenerDirecciones() throws Exception {
        ArrayList<Direcciones> lst = new ArrayList<Direcciones>();
        try {
            String sql = "select * from utiles.f_select_direcciones()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }

        return lst;
    }

    public static ArrayList<Direcciones> obtenerLstDireccionesDadoCalles(String calles) throws Exception {
        ArrayList<Direcciones> lst = new ArrayList<Direcciones>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from utiles.f_select_direcciones_dado_calles(?)";
            lstP.add(new Parametro(1, calles));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Direcciones obtenerDireccionesDadoCalles(String calles) throws Exception {
        Direcciones lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from utiles.f_select_direcciones_dado_calles(?)";
            lstP.add(new Parametro(1, calles));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Direcciones();
            lst = llenarDatos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean insertarDirecciones(Direcciones direccion) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from utiles.f_insert_direcciones(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1,direccion.getCalles()));
            lstP.add(new Parametro(2,direccion.getX()));
            lstP.add(new Parametro(3,direccion.getY()));
            lstP.add(new Parametro(4,direccion.getCircuito()));
            lstP.add(new Parametro(5,direccion.getCodigo_circuito()));
            lstP.add(new Parametro(6,direccion.getSubcircuito()));
            lstP.add(new Parametro(7,direccion.getCodigo_subcircuito()));
            
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
