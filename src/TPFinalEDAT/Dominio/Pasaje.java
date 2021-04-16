package TPFinalEDAT.Dominio;
public class Pasaje {
    private Vuelo vuelo;
    private String fecha;
    private String nroA;
    private int estado; // 0 = pendiente. -1 = cancelado. 1 = volado.
    
    public Pasaje(Vuelo v, String f, String n){
        this.vuelo=v;
        this.fecha=f;
        this.nroA=n;
        this.estado= 0;
    }
    public String toString(){
        return "Vuelo: "+this.vuelo+", Asiento: "+this.nroA;
    }
    
    public void setEstado(int n){
        this.estado=n;
    }
    public void setAsiento(String n){
        this.nroA=n;
    }
    public void setVuelo(Vuelo v){
        this.vuelo=v;
    }
    public Vuelo getVuelo(){
        return this.vuelo;
    }
    public String getCiudadDestino(){
        return this.vuelo.getDestino().getCiudad();
    }
            
    public String getAsiento(){
        return this.nroA;
    }
    public String getFecha(){
        return this.fecha;
    }
    public int getEstado(){
    return this.estado;
    }
}
