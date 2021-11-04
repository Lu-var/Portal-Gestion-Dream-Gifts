/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.Date;

/**
 *
 * @author PC
 */
public class DetalleFactura {
    private Facturas idFactura;
    private Articulo idArticulos;
    private int cantidad;
    private int total;
    private Date fechaVencimiento;

    public DetalleFactura() {
    }

    public DetalleFactura(Facturas idFactura, Articulo idArticulos, int cantidad, int total, Date fechaVencimiento) {
        this.idFactura = idFactura;
        this.idArticulos = idArticulos;
        this.cantidad = cantidad;
        this.total = total;
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "idFactura=" + idFactura + ", idArticulos=" + idArticulos + ", cantidad=" + cantidad + ", total=" + total + ", fechaVencimiento=" + fechaVencimiento + '}';
    }

    public Facturas getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Facturas idFactura) {
        this.idFactura = idFactura;
    }

    public Articulo getIdArticulos() {
        return idArticulos;
    }

    public void setIdArticulos(Articulo idArticulos) {
        this.idArticulos = idArticulos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
}
