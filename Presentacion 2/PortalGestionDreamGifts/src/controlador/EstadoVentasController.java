/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.EstadoVentasManager;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.Maestro;

/**
 *
 * @author luvar
 */
public class EstadoVentasController {
    
    EstadoVentasManager manager = new EstadoVentasManager(); 
    
    public void agregarEstado(Maestro vista){
        String descripcion = vista.getTxtEstadoVenta().getText();
        manager.agregarEstadoSQL(descripcion);
    }

    
    public void showAll(Maestro master){
        
        JTable tabla = master.getTablaEstadoVenta();
        ArrayList<ArrayList<Object>> lista = manager.estadoSelectAll();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        
        int i = 0;
        
        while(i<lista.size()){
            model.addRow(lista.get(i).toArray());
            i++;
        }
        
        
    }
    
    public void clearAll(Maestro master){
        JTable tabla = master.getTablaEstadoVenta();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
    }
    
}
