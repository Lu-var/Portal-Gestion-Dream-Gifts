/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ComunaManager;
import vista.Maestro;
/**
 *
 * @author luvar
 */
public class ComunaController {
    ComunaManager manager = new ComunaManager();
    
    public void agregarComuna(Maestro vista){
        String nombre = vista.getTxtComuna().getText();
        manager.agregarComunaSQL(nombre);
    }
    
    public void showAll(Maestro master){
        
        JTable tabla = master.getTablaComuna();
        ArrayList<ArrayList<Object>> lista = manager.comunaSelectAll();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        
        int i = 0;
        
        while(i<lista.size()){
            model.addRow(lista.get(i).toArray());
            i++;
        }       
    }  
    
    public void clearAll(Maestro master){
        JTable tabla = master.getTablaComuna();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
    }
    
}
