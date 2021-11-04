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
public class OrdenCompra {
    private int idOrdenCompra;
    private Date fechaOrden;
    private Proveedor rutProveedor;

    public OrdenCompra() {
    }

    public OrdenCompra(int idOrdenCompra, Date fechaOrden, Proveedor rutProveedor) {
        this.idOrdenCompra = idOrdenCompra;
        this.fechaOrden = fechaOrden;
        this.rutProveedor = rutProveedor;
    }

    @Override
    public String toString() {
        return "OrdenCompra{" + "idOrdenCompra=" + idOrdenCompra + ", fechaOrden=" + fechaOrden + ", rutProveedor=" + rutProveedor + '}';
    }

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Proveedor getRutProveedor() {
        return rutProveedor;
    }

    public void setRutProveedor(Proveedor rutProveedor) {
        this.rutProveedor = rutProveedor;
    }
    
}
