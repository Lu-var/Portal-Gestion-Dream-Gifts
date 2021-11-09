/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deprecated.modelos;

/**
 *
 * @author PC
 */
public class CategoriaPack {
    
    private int idCategoriaPack;
    private String descripcion;
    private int enabled;

    public CategoriaPack() {
    }

    public CategoriaPack(int idCategoriaPack, String descripcion, int enabled) {
        this.idCategoriaPack = idCategoriaPack;
        this.descripcion = descripcion;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "CategoriaPack{" + "idCategoriaPack=" + idCategoriaPack + ", descripcion=" + descripcion + ", enabled=" + enabled + '}';
    }

    public int getIdCategoriaPack() {
        return idCategoriaPack;
    }

    public void setIdCategoriaPack(int idCategoriaPack) {
        this.idCategoriaPack = idCategoriaPack;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    
    
}
