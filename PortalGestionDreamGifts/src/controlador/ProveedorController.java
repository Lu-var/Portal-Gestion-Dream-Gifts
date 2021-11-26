/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import bd.Log;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
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
        String email = vista.getTxtEmailProv().getText();
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
    
    public void edit(Maestro master){
        
        String razon = new String();
        String nombre = new String();
        String telefono = new String();
        String direccion = new String();
        String email = new String();
        String status = new String(); 
        boolean flagStatus = true;
        
        
        JTable tabla = master.getTablaProveedores();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        int i = 0;
        int pos = tabla.getSelectedRow();
        Object input;
        try {
            Vector fila = (Vector)model.getDataVector().elementAt(pos);
            
            if((boolean)fila.get(6)){
                status = "Activado";
            }
            
            else{
                status = "Desactivado";
            }
    
            try {
                input = JOptionPane.showInputDialog(null, "Nueva Razón Social proveedor", fila.get(1));
                razon = (String)input;
                if(razon.isEmpty()){
                    Log.seguir("Campo vacío.");
                    JOptionPane.showMessageDialog(null, "Campo Vacio",null,JOptionPane.INFORMATION_MESSAGE);
                    return;
            }
            } catch (java.lang.NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Edición Cancelada", null, JOptionPane.INFORMATION_MESSAGE);
                Log.seguir(ex.getMessage());
                return;
            }
            
            try {
                input = JOptionPane.showInputDialog(null, "Nuevo Nombre proveedor", fila.get(2));
                nombre = (String)input;
                if(nombre.isEmpty()){
                    Log.seguir("Campo vacío.");
                    JOptionPane.showMessageDialog(null, "Campo Vacio",null,JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            } catch (java.lang.NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Edición Cancelada", null, JOptionPane.INFORMATION_MESSAGE);
                Log.seguir(ex.getMessage());
                return;
            }

            try {
                input = JOptionPane.showInputDialog(null, "Nuevo Telefono proveedor", fila.get(3));
                telefono = (String)input;
                if(telefono.isEmpty()){
                    Log.seguir("Campo vacío.");
                    JOptionPane.showMessageDialog(null, "Campo Vacio",null,JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            } catch (java.lang.NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Edición Cancelada", null, JOptionPane.INFORMATION_MESSAGE);
                Log.seguir(ex.getMessage());
                return;
            }
            
            try {
                input = JOptionPane.showInputDialog(null, "Nueva Direccion proveedor", fila.get(4));
                direccion = (String)input;
                if(direccion.isEmpty()){
                    Log.seguir("Campo vacío.");
                    JOptionPane.showMessageDialog(null, "Campo Vacio",null,JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            } catch (java.lang.NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Edición Cancelada", null, JOptionPane.INFORMATION_MESSAGE);
                Log.seguir(ex.getMessage());
                return;
            }
            
            try {
                input = JOptionPane.showInputDialog(null, "Nuevo Email proveedor", fila.get(5));
                email = (String)input;
                if(email.isEmpty()){
                    Log.seguir("Campo vacío.");
                    JOptionPane.showMessageDialog(null, "Campo Vacio",null,JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            } catch (java.lang.NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Edición Cancelada", null, JOptionPane.INFORMATION_MESSAGE);
                Log.seguir(ex.getMessage());
                return;
            }                 
                        
            input = JOptionPane.showConfirmDialog(null,"¿Activar este Proveedor? ","Estado Actual: " + status, JOptionPane.YES_NO_OPTION);
            if((int)input == JOptionPane.CLOSED_OPTION){
                JOptionPane.showMessageDialog(null, "Edición Cancelada", null, JOptionPane.INFORMATION_MESSAGE);
                return;
            }  
            flagStatus = (int)input == 0;
            
            tabla.setValueAt(razon, pos, 1);
            tabla.setValueAt(nombre, pos, 2);
            tabla.setValueAt(telefono, pos, 3);
            tabla.setValueAt(direccion, pos, 4);            
            tabla.setValueAt(email, pos, 5);
            tabla.setValueAt(flagStatus, pos, 6);
                                            
            manager.update((String)fila.get(0), (String)razon, (String)nombre, (String)telefono, (String)direccion, (String)email,(boolean)flagStatus);
            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
            JOptionPane.showMessageDialog(null, "No hay fila seleccionada");
        }
    }
}
