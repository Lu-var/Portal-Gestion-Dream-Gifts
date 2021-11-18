/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.VentaManager;
import vista.Ventas;

/**
 *
 * @author nmoli
 */
public class VentaController {
    VentaManager venta = new VentaManager();
    
    public void agregarVenta(Ventas vista){
        
        String RUT = vista.getTxtRutVenta().getText();
        int Status = vista.getTxtIdStatusVenta().getText();
        int idRRSS = vista.getTxtRRSS().getText();
        int idBanco = vista.getTxtIdBanco().getText();
        int idPack = vista.getTxtIdPack().getText();
        String TextoPack = vista.getTxtSaludo().getText();
        int ValorTotal = vista.getTxtValorTotal().getText();
        int CodigoTransf = vista.getTxtCodigoTransferencia().getText();
        String FechaIngreso = vista.getTxtFechaIngreso().getText();
        String FechaAprobada = vista.getTxtFechaAprobada().getText();
        Date FechaDespacho = vista.getFechaDespacho().getDate();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String NombreTarget = vista.getTxtNDestinatario().getText();
        String CelularTarget = vista.getTxtTelefono().getText();
        String DireccionTarget = vista.getTxtDireccion().getText();
        int idComunaTarget = no la tengo; //combobox
        String FechaEntrega = no la tengo; //combobox
        String HoraDespachoIni = no la tengo; // combobox
        String HoraDespachoFin = no la tengo; // combobox
        int idStatusDespacho = no la tengo; // combobox
        
        venta.agregarVenta(RUT, Status, idRRSS, idBanco, idPack, TextoPack, ValorTotal, CodigoTransf, FechaIngreso, 
                FechaAprobada, FechaDespacho, NombreTarget,CelularTarget, DireccionTarget, idComunaTarget, FechaEntrega, HoraDespachoIni,
                HoraDespachoFin, idStatusDespacho);
        
    }
    
}