package TPFinalEDAT.Estructuras;

import TPFinalEDAT.Estructuras.Cola;
import TPFinalEDAT.Estructuras.Lista;
import TPFinalEDAT.Dominio.Aeropuerto;

public class Grafo {

    private NodoVert inicio;

    public Grafo() {
        this.inicio = null;;
    }

    public String mostrar() {
        String res = mostrarAux(this.inicio, "");
        return res;
    }

    private String mostrarAux(NodoVert n, String s) {
        while (n != null) {
            s = s + n.getElem();
            NodoAdy aux = n.getPrimerAdy();
            if (aux != null) {
                while (aux != null) {
                    s = s + "------" + aux.getEtiqueta() + "------> " + aux.getvertice().getElem();
                    s = s + "\n";
                    aux = aux.getSigAdy();
                }
            } else {
                s = s + " No tiene adyacentes.\n";
            }
            s = s + "°°°°°°°°°°°°°°°°°\n";
            n = n.getSigVertice();
        }

        return s;

    }

    public boolean caminoEnXVuelos(Object o, Object d, int cant) {
        NodoVert origen = this.ubicarVertice(o);
        boolean res = false;
        if (origen != null) {
            Lista actual = new Lista();
            res = caminoEnXAux(origen, d, cant, actual, new Lista(), res);
        }
        return res;
    }

    private boolean caminoEnXAux(NodoVert n, Object destino, int cant, Lista actual, Lista res, boolean b) {
        if (n != null) {

            actual.insertar(n.getElem(), actual.longitud() + 1);
            if (n.getElem().equals(destino)) {
                if (res.esVacia()) {
                    res = actual.clone();
                } else {
                    if (res.longitud() < actual.longitud()) {
                        //masLargo.vaciar();
                        res = actual.clone();
                    }
                }
                if (res.longitud() - 1 <= cant) {
                    b = true;
                }
            } else {
                NodoAdy ady = n.getPrimerAdy();
                while (!b && ady != null && (actual.longitud() - 1 <= cant || res.esVacia())) {
                    if (actual.localizar(ady.getvertice().getElem()) < 0) {
                        b = caminoEnXAux(ady.getvertice(), destino, cant, actual, res, b);
                    }
                    ady = ady.getSigAdy();
                }
            }
            actual.eliminar(actual.longitud());

        }
        return b;
    }

    public boolean insertarVertice(Object e) {
        boolean res = false;
        NodoVert aux = this.ubicarVertice(e);
        if (aux == null) {
            this.inicio = new NodoVert(e, this.inicio, null);
            res = true;
        }
        return res;
    }

    private NodoVert ubicarVertice(Object e) {
        NodoVert aux = this.inicio;
        while (aux != null && !aux.getElem().equals(e)) {
            aux = aux.getSigVertice();
        }
        return aux;
    }

    public Lista getEtiqueta(Object origen, Object destino) {
        NodoVert or = this.ubicarVertice(origen);
        NodoVert des = this.ubicarVertice(destino);
        NodoAdy aux = or.getPrimerAdy();
        int res = 0;
        Lista n = new Lista();
        int i = 1;
        while (aux != null) {
            if (aux.getvertice().equals(des)) {
                res = (int) aux.getEtiqueta();
                n.insertar(res, i);
                i++;
            }
            aux = aux.getSigAdy();

        }
        return n;
    }

    public Object getElemento(Object e) {
        Object res = this.ubicarVertice(e).getElem();

        return res;
    }

    public boolean existeCamino(Object e, Object e2) {
        boolean res = false;
        NodoVert aux = this.ubicarVertice(e);
        if (aux != null) {
            NodoAdy a = aux.getPrimerAdy();
            res = existeAux(a, e2, new Lista());
        }
        return res;
    }

    private boolean existeAux(NodoAdy a, Object e, Lista p) {
        boolean res = false;
        if (a != null) {
            p.insertar(a.getvertice().getElem(), p.longitud() + 1);
            res = a.getvertice().getElem().equals(e);
            if (!res) {
                res = existeAux(a.getSigAdy(), e, p);
                if (!res) {
                    if (p.localizar(a.getvertice().getPrimerAdy().getvertice().getElem()) == -1) {
                        res = existeAux(a.getvertice().getPrimerAdy(), e, p);
                    }
                }
            }
        }
        return res;
    }

