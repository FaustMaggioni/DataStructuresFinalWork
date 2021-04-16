/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPFinalEDAT.Dominio;

import java.util.Objects;

class Viaje {
    private String fecha;
    private int vendidos;

    public Viaje(String fecha, int vendidos) {
        this.fecha = fecha;
        this.vendidos = vendidos;
    }

    @Override
    public String toString() {
        return "Viaje{" + "fecha=" + fecha + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Viaje other = (Viaje) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }
    
    public Viaje(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public int getVendidos() {
        return vendidos;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setVendidos(int vendidos) {
        this.vendidos = vendidos;
    }
    public void restarVendidos(int v){
        this.vendidos=this.vendidos-v;
    }
     public void sumarVendidos(int v){
        this.vendidos=this.vendidos+v;
    }
}
