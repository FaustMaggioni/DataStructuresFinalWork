/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPFinalEDAT.Dominio;

import TPFinalEDAT.Estructuras.Lista;

public class Vuelo {

    private ClaveVuelo clave;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private int horaSalida;
    private int horaLlegada;
    private int asientos;
    private Lista viajes;

    public Vuelo(ClaveVuelo clave) {
        this.clave = clave;
    }

    public Vuelo(ClaveVuelo c, Aeropuerto origen, Aeropuerto d, int horaS, int horaLL, int a) {

        this.clave = c;
        this.origen = origen;
        this.destino = d;
        this.horaSalida = horaS;
        this.horaLlegada = horaLL;
        this.asientos = a;
        this.viajes = new Lista();
    }

    public Lista getViajes() {
        return this.viajes;
    }

    public String mostrarInfo() {
        String info = "Nombre: " + this.clave + "\n Origen: " + this.origen.getNombre() + "\n Destino: "
                + this.destino.getNombre() + "\n Hora de salida: " + this.horaSalida + "\n Hora de llegada: " + this.horaLlegada
                + " Cantidad de asientos totales: " + this.asientos;
        return info;
    }

    public boolean verificarClave(String clave) {
        boolean res = Character.isLetter(clave.charAt(0)) && !Character.isLowerCase(clave.charAt(0))
                && Character.isLetter(clave.charAt(1)) && !Character.isLowerCase(clave.charAt(1))
                && Character.isDigit(clave.charAt(2)) && Character.isDigit(clave.charAt(3)) && Character.isDigit(clave.charAt(4))
                && Character.isDigit(clave.charAt(5));
        return res;
    }

    public String toString() {
        return this.clave.toString();
    }

    public int getAsientosVendidos(String fecha) {
        Viaje aux = new Viaje(fecha);
        int p = this.viajes.localizar(aux);
        int cant = 0;
        if (p != -1) {
            cant = ((Viaje) this.viajes.recuperar(p)).getVendidos();
        } else {
            cant = -1;
        }
        return cant;
    }

    public int getAsientosTotales() {
        return this.asientos;
    }

    public void sumarVendidos(int suma, String fecha) {
        Viaje aux = new Viaje(fecha);
        int p = this.viajes.localizar(aux);
        int cant = 0;
        if (p != -1) {
            Viaje v = (Viaje) viajes.recuperar(p);
            v.sumarVendidos(suma);
        } else {
            Viaje nuevo = new Viaje(fecha, suma);
            viajes.insertar(nuevo, viajes.longitud() + 1);
        }
    }

    public void restarVendidos(int suma, String fecha) {
        Viaje aux = new Viaje(fecha);
        int p = this.viajes.localizar(aux);
        int cant = 0;
        if (p != -1) {
            Viaje v = (Viaje) viajes.recuperar(p);
            v.restarVendidos(suma);
        }
    }

    public boolean agregarViaje(String fecha, int suma) {
        boolean res = false;
        Viaje aux = new Viaje(fecha);
        if (viajes.localizar(aux) == -1) {
            viajes.insertar(new Viaje(fecha, 0), viajes.longitud() + 1);
            res = true;
        }
        return res;
    }

    public int getVendidos(String fecha) {
        int p = viajes.localizar(fecha);
        int res = -1;
        if (p != -1) {
            Viaje v = (Viaje) viajes.recuperar(p);
            res = v.getVendidos();
        }
        return res;
    }

    public boolean verificarFecha(String fecha) {
        Viaje aux= new Viaje(fecha);
        return viajes.localizar(aux) != -1;
    }

    public void setSalida(int h) {
        this.horaSalida = h;
    }

    public void setLlegada(int l) {
        this.horaSalida = l;
    }

    public String getClave() {
        return this.clave.toString();
    }

    public Aeropuerto getOrigen() {
        return this.origen;
    }

    public Aeropuerto getDestino() {
        return this.destino;
    }

    public int getHoraSalida() {
        return this.horaSalida;
    }

    public int getHoraLlegada() {
        return this.horaLlegada;
    }
}