    public Lista caminoMasCorto(Object origen, Object destino) {
        Lista masLargo = new Lista();
        NodoVert verticeOr = ubicarVertice(origen);
        if (verticeOr != null) {
            Lista masLargoActual = new Lista();
            masLargo = caminoMasCortoAux(verticeOr, destino, masLargo, masLargoActual);
        }
        return masLargo;
    }

    private Lista caminoMasCortoAux(NodoVert n, Object destino, Lista masLargo, Lista masLargoActual) {
        if (n != null) {

            masLargoActual.insertar(n.getElem(), masLargoActual.longitud() + 1);
            if (n.getElem().equals(destino)) {
                if (masLargo.esVacia()) {
                    masLargo = masLargoActual.clone();
                } else {
                    if (masLargo.longitud() > masLargoActual.longitud()) {
                        masLargo.vaciar();
                        masLargo = masLargoActual.clone();
                    }
                }
            } else {
                NodoAdy ady = n.getPrimerAdy();
                while (ady != null && (masLargoActual.longitud() < masLargo.longitud() || masLargo.esVacia())) {
                    if (masLargoActual.localizar(ady.getvertice().getElem()) < 0) {
                        masLargo = caminoMasCortoAux(ady.getvertice(), destino, masLargo, masLargoActual);
                    }
                    ady = ady.getSigAdy();
                }
            }
            masLargoActual.eliminar(masLargoActual.longitud());

        }
        return masLargo;
    }

    public Lista liviano(Object origen, Object destino) {
        Lista menorPeso = new Lista();
        NodoVert verticeOr = this.ubicarVertice(origen);
        if (verticeOr != null) {
            NodoAdy auxAd = verticeOr.getPrimerAdy();
            Lista masLargoActual = new Lista();
            menorPeso = new Lista();
            menorPeso = livianoAux(verticeOr, destino, new NodoSuma(0), new NodoSuma(0), menorPeso, masLargoActual);

        }
        return menorPeso;
    }

    private Lista livianoAux(NodoVert n, Object destino, NodoSuma sumaMenor, NodoSuma sumaActual, Lista menor, Lista actual) {
        if (n != null) {
            actual.insertar(n.getElem(), actual.longitud() + 1);
            if (n.getElem().equals(destino)) {
                if (sumaMenor.getValor() == 0) {
                    sumaMenor.setValor(sumaActual.getValor());
                    menor = actual.clone();
                    //sumaActual.setValor(0);

                } else {
                    if (sumaActual.getValor() <= sumaMenor.getValor()) {

                        sumaMenor.setValor(sumaActual.getValor());

                        //sumaActual.setValor(0);
                        menor = actual.clone();
                    }
                }
            } else {
                NodoAdy aux = n.getPrimerAdy();
                while (aux != null && (((int) sumaActual.getValor() < (int) sumaMenor.getValor()) || (int) sumaMenor.getValor() == 0)) {
                    if (actual.localizar(aux.getvertice().getElem()) == -1) {
                        sumaActual.setValor(sumaActual.getValor() + (int) aux.getEtiqueta());
                        menor = livianoAux(aux.getvertice(), destino, sumaMenor, sumaActual, menor, actual);
                        sumaActual.setValor(sumaActual.getValor() - (int) aux.getEtiqueta());
                    }
                    aux = aux.getSigAdy();
                }

            }
            actual.eliminar();
        }
        return menor;
    }

    public void setEtiqueta(Object origen, Object destino, int etiq) {
        NodoVert o = this.ubicarVertice(origen);
        NodoVert d = this.ubicarVertice(destino);
        if (o != null && d != null) {
            NodoAdy aux = o.getPrimerAdy();
            boolean ok = false;
            while (!ok) {
                ok = aux.getvertice().equals(d);
            }
            aux.setEtiqueta(etiq);
        }
    }

