/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.util.ArrayList;

/**
 *
 * @author Oscunach
 */
public class MesesDias {

    public static ArrayList<String> obtenerMeses(){
        ArrayList<String> lstMeses = new ArrayList<String>();

        try {
            lstMeses.add("ENERO");
            lstMeses.add("FEBRERO");
            lstMeses.add("MARZO");
            lstMeses.add("ABRIL");
            lstMeses.add("MAYO");
            lstMeses.add("JUNIO");
            lstMeses.add("JULIO");
            lstMeses.add("AGOSTO");
            lstMeses.add("SEPTIEMBRE");
            lstMeses.add("OCTUBRE");
            lstMeses.add("NOVIEMBRE");
            lstMeses.add("DICIEMBRE");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lstMeses;
    }
    
    public static ArrayList<String> listarMeses(){
        ArrayList<String> lstMeses = new ArrayList<String>();

        try {
            lstMeses.add("enero");
            lstMeses.add("febrero");
            lstMeses.add("marzo");
            lstMeses.add("abril");
            lstMeses.add("mayo");
            lstMeses.add("junio");
            lstMeses.add("julio");
            lstMeses.add("agosto");
            lstMeses.add("septiembre");
            lstMeses.add("octubre");
            lstMeses.add("noviembre");
            lstMeses.add("diciembre");
            lstMeses.add("NA");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lstMeses;
    }

    public static ArrayList<String> obtenerDias() {
        ArrayList<String> lstSemana = new ArrayList<String>();
        lstSemana.add("LUNES");
        lstSemana.add("MARTES");
        lstSemana.add("MIERCOLES");
        lstSemana.add("JUEVES");
        lstSemana.add("VIERNES");
        lstSemana.add("SABADO");
        lstSemana.add("DOMINGO");
        return lstSemana;
    }        
    public static ArrayList<String> enlistarDias() {
        ArrayList<String> lstSemana = new ArrayList<String>();
        lstSemana.add("lunes");
        lstSemana.add("martes");
        lstSemana.add("miércoles");
        lstSemana.add("jueves");
        lstSemana.add("viernes");
        lstSemana.add("sábado");
        lstSemana.add("domingo");
        lstSemana.add("NA");
        return lstSemana;
    }  

}
