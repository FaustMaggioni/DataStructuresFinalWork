package TPFinalEDAT.Estructuras;
public class NodoVert {
   private Object elem;
   private NodoVert sigVertice;
   private NodoAdy primerAdy;
   
   public NodoVert(Object e, NodoVert v, NodoAdy a){
       this.elem=e;
       this.primerAdy=a;
       this.sigVertice=v;
   }
   
   public Object getElem(){
       return this.elem;
   }
   public NodoVert getSigVertice(){
       return this.sigVertice;
   }
   public  NodoAdy getPrimerAdy(){
       return this.primerAdy;
   }
   
   public void setElem(Object e){
       this.elem=e;
   }
   public void setSigVertice(NodoVert v){
       this.sigVertice=v;
   }
   public void setPrimerAdy(NodoAdy a){
       this.primerAdy=a;
   }
   public boolean equals(NodoVert n){
       return this.elem.equals(n.elem);
   }
}