    public Lista caminoMasLargo(Object origen, Object destino) {
        Lista masLargo = new Lista();
        NodoVert verticeOr = ubicarVertice(origen);
        if (verticeOr != null) {
            Lista visitados = new Lista();
            Lista masLargoActual = new Lista();
            masLargo = caminoMasLargoAux(verticeOr, destino, visitados, masLargo, masLargoActual);
        }
        return masLargo;
    }

    private Lista caminoMasLargoAux(NodoVert n, Object destino, Lista vis, Lista masLargo, Lista masLargoActual) {
        if (n != null) {
            vis.insertar(n.getElem(), vis.longitud() + 1);
            masLargoActual.insertar(n.getElem(), masLargoActual.longitud() + 1);
            if (n.getElem().equals(destino)) {
                if (masLargo.longitud() < masLargoActual.longitud()) {
                    masLargo.vaciar();
                    masLargo = masLargoActual.clone();
                }
            } else {
                NodoAdy ady = n.getPrimerAdy();
                while (ady != null) {
                    if (vis.localizar(ady.getvertice().getElem()) < 0) {
                        masLargo = caminoMasLargoAux(ady.getvertice(), destino, vis, masLargo, masLargoActual);
                    }
                    ady = ady.getSigAdy();
                }
            }
            masLargoActual.eliminar(masLargoActual.longitud());
            vis.eliminar(vis.longitud());
        }
        return masLargo;
    }

    public boolean insertarArco(Object e, Object e2, int etiq) {
        boolean res = false;
        NodoVert aux = this.ubicarVertice(e);
        if (aux != null) {
            NodoVert aux2 = this.ubicarVertice(e2);
            if (aux2 != null) {
                res = true;
                if (aux.getPrimerAdy() == null) {
                    aux.setPrimerAdy(new NodoAdy(aux2, null, etiq));
                } else {
                    NodoAdy a = aux.getPrimerAdy();
                    while (a.getSigAdy() != null) {
                        a = a.getSigAdy();
                    }
                    a.setAdyacente(new NodoAdy(aux2, null, etiq));
                }
                if (aux2.getPrimerAdy() == null) {
                    aux2.setPrimerAdy(new NodoAdy(aux, null, etiq));
                } else {
                    NodoAdy b = aux2.getPrimerAdy();
                    while (b.getSigAdy() != null) {
                        b = b.getSigAdy();
                    }
                    b.setAdyacente(new NodoAdy(aux, null, etiq));
                }
            }
        }
        return res;
    }

    public boolean existeArco(Object e, Object e2) {
        boolean res = false;
        NodoVert aux = this.ubicarVertice(e);
        if (aux != null) {
            NodoVert aux2 = this.ubicarVertice(e2);
            if (aux2 != null) {
                NodoAdy ayuda = aux.getPrimerAdy();
                while (ayuda != null && !res) {
                    res = ayuda.getvertice().getElem().equals(e2);
                    if (!res) {
                        ayuda = ayuda.getSigAdy();
                    }
                }
            }
        }
        return res;
    }

    public boolean eliminarVertice(Object e) {
        boolean res = false;
        NodoVert v = this.ubicarVertice(e);
        if (v != null) {
            res = true;
            NodoAdy aux = v.getPrimerAdy();
            while (aux != null) {
                NodoVert destino = aux.getvertice();
                NodoAdy aux2 = destino.getPrimerAdy();
                if (aux2.getvertice().getElem().equals(e)) {
                    destino.setPrimerAdy(aux2.getSigAdy());
                } else {
                    while (aux2.getSigAdy() != null) {
                        if (aux2.getSigAdy().getvertice().getElem().equals(e)) {
                            aux2.setAdyacente(aux2.getSigAdy().getSigAdy());
                        } else {
                            aux2 = aux2.getSigAdy();
                        }
                    }
                }
                aux = aux.getSigAdy();
            }
            v = this.inicio;
            if (v.getElem().equals(e)) {
                this.inicio = v.getSigVertice();
            } else {
                while (v.getSigVertice() != null) {
                    if (v.getSigVertice().getElem().equals(e)) {
                        v.setSigVertice(v.getSigVertice().getSigVertice());
                    } else {
                        v = v.getSigVertice();
                    }
                }
            }
        }
        return res;
    }

