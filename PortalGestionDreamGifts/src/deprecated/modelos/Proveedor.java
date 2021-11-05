/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deprecated.modelos;

/**
 *
 * @author PC
 */
public class Proveedor {
   
    private String rut;
    private String razonSocial;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private int enabled;

    public Proveedor() {
    }

    public Proveedor(String rut, String razonSocial, String nombre, String telefono, String direccion, String email, int enabled) {
        this.rut = rut;
        this.razonSocial = razonSocial;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "rut=" + rut + ", razonSocial=" + razonSocial + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", email=" + email + ", enabled=" + enabled + '}';
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    
    
}
