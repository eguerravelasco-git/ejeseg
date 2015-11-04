/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

/**
 *
 * @author Geovanny
 */
public class Casas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sumaIzq = 0, sumDer = 0, fin = 99;

        for (int i = 12; i < 99; i++) {
            System.out.println("NUMERO DE CASA: "+i);
            for (int j = i - 1; j >= 10; j--) {
                sumaIzq = sumaIzq + j;
                System.out.println("suma izquierda: " + sumaIzq);                
            }
            for (int k=i+1;k<99;k++){
                sumDer=sumDer+k;
                if(sumaIzq==sumDer){
                    System.out.println("sumatoria izquierda: "+sumaIzq);
                    System.out.println("Sumatoria derecha: "+sumDer);
                    System.out.println("vive en: "+i);
                    System.out.println("fin de la cuadra: "+k);
                    i=99;
                    k=99;
                }
            }
            sumaIzq=0;
            sumDer=0;
        }

    }

}
