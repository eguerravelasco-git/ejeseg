/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.util.ArrayList;

/**
 *
 * @author Geovanny
 */
public class Ocupaciones {

    public static ArrayList<String> enlistarOcupaciones() {
        ArrayList<String> lst = new ArrayList<String>();

        try {
            lst.add("AGRICULTOR");
            lst.add("QQ HH");
            lst.add("NA");
            lst.add("EMPLEADO PRIVADO");
            lst.add("EMPLEADO PUBLICO");
            lst.add("ESTUDIANTE");
            lst.add("COMERCIANTE");
            lst.add("JORNALERO");
            lst.add("PERSONA CON DISCAPACIDAD");
            lst.add("PROFESIONAL");
            lst.add("DESEMPLEADO");
            lst.add("JUBILADO");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lst;
    }

}
