package TPFinalEDAT.Estructuras;
class NodoAdy {
    private NodoVert vertice;
    private NodoAdy sigAdy;
    private Object etiq;
    
    public NodoAdy (NodoVert v, NodoAdy a, Object e){
        this.etiq=e;
        this.vertice= v;
        this.sigAdy= a;
    }
    
    public NodoVert getvertice(){
        return this.vertice;
    }
    
    public NodoAdy getSigAdy(){
        return this.sigAdy;
    }
    
    public Object getEtiqueta(){
        return this.etiq;
    }
    
    public void setVertice(NodoVert v){
        this.vertice=v;
    }
    public void setAdyacente(NodoAdy a){
        this.sigAdy=a;
    }
    public void setEtiqueta(Object e){
        this.etiq=e;
    }
}
