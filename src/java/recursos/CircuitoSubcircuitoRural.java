/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.util.ArrayList;

/**
 *
 * @author CristhianMoreno
 */
public class CircuitoSubcircuitoRural {

    public static ArrayList<String> obtenerCircuitoRural() {
        ArrayList<String> lst = new ArrayList<String>();
        try {

            lst.add("CALPI");
            lst.add("LICTO");
            lst.add("PUNIN");
            lst.add("QUIMIAG");
            lst.add("SAN LUIS");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lst;
    }

    public static ArrayList<String> obtenerSubcircuitoRural() {
        ArrayList<String> lst = new ArrayList<String>();
        try {
            lst.add("CALPI 1");
            lst.add("LICTO 1");
            lst.add("LICTO 2");
            lst.add("PUNIN 1");
            lst.add("QUIMIAG 1");
            lst.add("SAN LUIS 1");
            lst.add("SAN LUIS 2");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lst;
    }
}
