/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import bd.Log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
        String FechaDespacho = no la tengo;
        String NombreTarget = vista.getTxtNDestinatario().getText();
        String CelularTarget = vista.getTxtTelefono().getText();
        String DireccionTarget = vista.getTxtDireccion().getText();
        int idComunaTarget = no la tengo;
        String FechaEntrega = no la tengo;
        String HoraDespachoIni = no la tengo;
        String HoraDespachoFin = no la tengo;
        int idStatusDespacho = no la tengo;
        
        String nombre = vista.getTxtNombreCliente().getText();
        String rut = vista.getTxtRutCliente().getText();
        String celular = vista.getTxtCelularCliente().getText();
        String email = vista.getTxtMailCliente().getText();
        
        Date fecha = vista.getDateNacCliente().getDate();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaStr = formato.format(fecha);
        
        venta.agregarVenta(Rut, Status, idRRSS, idBanco, idPack, TextoPack, ValorTotal, CodigoTransf, FechaIngreso, 
                FechaAprobada, FechaDespacho, NombreTarget,CelularTarget, DireccionTarget, idComunaTarget, FechaEntrega, HoraDespachoIni,
                HoraDespachoFin, idStatusDespacho);
        
    }
    
}