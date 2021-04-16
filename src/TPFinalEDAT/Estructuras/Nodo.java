
package TPFinalEDAT.Estructuras;

class Nodo {
    private Object elem;
    private Nodo enlace;
    //Constructores
    public Nodo(Object e,Nodo n){
        this.elem= e;
        this.enlace=n;
    }
    //Observadores
    public Object getElemento(){
        return this.elem;
    }
    public Nodo getEnlace(){
        return this.enlace;
    }
    //Modificadores
    public void setElem(Object e){
        this.elem=e;
    }
    public void setEnlace(Nodo n){
        this.enlace=n;
    }
}
