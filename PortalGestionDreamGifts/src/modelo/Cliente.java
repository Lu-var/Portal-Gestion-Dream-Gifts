/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Crowstone
 */
public class Cliente {
    
    private String rut;
    private String nombre;
    private String fNacimiento;
    private String celular;
    private String email;
    private String direccion;

    public Cliente() {
    }

    public Cliente(String rut, String nombre, String fNacimiento, String celular, String email, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.fNacimiento = fNacimiento;
        this.celular = celular;
        this.email = email;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" + "rut=" + rut + ", nombre=" + nombre + ", fNacimiento=" + fNacimiento + ", celular=" + celular + ", email=" + email + ", direccion=" + direccion + '}';
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
