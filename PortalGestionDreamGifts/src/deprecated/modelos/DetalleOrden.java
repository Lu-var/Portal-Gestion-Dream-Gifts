/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deprecated.modelos;


/**
 *
 * @author PC
 */
public class DetalleOrden {
    private OrdenCompra idOrdenCompra;
    private Articulo idArticulo;
    private int cantidad;
    private int precioUnitario;

    public DetalleOrden() {
    }

    public DetalleOrden(OrdenCompra idOrdenCompra, Articulo idArticulo, int cantidad, int precioUnitario) {
        this.idOrdenCompra = idOrdenCompra;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "DetalleOrden{" + "idOrdenCompra=" + idOrdenCompra + ", idArticulo=" + idArticulo + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + '}';
    }

    public OrdenCompra getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(OrdenCompra idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
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

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
}
