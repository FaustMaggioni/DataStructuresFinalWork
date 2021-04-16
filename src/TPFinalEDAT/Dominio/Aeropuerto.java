package TPFinalEDAT.Dominio;

import TPFinalEDAT.Estructuras.Lista;
import java.util.Objects;

public class Aeropuerto {
    private String nombre;
    private int tel;
    private String ciudad;
    
    public Aeropuerto(String clave, int t, String c){
        this.ciudad=c;
        this.nombre=clave;
        this.tel=t;
    }
     public Aeropuerto(String clave){
        this.nombre=clave;
       
    }
    
    public int getTelefono(){
        return this.tel;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getCiudad(){
        return this.ciudad;
    }
    public void setNumero(int n){
        this.tel=n;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.ciudad);
        return hash;
    }

    @Override
   
   
    public String toString(){
        return this.nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aeropuerto other = (Aeropuerto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
}

