
package TPFinalEDAT;

import TPFinalEDAT.Estructuras.TablaDeBusqueda;
import static TPFinalEDAT.SistemaViajes.getMinutos;
import static TPFinalEDAT.SistemaViajes.verificarClave;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestTBDB {
    public static void main(String []args){
       TablaDeBusqueda v= new TablaDeBusqueda();
       v.insertar("AA2337", 0);
       v.insertar("AA2337", 0);
    }
}
