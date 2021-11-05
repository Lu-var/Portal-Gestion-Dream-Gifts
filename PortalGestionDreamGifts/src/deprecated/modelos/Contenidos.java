/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deprecated.modelos;


/**
 *
 * @author PC
 */
public class Contenidos {
    private Pack idPack;
    private Articulo idArticulo;
    private int cantidad;

    public Contenidos() {
    }

    public Contenidos(Pack idPack, Articulo idArticulo, int cantidad) {
        this.idPack = idPack;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Contenidos{" + "idPack=" + idPack + ", idArticulo=" + idArticulo + ", cantidad=" + cantidad + '}';
    }

    public Pack getIdPack() {
        return idPack;
    }

    public void setIdPack(Pack idPack) {
        this.idPack = idPack;
    }

    public Articulo getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
