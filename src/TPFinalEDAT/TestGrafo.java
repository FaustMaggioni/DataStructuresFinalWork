/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPFinalEDAT;

import TPFinalEDAT.Estructuras.Grafo;

public class TestGrafo {
    public static void main (String[] args){
        Grafo g= new Grafo();
        for(int i=0; i<= 7;i++){
            g.insertarVertice(i);
        }
        g.insertarArco(6, 5, 333);
        g.insertarArco(6, 2, 657);
        g.insertarArco(6, 1, 800);
        g.insertarArco(3, 6, 0);
        g.insertarArco(4, 0, 221);
        g.insertarArco(4, 5, 1992);
        g.insertarArco(1, 3, 211);
        g.insertarArco(2, 0, 55);
        g.insertarArco(2, 1, 100);
        g.insertarArco(7, 1, 100);
        g.insertarArco(7, 4, 100);
        System.out.println(g.mostrar());
        boolean a= g.caminoEnXVuelos(6, 7, 10);
        System.out.println(g.caminoMasCorto(6, 4));
        System.out.println(a);
    }
}
