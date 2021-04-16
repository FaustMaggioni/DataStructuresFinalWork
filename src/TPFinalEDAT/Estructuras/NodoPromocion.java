
package TPFinalEDAT.Estructuras;

import TPFinalEDAT.Dominio.ClaveCliente;

class NodoPromocion {
    private ClaveCliente clave;
    private Comparable cant;
    
    public NodoPromocion(String tipo,String n, Comparable cant){
        this.clave=new ClaveCliente(tipo,n);
        this.cant=cant;
    }
    public NodoPromocion(ClaveCliente c,Comparable cant){
        this.clave=c;
        this.cant=cant;
    }
    
    public void setTipo(String c){
        this.clave.setTipo(c);
    }
    public void setNro(String n){
        this.clave.setNro(n);
    }
    public void setCant(int cant){
        this.cant=cant;
    }
    public Comparable getCant(){
        return this.cant;
    }
    public String getClave(){
        return this.clave.toString();
    }
    public String toString(){
        return this.clave.toString();
    }
    public int compareTo(NodoPromocion otro){
        int res=0;
        if(this.cant.compareTo(otro.cant)>0){
            res=1;
        }else{
            if(this.cant.compareTo(otro.cant)<0){
                res=-1;
            }
        }
           return res;
    }
}
