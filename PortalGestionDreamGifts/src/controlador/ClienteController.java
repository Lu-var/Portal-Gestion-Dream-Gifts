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
import modelo.ClienteManager;
import vista.Maestro;

/**
 *
 * @author luvar
 */
public class ClienteController {
    
    ClienteManager manager = new ClienteManager();
    
    public void agregarCliente(Maestro vista){
        String nombre = vista.getTxtNombreCliente().getText();
        String rut = vista.getTxtRutCliente().getText();
        String celular = vista.getTxtCelularCliente().getText();
        String email = vista.getTxtMailCliente().getText();
        
        Date fecha = vista.getDateNacCliente().getDate();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaStr = formato.format(fecha);
        
        manager.agregarClienteSQL(rut, nombre, fechaStr, celular, email);
        
    }
    
    public void showAll(Maestro vista){
        JTable tabla = vista.getTablaClientes();
        ArrayList<ArrayList<Object>> lista = manager.clientesSelectAllSQL();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        
        int i = 0;
        
        while(i<lista.size()){
            model.addRow(lista.get(i).toArray());
            i++;
        }
    }
    
    public void clearAll(Maestro vista){
        JTable tabla = vista.getTablaClientes();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        
        model.setRowCount(0);
    }
    
}
