/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.locales.servicios;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import oscunach.locales.entidades.CatastroIntendencia2015;

/**
 *
 * @Edwin Maigua
 */
public class ServiciosCatastroIntendencia2015 {

    public static ArrayList<CatastroIntendencia2015> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<CatastroIntendencia2015> lst = new ArrayList<CatastroIntendencia2015>();
        CatastroIntendencia2015 catastro = null;
        try {
            while (rs.next()) {
                catastro = new CatastroIntendencia2015(
                        rs.getInt("pcodigo"),
                        rs.getInt("porpaf"),
                        rs.getString("ppropietario"),
                        rs.getString("prazon_social"),
                        rs.getString("pdireccion"),
                        rs.getDouble("pvalor"),
                        rs.getString("ptipo_establecimiento"),
                        rs.getString("pparroqui"),
                        rs.getInt("pcategoria"));
                lst.add(catastro);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static boolean insertar(CatastroIntendencia2015 catastro) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_insert_catastro_intendencia_2015(?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, catastro.getOrpaf()));
            lstP.add(new Parametro(2, catastro.getPropietario()));
            lstP.add(new Parametro(3, catastro.getRazon_social()));
            lstP.add(new Parametro(4, catastro.getDireccion()));
            lstP.add(new Parametro(5, catastro.getValor()));
            lstP.add(new Parametro(6, catastro.getTipo_establecimiento()));
            lstP.add(new Parametro(7, catastro.getParroqui()));
            lstP.add(new Parametro(8, catastro.getCategoria()));
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

    public static boolean actualizar(CatastroIntendencia2015 catastro) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_update_catastro_intendencia_2015(?,?,?,?,?,?,?,?,?)";

            lstP.add(new Parametro(1, catastro.getOrpaf()));
            lstP.add(new Parametro(2, catastro.getPropietario()));
            lstP.add(new Parametro(3, catastro.getRazon_social()));
            lstP.add(new Parametro(4, catastro.getDireccion()));
            lstP.add(new Parametro(5, catastro.getValor()));
            lstP.add(new Parametro(6, catastro.getTipo_establecimiento()));
            lstP.add(new Parametro(7, catastro.getParroqui()));
            lstP.add(new Parametro(8, catastro.getCategoria()));
            lstP.add(new Parametro(9, catastro.getCodigo()));
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

    public static boolean eliminar(int codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_delete_catastro_intendencia_2015(?)";
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

    public static ArrayList<CatastroIntendencia2015> ObtenerCatastroIntendencia2015() throws Exception {
        ArrayList<CatastroIntendencia2015> lst = new ArrayList<CatastroIntendencia2015>();
        try {
            String sql = "select * from locales.f_select_catastro_intendencia_2015()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static ArrayList<CatastroIntendencia2015> ObtenerCatastroIntendencia2015DatoPropietario(String propietario) throws Exception {
        ArrayList<CatastroIntendencia2015> lst = new ArrayList<CatastroIntendencia2015>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_catastro_intendencia_2015_dado_propietario(?)";
            lstP.add(new Parametro(1, propietario));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
     public static ArrayList<CatastroIntendencia2015> ObtenerCatastroIntendencia2015DadoCodigo(int codigo) throws Exception{
          ArrayList<CatastroIntendencia2015> lst = new ArrayList<CatastroIntendencia2015>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from locales.f_select_catastro_intendencia_2015_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
         
     }
     

     
    

}
