/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPFinalEDAT.Dominio;

import java.util.Objects;

public class ClaveVuelo implements Comparable {

    private String clave;

    public ClaveVuelo(String c) {
        this.clave = c;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.clave);
        return hash;
    }

    @Override
    public String toString() {
        return clave;
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
        final ClaveVuelo other = (ClaveVuelo) obj;
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        return true;
    }
    public int compareTo(Object otro) {
        int res;
        ClaveVuelo aux = (ClaveVuelo) otro;
        if (this.clave.compareTo(aux.clave) < 0) {
            res = -1;
        } else if (this.clave.compareTo(aux.clave) > 0) {
            res = 1;
        } else {
            res = 0;
        }
        return res;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
