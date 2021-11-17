/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ProveedorManager;
import vista.Maestro;

/**
 *
 * @author luvar
 */
public class ProveedorController {
    
    ProveedorManager manager = new ProveedorManager();
    
    public void agregarProveedor(Maestro vista){
        String razon = vista.getTxtRazonProv().getText();
        String rut = vista.getTxtRutProv().getText();
        String nombre = vista.getTxtNombreProv().getText();
        String celular = vista.getTxtFonoProv().getText();
        String email = vista.getTxtMailProv().getText();
        String direccion = vista.getTxtDireccionProv().getText();
        
        manager.agregarProvSQL(rut, razon, nombre, celular, direccion, email);
        
    }
    
    public void showAll(Maestro vista){
        JTable tabla = vista.getTablaProveedores();
        ArrayList<ArrayList<Object>> lista = manager.proveedorSelectAll();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        
        int i = 0;
        
        while(i<lista.size()){
            model.addRow(lista.get(i).toArray());
            i++;
        }
    }
    
    public void clearAll(Maestro vista){
        JTable tabla = vista.getTablaProveedores();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        
        model.setRowCount(0);
    }
}
