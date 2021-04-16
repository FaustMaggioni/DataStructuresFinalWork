package TPFinalEDAT.Dominio;

import java.util.Objects;

public class ClaveCliente implements Comparable{

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.tipo);
        hash = 23 * hash + Objects.hashCode(this.nro);
        return hash;
    }

   public int compareTo(Object otro){
       int res;
       ClaveCliente aux= (ClaveCliente)otro;
       if(this.tipo.compareTo(aux.tipo)<0){
           res= -1;
       }else if(this.tipo.compareTo(aux.tipo)>0){
           res= 1;
       }else{
           if(this.nro.compareTo(aux.nro)<0){
               res=-2;
           }else if(this.nro.compareTo(aux.nro)>0){
               res=2;
           }else{
               res=0;
           }
       }
       return res;
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
        final ClaveCliente other = (ClaveCliente) obj;
        if (this.nro != other.nro) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }
    private String tipo;
    private String nro;
    
    public ClaveCliente(String t, String n){
        this.tipo= t ;
        this.nro= n;
    }
    
    public String toString(){
        return this.tipo+", "+this.nro;
    }
    


}
