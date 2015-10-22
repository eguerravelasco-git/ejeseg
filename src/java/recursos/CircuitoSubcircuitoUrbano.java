/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.util.ArrayList;

/**
 *
 * @author oscunach
 */
public class CircuitoSubcircuitoUrbano {

    public static ArrayList<String> obtenerCircuitoUrbano() {
        ArrayList<String> lst = new ArrayList<String>();
        try {
            lst.add("24 DE MAYO");
            lst.add("CAMILO PONCE");
            lst.add("CAMINOS AL SOL");
            lst.add("LA CONDAMINE");
            lst.add("LA ESTACION");
            lst.add("LA PAZ");
            lst.add("LA PRIMAVERA");
            lst.add("POLITECNICA");
            lst.add("PUCARA");
            lst.add("SAN ALFONSO");
            lst.add("SHOPPING");
            lst.add("TERMINAL TERRESTRE");
            lst.add("YARUQUIES");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lst;
    }

    public static ArrayList<String> obtenerSubcircuitoUrbano() {
        ArrayList<String> lst = new ArrayList<String>();
        try {
            lst.add("24 DE MAYO 1");
            lst.add("24 DE MAYO 2");
            lst.add("CAMILO PONCE 1");
            lst.add("CAMILO PONCE 2");
            lst.add("CAMINOS AL SOL 1");            
            lst.add("LA CONDAMINE 1");
            lst.add("LA CONDAMINE 2");
            lst.add("LA ESTACION 1");
            lst.add("LA ESTACION 2");
            lst.add("LA PAZ 1");
            lst.add("LA PAZ 2");
            lst.add("POLITECNICA 1");
            lst.add("POLITECNICA 2");
            lst.add("POLITECNICA 3");
            lst.add("LA PRIMAVERA 1");
            lst.add("PUCARA 1");
            lst.add("PUCARA 2");
            lst.add("SAN ALFONSO 1");
            lst.add("SAN ALFONSO 2");
            lst.add("SHOPPING 1");
            lst.add("TERMINAL TERRESTRE 1");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lst;
    }
}
