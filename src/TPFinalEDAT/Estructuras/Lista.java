package TPFinalEDAT.Estructuras;

public class Lista {

    private Nodo cabecera;
    private int longitud;

    //Constructor
    public Lista() {
        this.cabecera = null;
        this.longitud = 0;
        

    }

    //Modificadores
   public void eliminar(){
       this.eliminar(longitud);
   }
   
    public boolean insertar(Object nuevo, int pos) {
        boolean res = true;
        if (pos > this.longitud + 1 || pos < 1) {
            res = false;
        } else {
            if (pos == 1) {
                this.cabecera = new Nodo(nuevo, this.cabecera);
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevoNodo = new Nodo(nuevo, aux.getEnlace());
                aux.setEnlace(nuevoNodo);
            }
            this.longitud = this.longitud + 1;
            
        }
        return res;
    }

    public boolean eliminar(int pos) {
        boolean res = true;
        Nodo aux = this.cabecera;
        if (pos < 1 || pos >= this.longitud + 1) {
            res = false;
        } else {
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {

                for (int i = 1; i < pos - 1; i++) {
                    aux = aux.getEnlace();
                }
                aux.setEnlace(aux.getEnlace().getEnlace());

            }
            this.longitud--;
        }
        return res;

    }

    public Object recuperar(int pos) {
        Object res;
        Nodo aux = this.cabecera;

        if (pos < 1 || pos >= this.longitud + 1) {
            res = null;
        } else {
            int i = 1;
            while (aux.getEnlace() != null && i < pos) {
                aux = aux.getEnlace();
                i++;
            }
            res = aux.getElemento();
        }
        return res;

    }

    public int longitud() {
        return this.longitud;
    }

    public int localizar(Object elem) {

        int posicion = -1;
        boolean encontrado = false;
        Nodo aux = this.cabecera;
        int i = 1;
        if (this.cabecera != null) {
            while (encontrado != true && i != this.longitud + 1) {

                if (aux.getElemento().equals(elem)) {
                    encontrado = true;
                    posicion = i;
                } else {
                    aux = aux.getEnlace();
                    i++;
                }
            }
        }
        return posicion;
    }

    public Lista generarOtraLista(Lista lis) {
        Lista res = new Lista();
        Lista copia= lis.clone();
        
        Pila aux = new Pila();
        Cola ayu = new Cola();
        while(!copia.esVacia()){
            System.out.println("prueba arriba");
            System.out.println("Res: "+res.toString());
        while (!copia.esVacia() && (char)copia.recuperar(1) != '*') {
            res.insertar(copia.recuperar(1), res.longitud + 1);
            aux.apilar(copia.recuperar(1));
            ayu.poner(copia.recuperar(1));
            copia.eliminar(1);
            System.out.println("prueba");
        }

        while (aux.obtenerTope() != null) {
            res.insertar(aux.obtenerTope(), res.longitud + 1);
            aux.desapilar();
            System.out.println("prueba 2");
        }
        while (!ayu.esVacia()) {
            res.insertar(ayu.obtenerFrente(), res.longitud + 1);
            ayu.sacar();
            System.out.println("prueba 3");
        }
        if (!copia.esVacia()) {
            res.insertar('*', res.longitud + 1);
        }
        copia.eliminar(1);
        }
        return res;
    }

    public boolean esVacia() {
        return this.cabecera == null;
    }

    public void vaciar() {
        this.cabecera = null;
        this.longitud = 0;
    }

    @Override
    public String toString() {
        String s = "";
        if (this.cabecera == null) {
            s = "Lista vacía.";
        } else {
            Nodo aux = this.cabecera;
            s = "[";
            while(aux!=null) {
                s = s + aux.getElemento().toString()+".";

                aux = aux.getEnlace();

            }
            s = s + "]";
        }
        return s;
    }

    public Lista clone() {
        Lista c = new Lista();
        if (!this.esVacia()) {
            Nodo aux = this.cabecera;
            c.cabecera = new Nodo(aux.getElemento(), null);
            aux = aux.getEnlace();
            Nodo aux2 = c.cabecera;
            c.longitud = 1;
            while (aux != null) {
                aux2.setEnlace(new Nodo(aux.getElemento(), null));
                aux2 = aux2.getEnlace();
                aux = aux.getEnlace();
                c.longitud++;
            }

        }

        return c;
    }

    public void invertir() {
        invertirAux(this.cabecera, this);
    }

    private void invertirAux(Nodo nodo, Lista lista) {
        if (nodo != null) {
            this.cabecera = nodo;
            invertirAux(nodo.getEnlace(), lista);
            if (nodo.getEnlace() != null) {
                nodo.getEnlace().setEnlace(nodo);
            }
        }
    }

    public void eliminarApariciones(Object x) {
        while(this.cabecera.getElemento().equals(x)){
            this.cabecera=this.cabecera.getEnlace();
            this.longitud--;
        }
        Nodo aux= this.cabecera;
        while(aux.getEnlace()!=null){
            if(aux.getEnlace().getElemento().equals(x)){
                aux.setEnlace(aux.getEnlace().getEnlace());
                this.longitud--;
            }
            aux= aux.getEnlace();
        }
       
    }

    public Lista multiplos(int num) {

        Lista res = new Lista();
        Nodo aux1, aux2 = null;
        if (this.cabecera != null) {
            int pos = 1;
            aux1 = this.cabecera;
            //aux1 = aux1.getEnlace();
            //aux2 = res.cabecera;
            while (aux1 != null) {
                if (pos % num == 0) {
                    if (res.cabecera == null) {
                        res.cabecera = new Nodo(aux1.getElemento(), null);
                        aux2 = res.cabecera;
                    } else {
                        aux2.setEnlace(new Nodo(aux1.getElemento(), null));
                        aux2 = aux2.getEnlace();
                    }
                    res.longitud++;
                }
                aux1 = aux1.getEnlace();
                pos++;

            }
        }

        return res;

    }
    public boolean equals(Lista x){
        boolean res= true;
        Nodo aux= x.cabecera;
        Nodo aux2= this.cabecera;
        int i=1;
        if(x.longitud == this.longitud){
        while(aux!=null && res){
            res= aux.getElemento().equals(aux2.getElemento());
            aux= aux.getEnlace();
            aux2= aux2.getEnlace();
            i++;
        }
        }
        else{
            res=false;
        }
        return res;
    }
    /*  public int localizar(Object x){
        int pos=-1;
        int i=1;
        boolean listo=false;
        
        while(!listo && i<=this.longitud){
            listo= this.recuperar(i).equals(x);
            
            if(listo){
                pos= i;
            }else{
            i++;}
        }
        
        return pos;
    } */
}
