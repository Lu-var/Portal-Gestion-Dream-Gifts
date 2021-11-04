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
public class Facturas {
    private int idFactura;
    private Date fecha;
    private OrdenCompra idOrdenCompra;

    public Facturas() {
    }

    public Facturas(int idFactura, Date fecha, OrdenCompra idOrdenCompra) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.idOrdenCompra = idOrdenCompra;
    }

    @Override
    public String toString() {
        return "Facturas{" + "idFactura=" + idFactura + ", fecha=" + fecha + ", idOrdenCompra=" + idOrdenCompra + '}';
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public OrdenCompra getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(OrdenCompra idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }
    
}
