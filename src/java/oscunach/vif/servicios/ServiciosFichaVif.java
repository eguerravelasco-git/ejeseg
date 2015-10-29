/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.vif.servicios;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import oscunach.vif.entidades.FichaVif;


/**
 *
 * @author Oscunach
 */
public class ServiciosFichaVif {

    //llenar ficha
    public static ArrayList<FichaVif> llenarFicha(ConjuntoResultado rs) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        FichaVif fichavif = null;

        try {
            while (rs.next()) {
                fichavif = new FichaVif(
                        rs.getInt("pid_ficha"),
                        rs.getString("pnombres_victima"),
                        rs.getString("papellidos_victima"),
                        rs.getString("psexo_victima"),
                        rs.getString("pdireccion_victima"),
                        rs.getString("pdomiciliado_victima"),
                        rs.getInt("pedad_victima"),
                        rs.getString("pestado_civil_victima"),
                        rs.getString("pnivel_instruccion_victima"),
                        rs.getString("pocupacion_victima"),
                        rs.getString("psexo_agresor"),
                        rs.getString("pdireccion_agresor"),
                        rs.getInt("pedad_agresor"),
                        rs.getString("pdomiciliado_agresor"),
                        rs.getString("pestado_civil_agresor"),
                        rs.getString("pnivel_instruccion_agresor"),
                        rs.getString("pocupaccion_agresor"),
                        rs.getString("pparentesco_victima_agresor"),
                        rs.getInt("pnumero_hijos_comun"),
                        rs.getString("ptiempo_convivencia"),
                        rs.getString("plugar_agresion"),
                        rs.getString("ptipo_violencia"),
                        rs.getDate("pfecha_agresion"),
                        rs.getTime("phora_agresion"),
                        rs.getString("preincidencia_agresion"),
                        rs.getString("pobjeto_agresion"),
                        rs.getString("pestado_conciencia_agresor"),
                        rs.getString("pdireccion_agresion"),
                        rs.getDouble("px"),
                        rs.getDouble("py"),
                        rs.getString("pcircuito"),
                        rs.getString("pcodigo_circuito"),
                        rs.getString("psubcircuito"),
                        rs.getString("pcodigo_subcircuito"),
                        rs.getDate("pfecha_denuncia"),
                        rs.getString("pdenunciante"),
                        rs.getString("pmedidas_amparo"),
                        rs.getString("psentencia"),
                        rs.getString("papelacion"),
                        rs.getString("pboletas_anteriores"),
                        rs.getString("pobservaciones"),
                        rs.getString("pboletas_remision"),
                        rs.getString("pagresor")
                );

                lst.add(fichavif);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }

        return lst;
    }

    //obtener ficha
    public static ArrayList<FichaVif> obtenerFichas() throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();

