/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PC
 */
public class Comuna {
    
    private int idComuna;
    private String nombre;
    private int enabled;

    public Comuna() {
    }

    public Comuna(int idComuna, String nombre, int enabled) {
        this.idComuna = idComuna;
        this.nombre = nombre;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Comuna{" + "idComuna=" + idComuna + ", nombre=" + nombre + ", enabled=" + enabled + '}';
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    
    
}
