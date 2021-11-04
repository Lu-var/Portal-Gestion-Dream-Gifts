/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PC
 */
public class RRSS {
    private int isRRSS;
    private String nombre;
    private int enabled;

    public RRSS() {
    }

    public RRSS(int isRRSS, String nombre, int enabled) {
        this.isRRSS = isRRSS;
        this.nombre = nombre;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "RRSS{" + "isRRSS=" + isRRSS + ", nombre=" + nombre + ", enabled=" + enabled + '}';
    }

    public int getIsRRSS() {
        return isRRSS;
    }

    public void setIsRRSS(int isRRSS) {
        this.isRRSS = isRRSS;
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