        try {
            String sql = "select * from vif.select_ficha()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarFicha(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    //insertar ficha falta completar 
    public static boolean insertarFicha(FichaVif ficha) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.f_insert_ficha(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, ficha.getNombres_victima()));
            lstP.add(new Parametro(2, ficha.getApellidos_victima()));
            lstP.add(new Parametro(3, ficha.getSexo_victima()));
            lstP.add(new Parametro(4, ficha.getDireccion_victima()));
            lstP.add(new Parametro(5, ficha.getDomiciliado_victima()));
            lstP.add(new Parametro(6, ficha.getEdad_victima()));
            lstP.add(new Parametro(7, ficha.getEstado_civil_victima()));
            lstP.add(new Parametro(8, ficha.getNivel_instruccion_victima()));
            lstP.add(new Parametro(9, ficha.getOcupacion_victima()));
            lstP.add(new Parametro(10, ficha.getSexo_agresor()));
            lstP.add(new Parametro(11, ficha.getDireccion_agresor()));
            lstP.add(new Parametro(12, ficha.getEdad_agresor()));
            lstP.add(new Parametro(13, ficha.getDomiciliado_agresor()));
            lstP.add(new Parametro(14, ficha.getEstado_civil_agresor()));
            lstP.add(new Parametro(15, ficha.getNivel_instruccion_agresor()));
            lstP.add(new Parametro(16, ficha.getOcupaccion_agresor()));
            lstP.add(new Parametro(17, ficha.getParentesco_victima_agresor()));
            lstP.add(new Parametro(18, ficha.getNumero_hijos_comun()));
            lstP.add(new Parametro(19, ficha.getTiempo_convivencia()));
            lstP.add(new Parametro(20, ficha.getLugar_agresion()));
            lstP.add(new Parametro(21, ficha.getTipo_violencia()));
            lstP.add(new Parametro(22, ficha.getFecha_agresion()));
            lstP.add(new Parametro(23, ficha.getHora_agresion()));
            lstP.add(new Parametro(24, ficha.getReincidencia_agresion()));
            lstP.add(new Parametro(25, ficha.getObjeto_agresion()));
            lstP.add(new Parametro(26, ficha.getEstado_conciencia_agresor()));
            lstP.add(new Parametro(27, ficha.getDireccion_agresion()));
            lstP.add(new Parametro(28, ficha.getX()));
            lstP.add(new Parametro(29, ficha.getY()));
            lstP.add(new Parametro(30, ficha.getCircuito()));
            lstP.add(new Parametro(31, ficha.getCodigo_circuito()));
            lstP.add(new Parametro(32, ficha.getSubcircuito()));
            lstP.add(new Parametro(33, ficha.getCodigo_subcircuito()));
            lstP.add(new Parametro(34, ficha.getFecha_denuncia()));
            lstP.add(new Parametro(35, ficha.getDenunciante()));
            lstP.add(new Parametro(36, ficha.getMedidas_amparo()));
            lstP.add(new Parametro(37, ficha.getSentencia()));
            lstP.add(new Parametro(38, ficha.getApelacion()));
            lstP.add(new Parametro(39, ficha.getBoletas_anteriores()));
            lstP.add(new Parametro(40, ficha.getObservaciones()));
            lstP.add(new Parametro(41, ficha.getBoletas_remision()));
            lstP.add(new Parametro(42, ficha.getAgresor()));

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
    
    
    public static boolean actualizarFicha(FichaVif ficha) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.f_update_ficha(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, ficha.getNombres_victima()));
            lstP.add(new Parametro(2, ficha.getApellidos_victima()));
            lstP.add(new Parametro(3, ficha.getSexo_victima()));
            lstP.add(new Parametro(4, ficha.getDireccion_victima()));
            lstP.add(new Parametro(5, ficha.getDomiciliado_victima()));
            lstP.add(new Parametro(6, ficha.getEdad_victima()));
            lstP.add(new Parametro(7, ficha.getEstado_civil_victima()));
            lstP.add(new Parametro(8, ficha.getNivel_instruccion_victima()));
            lstP.add(new Parametro(9, ficha.getOcupacion_victima()));
            lstP.add(new Parametro(10, ficha.getSexo_agresor()));
            lstP.add(new Parametro(11, ficha.getDireccion_agresor()));
            lstP.add(new Parametro(12, ficha.getEdad_agresor()));
            lstP.add(new Parametro(13, ficha.getDomiciliado_agresor()));
            lstP.add(new Parametro(14, ficha.getEstado_civil_agresor()));
            lstP.add(new Parametro(15, ficha.getNivel_instruccion_agresor()));
            lstP.add(new Parametro(16, ficha.getOcupaccion_agresor()));
            lstP.add(new Parametro(17, ficha.getParentesco_victima_agresor()));
            lstP.add(new Parametro(18, ficha.getNumero_hijos_comun()));
            lstP.add(new Parametro(19, ficha.getTiempo_convivencia()));
            lstP.add(new Parametro(20, ficha.getLugar_agresion()));
            lstP.add(new Parametro(21, ficha.getTipo_violencia()));
            lstP.add(new Parametro(22, ficha.getFecha_agresion()));
            lstP.add(new Parametro(23, ficha.getHora_agresion()));
            lstP.add(new Parametro(24, ficha.getReincidencia_agresion()));
            lstP.add(new Parametro(25, ficha.getObjeto_agresion()));
            lstP.add(new Parametro(26, ficha.getEstado_conciencia_agresor()));
            lstP.add(new Parametro(27, ficha.getDireccion_agresion()));
            lstP.add(new Parametro(28, ficha.getX()));
            lstP.add(new Parametro(29, ficha.getY()));
            lstP.add(new Parametro(30, ficha.getCircuito()));
            lstP.add(new Parametro(31, ficha.getCodigo_circuito()));
            lstP.add(new Parametro(32, ficha.getSubcircuito()));
            lstP.add(new Parametro(33, ficha.getCodigo_subcircuito()));
            lstP.add(new Parametro(34, ficha.getFecha_denuncia()));
            lstP.add(new Parametro(35, ficha.getDenunciante()));
            lstP.add(new Parametro(36, ficha.getMedidas_amparo()));
            lstP.add(new Parametro(37, ficha.getSentencia()));
            lstP.add(new Parametro(38, ficha.getApelacion()));
            lstP.add(new Parametro(39, ficha.getBoletas_anteriores()));
            lstP.add(new Parametro(40, ficha.getObservaciones()));
            lstP.add(new Parametro(41, ficha.getBoletas_remision()));
            lstP.add(new Parametro(42, ficha.getAgresor()));
            lstP.add(new Parametro(43, ficha.getId_ficha()));

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

    
    public static  boolean eliminarFicha(int vid) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from vif.f_delete_ficha(?)";
        lstP.add(new Parametro(1,vid));
        ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
        while(rs.next() )
            {
              if(rs.getString(0).equals("true"));
                   eje=true;
            }
            } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return eje;
    }
    
    
}
