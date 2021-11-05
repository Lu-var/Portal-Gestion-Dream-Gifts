/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deprecated.modelos;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Articulo {
    
    private int idArticulo;
    private String nombre;
    private Date fechaVencimiento;
    private int stock;
    private int precio;

    public Articulo() {
    }

    public Articulo(int idArticulo, String nombre, Date fechaVencimiento, int stock, int precio) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.fechaVencimiento = fechaVencimiento;
        this.stock = stock;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Articulo{" + "idArticulo=" + idArticulo + ", nombre=" + nombre + ", fechaVencimiento=" + fechaVencimiento + ", stock=" + stock + ", precio=" + precio + '}';
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
}
