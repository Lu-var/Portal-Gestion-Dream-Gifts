/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ComprasManager;
import vista.Compras;

/**
 *
 * @author nmoli
 */
public class controladorSolicitudPedido {
        ComprasManager manager = new ComprasManager();

    public void agregarSolicitud(Compras vista) {
        
        Date FechaOrden = vista.getDateRegistro().getDate();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaStr = formato.format(FechaOrden);
        String RutProveedor = vista.getTxtProveedor().getText();

        manager.agregarSolicitud(fechaStr, RutProveedor);
    }
        
    public void showAll(Compras vista){
        JTable tabla = vista.getTablaIngreso();
        ArrayList<ArrayList<Object>> lista = manager.ingresoSelectAllSQL();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        
        int i = 0;
        
        while(i<lista.size()){
            model.addRow(lista.get(i).toArray());
            i++;
        }
    }
    
    public void clearAll(Compras vista){
        JTable tabla = vista.getTablaIngreso();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        
        model.setRowCount(0);
    }

    public void agregarRegistro() {
        Compras vista = new Compras();
        
        int Cantidad = Integer.parseInt(vista.getTxtCantidadRegistro().getText());
        int Precio = Integer.parseInt(vista.getTxtPrecioRegistro().getText());
        Date FechaOrden = vista.getDateRegistroCompra().getDate();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaStr = formato.format(FechaOrden);

        manager.agregarRegistro(Cantidad, Precio, fechaStr);
    }

        }
    
    
    


