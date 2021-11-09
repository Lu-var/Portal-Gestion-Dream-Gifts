/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.RRSSManager;
import vista.Maestro;
/**
 *
 * @author luvar
 */
public class RRSSController {
    RRSSManager manager = new RRSSManager();
    
    public void agregarRRSS(Maestro vista){
        String nombre = vista.getTxtRRSS().getText();
        manager.agregarRRSSSQL(nombre);
    }
    
    public void showAll(Maestro master){
        
        JTable tabla = master.getTablaRRSS();
        ArrayList<ArrayList<Object>> lista = manager.rrssSelectAll();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        
        int i = 0;
        
        while(i<lista.size()){
            model.addRow(lista.get(i).toArray());
            i++;
        }       
    }  
    
    public void clearAll(Maestro master){
        JTable tabla = master.getTablaRRSS();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
    }
    
}
