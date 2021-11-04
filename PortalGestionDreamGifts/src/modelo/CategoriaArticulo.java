/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PC
 */
public class CategoriaArticulo {
    
    private int idCategoriaArticulo;
    private String descripcion;
    private int enabled;

    public CategoriaArticulo() {
    }

    public CategoriaArticulo(int idCategoriaArticulo, String descripcion, int enabled) {
        this.idCategoriaArticulo = idCategoriaArticulo;
        this.descripcion = descripcion;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "CategoriaArticulo{" + "idCategoriaArticulo=" + idCategoriaArticulo + ", descripcion=" + descripcion + ", enabled=" + enabled + '}';
    }

    public int getIdCategoriaArticulo() {
        return idCategoriaArticulo;
    }

    public void setIdCategoriaArticulo(int idCategoriaArticulo) {
        this.idCategoriaArticulo = idCategoriaArticulo;
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
