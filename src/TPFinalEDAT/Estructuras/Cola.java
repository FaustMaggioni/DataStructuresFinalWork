
package TPFinalEDAT.Estructuras;

public class Cola {
    private Nodo frente;
    private Nodo fin;
    //Constructor
    public Cola(){
        this.fin= null;
        this.frente= null;
    }
    //Modificadores
    public boolean poner(Object x){
        Nodo n= new Nodo(x,null);
        if(this.frente==null){
            this.frente=n;
            this.fin=n;
        }else{
            this.fin.setEnlace(n);
            this.fin=n;
        }
         return true;
    }
    public boolean sacar(){
       boolean res=true;
       if(this.frente==null){
           res=false;
       }else{
           this.frente=this.frente.getEnlace();
           if(this.frente==null){
               this.fin=null;
           }
       }
       
       return res;
    }
    public void vaciar(){
        this.frente=null;
    }
    //Observadores
    public Object obtenerFrente(){
        Object res=null;
        if(this.frente!=null){
            res= this.frente.getElemento();
        }
        return res;
    }
    public boolean esVacia(){
        return this.frente==null;
    }
    //Propias del Tipo
    @Override
    public Cola clone(){
        Cola c= new Cola();
        if(!this.esVacia()){
        Nodo aux= this.frente;
        c.frente=new Nodo(aux.getElemento(),null);
        aux=aux.getEnlace();
        Nodo aux2=c.frente;
        while(aux !=null){
            aux2.setEnlace(new Nodo(aux.getElemento(),null));
            aux2=aux2.getEnlace();
            aux=aux.getEnlace();
        }
        c.fin= aux2;
        } else{
            c=null;
        }
        
        return c;
    }
    @Override
    public String toString(){
        String s="Cola vacia.";
        Nodo aux= this.frente;
        if(this.frente!=null){
            boolean sigue=false;
            s="[";
        while(!sigue){
            s= s+aux.getElemento()+",";
            sigue=aux.getEnlace()==null;
            aux=aux.getEnlace();
            
        }
        s=s+"]";
    }
    return s;
}
public boolean equals(Cola otra){
    boolean igual;
    
    igual= (this.fin.getElemento().equals(otra.fin.getElemento())&&(this.frente.getElemento().equals(otra.frente.getElemento())));
    boolean parar=false;
    Nodo aux1= this.frente;
    Nodo aux2= otra.frente;
    aux1=this.frente.getEnlace();
    aux2=otra.frente.getEnlace();
    while((igual)&&(!parar)){
        igual= aux1.getElemento().equals(aux2.getElemento());
        aux1=aux1.getEnlace();
        aux2=aux2.getEnlace();
        if(aux1==null && aux2==null){
            parar=true;
        }
    }
    return igual;
}}
