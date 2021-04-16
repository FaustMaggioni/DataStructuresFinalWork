/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPFinalEDAT.Dominio;

import java.util.Objects;

public class Cliente {

    private ClaveCliente cc;
    private String nombre;
    private String apellido;
    private String tel;
    private String domicilio;

    public Cliente(String tipo, String nro, String nombre,String apellido,String tel,String domicilio) {
        this.cc= new ClaveCliente(tipo,nro);
        this.apellido=apellido;
        this.domicilio=domicilio;
        this.nombre=nombre;
        this.tel=tel;
    }
    public String getDomicilio(){
        return this.domicilio;
    }
    public String getNumeroTelefono(){
        return this.tel;
    }
    public String getTipo(){
    return this.cc.getTipo();
    }
    public String getNumeroDoc(){
        return this.cc.getNro();
    }
    public void setNumeroTelefono(String n){
        this.tel=n;
    }
    
    public void setNumero(String n){
        this.tel=n;
    }
    public void setDomicilio(String d){
        this.domicilio=d;
    }
    @Override
    public String toString(){
        return "Nombre: "+this.nombre+", Apellido: "+this.apellido+", "+this.cc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.cc);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cc, other.cc)) {
            return false;
        }
        return true;
    }
 
    
    

   

    
}
