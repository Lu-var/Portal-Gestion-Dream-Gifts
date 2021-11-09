/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioManager;
import vista.Maestro;

/**
 *
 * @author luvar
 */
public class UsuarioController {
    
        UsuarioManager manager = new UsuarioManager();
    
        public void agregarUsuario(Maestro vista){
        String nombre = vista.getTxtUsuario().getText();
        String pass = vista.getTxtPass().getText();
        manager.agregarUsuarioSQL(nombre, pass);
        }
        
        public void showAll(Maestro master){
        
        JTable tabla = master.getTablaUsuario();
        ArrayList<ArrayList<Object>> lista = manager.usuarioSelectAll();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        
        int i = 0;
        
        while(i<lista.size()){
            model.addRow(lista.get(i).toArray());
            i++;
        }
        
        
    }

    public void clearAll(Maestro master){
        JTable tabla = master.getTablaUsuario();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
    }        
    
}
