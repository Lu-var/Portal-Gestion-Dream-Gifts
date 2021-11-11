/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.EstadoDespachoManager;
import vista.Maestro;

/**
 *
 * @author luvar
 */
public class EstadoDespachoController {
    
    EstadoDespachoManager manager = new EstadoDespachoManager();
    
    public void agregarEstado(Maestro vista){
        String descripcion = vista.getTxtEstadoDespacho().getText();
        manager.agregarEstadoSQL(descripcion);
    }

    
    public void showAll(Maestro master){
        
        JTable tabla = master.getTablaEstadoDespacho();
        ArrayList<ArrayList<Object>> lista = manager.estadoSelectAll();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        
        int i = 0;
        
        while(i<lista.size()){
            model.addRow(lista.get(i).toArray());
            i++;
        }
        
        
    }
    
    public void clearAll(Maestro master){
        JTable tabla = master.getTablaEstadoDespacho();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
    }
    
}