    public boolean existeVertice(Object e) {
        boolean res = false;
        NodoVert aux = this.ubicarVertice(e);
        res = aux != null;
        return res;
    }

    public boolean eliminarArco(Object e, Object e2, int etiq) {
        boolean res = false;
        NodoVert aux = this.inicio;
        NodoVert origen = this.ubicarVertice(e);
        NodoVert destino = this.ubicarVertice(e2);
        if (origen != null && destino != null) {
            res = true;
            NodoAdy a = origen.getPrimerAdy();
            if (a.getvertice().getElem().equals(e2) && a.getEtiqueta().equals(etiq)) {
                eliminarB(destino, e, etiq);
                origen.setPrimerAdy(a.getSigAdy());
            } else {
                while (a.getSigAdy() != null) {
                    if (a.getSigAdy().getvertice().getElem().equals(e2) && a.getEtiqueta().equals(etiq)) {
                        eliminarB(destino, e, etiq);
                        a.setAdyacente(a.getSigAdy().getSigAdy());
                    }
                    a = a.getSigAdy();

                }

            }
        }
        return res;
    }

    private void eliminarB(NodoVert destino, Object e, int etiq) {
        NodoAdy b = destino.getPrimerAdy();
        if (b.getvertice().getElem().equals(e) && b.getEtiqueta().equals(etiq)) {
            destino.setPrimerAdy(b.getSigAdy());
        } else {
            while (b.getSigAdy() != null) {
                if (b.getSigAdy().getvertice().getElem().equals(e) && b.getEtiqueta().equals(etiq)) {
                    b.setAdyacente(b.getSigAdy().getSigAdy());
                }
                b = b.getSigAdy();

            }
        }
    }

    public boolean esVacio() {
        return this.inicio == null;
    }

    public Lista enProfundidad() {
        Lista visitados = new Lista();
        NodoVert aux = this.inicio;
        while (aux != null) {
            if (visitados.localizar(aux.getElem()) == -1) {
                profDesde(aux, visitados);
            }
            aux = aux.getSigVertice();
        }
        return visitados;
    }

    private void profDesde(NodoVert u, Lista visita) {
        visita.insertar(u.getElem(), visita.longitud() + 1);
        NodoAdy aux = u.getPrimerAdy();
        while (aux != null) {
            if (visita.localizar(aux.getvertice().getElem()) == -1) {
                profDesde(aux.getvertice(), visita);
            }
            aux = aux.getSigAdy();
        }
    }

    public Lista enAnchura() {
        Lista visitados = new Lista();
        NodoVert aux = this.inicio;
        while (aux != null) {
            if (visitados.localizar(aux.getElem()) == -1) {
                anchDesde(aux, visitados);
            }
            aux = aux.getSigVertice();
        }
        return visitados;
    }

    private void anchDesde(NodoVert vertInicial, Lista visitados) {
        Cola q = new Cola();
        visitados.insertar(vertInicial.getElem(), visitados.longitud() + 1);
        q.poner(vertInicial);
        while (!q.esVacia()) {
            NodoVert u = (NodoVert) q.obtenerFrente();
            q.sacar();
            NodoAdy v = u.getPrimerAdy();
            while (v != null) {
                if (visitados.localizar(v.getvertice().getElem()) == -1) {
                    visitados.insertar(v.getvertice().getElem(), visitados.longitud() + 1);
                    q.poner(v.getvertice());
                }
                v = v.getSigAdy();
            }
            if (v == null) {
                q.vaciar();
            }
        }
    }

    public String toString() {
        String res = "";
        NodoVert aux = this.inicio;
        while (aux != null) {
            res = res + "Vertice: " + aux.getElem() + " Adyacentes: ";
            NodoAdy a = aux.getPrimerAdy();
            while (a != null) {
                res = res + a.getvertice().getElem() + " Etiqueta: " + a.getEtiqueta() + ". ";
                a = a.getSigAdy();
            }
            aux = aux.getSigVertice();
            res = res + " \n";
        }
        return res;
    }

}
