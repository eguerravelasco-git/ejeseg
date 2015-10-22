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
public class Edades {

    public static ArrayList<RangoEdades> obtenerRangoEdades() {
        ArrayList<RangoEdades> lst = new ArrayList<RangoEdades>();
        try {
            lst.add(new RangoEdades("RANGO 1","1 - 12 años"));
            lst.add(new RangoEdades("RANGO 2","13 - 18 años"));
            lst.add(new RangoEdades("RANGO 3","19 - 30 años"));
            lst.add(new RangoEdades("RANGO 4","31 - 40 años"));
            lst.add(new RangoEdades("RANGO 5","41 - 50 años"));
            lst.add(new RangoEdades("RANGO 6","51 - 65 años"));
            lst.add(new RangoEdades("RANGO 7","mayo de 65 años"));
            lst.add(new RangoEdades("NA","Sin especificar"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lst;
    }

}
