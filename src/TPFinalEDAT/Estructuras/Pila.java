package TPFinalEDAT.Estructuras;

public class Pila {

    private Nodo tope;

    //Constructores
    public Pila() {
        this.tope = null;
    }

    //Modificadores
    public boolean apilar(Object elem) {
        Nodo nuevo = new Nodo(elem, this.tope);
        this.tope = nuevo;
        return true;
    }

    public boolean desapilar() {
        boolean res;
        if (this.tope == null) {
            res = false;
        } else {
            res = true;
            Nodo e = this.tope.getEnlace();
            Nodo aux = this.tope;
            this.tope = e;
            aux = null;
        }
        return res;
    }

    public void vaciar() {
        this.tope = null;
    }

    //Observadores
    public Object obtenerTope() {
        Object o;
        if (this.tope != null) {
            o = this.tope.getElemento();
        } else {
            o = null;
        }
        return o;
    }

    public boolean esVacia() {
        return this.tope == null;
    }

    //Propios del Tipo
    public Pila clone() {
        Pila c = new Pila();
        if(this.tope!=null){
            Nodo topeAux= this.tope;
            c.tope= new Nodo(topeAux.getElemento(),null);
            Nodo topeClonAux=c.tope;
            while(topeAux.getEnlace()!=null){
                topeClonAux.setEnlace(new Nodo(topeAux.getEnlace().getElemento(),null));
                topeClonAux=topeClonAux.getEnlace();
                topeAux=topeAux.getEnlace();
            }
        }
        return c;
    }

    public String toString() {
        String s = "";
        String res = "";
        if (this.tope == null) {

            s = "Pila vacia";
        } else {

            Nodo aux = this.tope;
            s = "]";
            while (aux != null) {
                s = aux.getElemento().toString() + s;
                aux = aux.getEnlace();
                if (aux != null) {
                    s = "," + s;
                }
            }
            s = "[" + s;
        }

        return s;
    }

    public boolean equals(Pila x) {
        boolean p = true;
        Nodo aux = this.tope;
        Nodo aux2= x.tope;
        while ((aux != null) && p) {
            p = aux2.getElemento().equals(aux.getElemento());
            aux2= aux2.getEnlace();
            aux = aux.getEnlace();
        }
        return p;
    }
}
