/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.FlowLayout;
import java.util.Date;
import javax.swing.JComboBox;
import modelo.VentaManager;
import vista.Ventas;

/**
 *
 * @author nmoli
 */
public class VentaController {

    public static void cbxComuna() {
        
        
         
                
    }
    VentaManager venta = new VentaManager();
    
    public void agregarVenta(Ventas vista){
        
        String RUT = vista.getTxtRutVenta().getText();
        int Status = Integer.parseInt(vista.getTxtIdStatusVenta().getText());
        int idRRSS = Integer.parseInt(vista.getTxtRRSS().getText());
        int idBanco = Integer.parseInt(vista.getTxtIdBanco().getText());
        int idPack = Integer.parseInt(vista.getTxtIdPack().getText());
        String TextoPack = vista.getTxtSaludo().getText();
        int ValorTotal = Integer.parseInt(vista.getTxtValorTotal().getText());
        int CodigoTransf = Integer.parseInt(vista.getTxtCodigoTransferencia().getText());
        String FechaIngreso = vista.getTxtFechaIngreso().getText();
        String NombreTarget = vista.getTxtNDestinatario().getText();
        String CelularTarget = vista.getTxtTelefono().getText();
        String DireccionTarget = vista.getTxtDireccion().getText();
        /*int idComunaTarget = no la tengo; //combobox aprender a transformar
        String FechaEntrega = no la tengo; //combobox pendiente de aprender
        String HoraDespachoIni = no la tengo; // combobox pendiente de aprender
        String HoraDespachoFin = no la tengo; // combobox pendiente de aprender
        int idStatusDespacho = no la tengo; // combobox pendiente de aprender
        */
                
        venta.agregarVenta(RUT, Status, idRRSS, idBanco, idPack, TextoPack, ValorTotal, CodigoTransf, FechaIngreso, NombreTarget,CelularTarget, DireccionTarget);
        
    }
    
}