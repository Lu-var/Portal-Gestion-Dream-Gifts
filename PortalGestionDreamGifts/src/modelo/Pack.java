/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author PC
 */
public class Pack {
    private int idPack;
    private String nombre;
    private int precio;
    private int stock;
    private CategoriaPack idCategoriaPack;
    private int enabled;

    public Pack() {
    }

    public Pack(int idPack, String nombre, int precio, int stock, CategoriaPack idCategoriaPack, int enabled) {
        this.idPack = idPack;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.idCategoriaPack = idCategoriaPack;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Pack{" + "idPack=" + idPack + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", idCategoriaPack=" + idCategoriaPack + ", enabled=" + enabled + '}';
    }

    public int getIdPack() {
        return idPack;
    }

    public void setIdPack(int idPack) {
        this.idPack = idPack;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public CategoriaPack getIdCategoriaPack() {
        return idCategoriaPack;
    }

    public void setIdCategoriaPack(CategoriaPack idCategoriaPack) {
        this.idCategoriaPack = idCategoriaPack;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    
}
