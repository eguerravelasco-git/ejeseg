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
import oscunach.vif.entidades.FichaVif;
import static oscunach.vif.servicios.ServiciosFichaVif.llenarFicha;

/**
 *
 * @author ICITS SALA5
 */
public class FBFichaFiscalia {

    public static ArrayList<FichaVif> obtenerFichaDadoAnioCircuito(int pin_anio, String pin_circuito) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_circuito(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_circuito));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioCircuitoGenero(int pin_anio, String pin_circuito, String pin_sexo_victima) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_circuito_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_circuito));
            lstP.add(new Parametro(3, pin_sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioDiaAgrecion(int pin_anio, String pin_dia_agrecion) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_dia_agresion(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_dia_agrecion));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioDiaAgrecionGenero(int pin_anio, String pin_dia_agrecion, String pin_sexo_victima) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_dia_agresion_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_dia_agrecion));
            lstP.add(new Parametro(3, pin_sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioDiaDenuncia(int pin_anio, String pin_dia_denuncia) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_dia_denuncia(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_dia_denuncia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioDiaDenunciaGenero(int pin_anio, String pin_dia_denuncia, String pin_sexo_victima) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_dia_denuncia_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_dia_denuncia));
            lstP.add(new Parametro(3, pin_sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

     public static ArrayList<FichaVif> obtenerFchaEstadoCivilDadoAnio(int anio) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_estadocivil_dado_anio(?)";
            lstP.add(new Parametro(1, anio));            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<FichaVif> obtenerFichaDadoAnioEstadoCivil(int pin_anio, String pin_estado_civil_victima) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_estadocivil(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_estado_civil_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioEstadoCivilGenero(int pin_anio, String pin_estado_civil_victima, String pin_sexo_victima) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_estadocivil_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_estado_civil_victima));
            lstP.add(new Parametro(3, pin_sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioMesAgresionGenero(int pin_anio, String pin_mes_agrecion, String pin_sexo_victima) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_mes_agresion_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_mes_agrecion));
            lstP.add(new Parametro(3, pin_sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioMesAgresion(int pin_anio, String pin_mes_agrecion) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_mes_agresion(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_mes_agrecion));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioMesDenuncia(int pin_anio, String pin_mes_denuncia) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_mes_denuncia(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_mes_denuncia));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioMesDenunciaGenero(int pin_anio, String pin_mes_denuncia, String pin_sexo_victima) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_mes_denuncia_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_mes_denuncia));
            lstP.add(new Parametro(3, pin_sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    
     public static ArrayList<FichaVif> obtenerOcupacionesDadoAnio(int anio) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_ocupacion_dado_anio(?)";
            lstP.add(new Parametro(1, anio));            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    
    public static ArrayList<FichaVif> obtenerFichaDadoAnioOcupacion(int pin_anio, String pin_ocupacion_victima) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_ocupacion(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_ocupacion_victima));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioOcupacionGenero(int pin_anio, String pin_ocupacion_victima, String pin_sexo_victima) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_ocupacion_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_ocupacion_victima));
            lstP.add(new Parametro(3, pin_sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioRangoEdadGenero(int pin_anio, String pin_rango, String pin_sexo_victima) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_rangoedad_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_rango));
            lstP.add(new Parametro(3, pin_sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioRangoEdad(int pin_anio, String pin_rango) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_rangoedad(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_rango));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioSubcircuito(int pin_anio, String pin_subcircuito) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_subcircuito(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_subcircuito));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioSubcircuitoGenero(int pin_anio, String pin_subcircuito, String pin_sexo_victima) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_subcircuito_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_subcircuito));
            lstP.add(new Parametro(3, pin_sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioTipoViolenciaGenero(int pin_anio, String pin_tipo_violencia, String pin_sexo_victima) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_tipoviolencia_genero(?,?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_tipo_violencia));
            lstP.add(new Parametro(3, pin_sexo_victima));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public static ArrayList<FichaVif> obtenerFichaDadoAnioTipoViolencia(int pin_anio, String pin_tipo_violencia) throws Exception {
        ArrayList<FichaVif> lst = new ArrayList<FichaVif>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from vif.select_ficha_dado_anio_tipoviolencia(?,?)";
            lstP.add(new Parametro(1, pin_anio));
            lstP.add(new Parametro(2, pin_tipo_violencia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarFicha(rs);
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

}
