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
import oscunach.vif.entidades.Reincidencias;

/**
 *
 * @author Geovanny
 */
public class FBReincidencias {

    public static ArrayList<Reincidencias> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Reincidencias> lst = new ArrayList<Reincidencias>();
        Reincidencias datos = null;
        try {
            while (rs.next()) {
                datos = new Reincidencias(rs.getInt("preincidencia"), rs.getString("pvictima"), rs.getString("psexo"));
                lst.add(datos);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Reincidencias> obtenerDatos2010() throws Exception {
        ArrayList<Reincidencias> lst = new ArrayList<Reincidencias>();
        try {
            String sql = "select * from geoportal.f_select_reincidentes_2010()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<Reincidencias> obtenerDatos2011() throws Exception {
        ArrayList<Reincidencias> lst = new ArrayList<Reincidencias>();
        try {
            String sql = "select * from geoportal.f_select_reincidentes_2011()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<Reincidencias> obtenerDatos2012() throws Exception {
        ArrayList<Reincidencias> lst = new ArrayList<Reincidencias>();
        try {
            String sql = "select * from geoportal.f_select_reincidentes_2012()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Reincidencias> obtenerDatosDadoReincidencias2010(int reincidencia) throws Exception {
        ArrayList<Reincidencias> lst = new ArrayList<Reincidencias>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_reincidentes_2010_dado_reincidencia(?)";
            lstP.add(new Parametro(1, reincidencia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    public static ArrayList<Reincidencias> obtenerDatosDadoReincidencias2011(int reincidencia) throws Exception {
        ArrayList<Reincidencias> lst = new ArrayList<Reincidencias>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_reincidentes_2011_dado_reincidencia(?)";
            lstP.add(new Parametro(1, reincidencia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    public static ArrayList<Reincidencias> obtenerDatosDadoReincidencias2012(int reincidencia) throws Exception {
        ArrayList<Reincidencias> lst = new ArrayList<Reincidencias>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_reincidentes_2012_dado_reincidencia(?)";
            lstP.add(new Parametro(1, reincidencia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
        public static ArrayList<Reincidencias> ObtenerDatosDadoReincidenciasSexo2010(int reincidencia, String sexo) throws Exception {
        ArrayList<Reincidencias> lst = new ArrayList<Reincidencias>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_reincidentes_2010_dado_reincidencia_genero(?,?)";
            lstP.add(new Parametro(1, reincidencia));
            lstP.add(new Parametro(2, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<Reincidencias> ObtenerDatosDadoReincidenciasSexo2011(int reincidencia, String sexo) throws Exception {
        ArrayList<Reincidencias> lst = new ArrayList<Reincidencias>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_reincidentes_2011_dado_reincidencia_genero(?,?)";
            lstP.add(new Parametro(1, reincidencia));
            lstP.add(new Parametro(2, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Reincidencias> ObtenerDatosDadoReincidenciasSexo2012(int reincidencia, String sexo) throws Exception {
        ArrayList<Reincidencias> lst = new ArrayList<Reincidencias>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_reincidentes_2012_dado_reincidencia_genero(?,?)";
            lstP.add(new Parametro(1, reincidencia));
            lstP.add(new Parametro(2, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
