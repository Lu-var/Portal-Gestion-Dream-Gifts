/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deprecated.modelos;
import deprecated.modelos.Banco;
import deprecated.modelos.Status;
import deprecated.modelos.Pack;
import deprecated.modelos.Comuna;
import deprecated.modelos.Cliente;
import deprecated.modelos.StatusDespacho;
import deprecated.modelos.RRSS;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Venta {
    private int idVenta;
    private Cliente rutCliente;
    private Status idStatus;
    private RRSS idRRSS;
    private Banco idBanco;
    private Pack idPack;
    private String textoPack;
    private int valorTotal;
    private int codigoTansf;
    private Date fechaIngreso;
    private Date fechaAprobada;
    private Date fechaDespacho;
    private String nombreTarget;
    private String celularTarget;
    private String direccionTarget;
    private Comuna idComunaTarget;
    private Date fechaEntrega;
    private String horaDespachoIni;
    private String horaDespachoFin;
    private StatusDespacho idStatusDespacho;

    public Venta() {
    }

    public Venta(int idVenta, Cliente rutCliente, Status idStatus, RRSS idRRSS, Banco idBanco, Pack idPack, String textoPack, int valorTotal, int codigoTansf, Date fechaIngreso, Date fechaAprobada, Date fechaDespacho, String nombreTarget, String celularTarget, String direccionTarget, Comuna idComunaTarget, Date fechaEntrega, String horaDespachoIni, String horaDespachoFin, StatusDespacho idStatusDespacho) {
        this.idVenta = idVenta;
        this.rutCliente = rutCliente;
        this.idStatus = idStatus;
        this.idRRSS = idRRSS;
        this.idBanco = idBanco;
        this.idPack = idPack;
        this.textoPack = textoPack;
        this.valorTotal = valorTotal;
        this.codigoTansf = codigoTansf;
        this.fechaIngreso = fechaIngreso;
        this.fechaAprobada = fechaAprobada;
        this.fechaDespacho = fechaDespacho;
        this.nombreTarget = nombreTarget;
        this.celularTarget = celularTarget;
        this.direccionTarget = direccionTarget;
        this.idComunaTarget = idComunaTarget;
        this.fechaEntrega = fechaEntrega;
        this.horaDespachoIni = horaDespachoIni;
        this.horaDespachoFin = horaDespachoFin;
        this.idStatusDespacho = idStatusDespacho;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", rutCliente=" + rutCliente + ", idStatus=" + idStatus + ", idRRSS=" + idRRSS + ", idBanco=" + idBanco + ", idPack=" + idPack + ", textoPack=" + textoPack + ", valorTotal=" + valorTotal + ", codigoTansf=" + codigoTansf + ", fechaIngreso=" + fechaIngreso + ", fechaAprobada=" + fechaAprobada + ", fechaDespacho=" + fechaDespacho + ", nombreTarget=" + nombreTarget + ", celularTarget=" + celularTarget + ", direccionTarget=" + direccionTarget + ", idComunaTarget=" + idComunaTarget + ", fechaEntrega=" + fechaEntrega + ", horaDespachoIni=" + horaDespachoIni + ", horaDespachoFin=" + horaDespachoFin + ", idStatusDespacho=" + idStatusDespacho + '}';
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(Cliente rutCliente) {
        this.rutCliente = rutCliente;
    }

    public Status getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Status idStatus) {
        this.idStatus = idStatus;
    }

    public RRSS getIdRRSS() {
        return idRRSS;
    }

    public void setIdRRSS(RRSS idRRSS) {
        this.idRRSS = idRRSS;
    }

    public Banco getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Banco idBanco) {
        this.idBanco = idBanco;
    }

    public Pack getIdPack() {
        return idPack;
    }

    public void setIdPack(Pack idPack) {
        this.idPack = idPack;
    }

    public String getTextoPack() {
        return textoPack;
    }

    public void setTextoPack(String textoPack) {
        this.textoPack = textoPack;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getCodigoTansf() {
        return codigoTansf;
    }

    public void setCodigoTansf(int codigoTansf) {
        this.codigoTansf = codigoTansf;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaAprobada() {
        return fechaAprobada;
    }

    public void setFechaAprobada(Date fechaAprobada) {
        this.fechaAprobada = fechaAprobada;
    }

    public Date getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(Date fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public String getNombreTarget() {
        return nombreTarget;
    }

    public void setNombreTarget(String nombreTarget) {
        this.nombreTarget = nombreTarget;
    }

    public String getCelularTarget() {
        return celularTarget;
    }

    public void setCelularTarget(String celularTarget) {
        this.celularTarget = celularTarget;
    }

    public String getDireccionTarget() {
        return direccionTarget;
    }

    public void setDireccionTarget(String direccionTarget) {
        this.direccionTarget = direccionTarget;
    }

    public Comuna getIdComunaTarget() {
        return idComunaTarget;
    }

    public void setIdComunaTarget(Comuna idComunaTarget) {
        this.idComunaTarget = idComunaTarget;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getHoraDespachoIni() {
        return horaDespachoIni;
    }

    public void setHoraDespachoIni(String horaDespachoIni) {
        this.horaDespachoIni = horaDespachoIni;
    }

    public String getHoraDespachoFin() {
        return horaDespachoFin;
    }

    public void setHoraDespachoFin(String horaDespachoFin) {
        this.horaDespachoFin = horaDespachoFin;
    }

    public StatusDespacho getIdStatusDespacho() {
        return idStatusDespacho;
    }

    public void setIdStatusDespacho(StatusDespacho idStatusDespacho) {
        this.idStatusDespacho = idStatusDespacho;
    }
    
}
