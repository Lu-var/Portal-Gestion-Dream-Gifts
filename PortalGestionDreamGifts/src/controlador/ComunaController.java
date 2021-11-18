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
    
    public void edit(Maestro master){
        
        int id;
        String nombre = new String();
        String status;
        boolean flagStatus;
        
        
        JTable tabla = master.getTablaComuna();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        int i = 0;
        int pos = tabla.getSelectedRow();
        Object input;
        try {
            Vector fila = (Vector)model.getDataVector().elementAt(pos);
            
            if((boolean)fila.get(2)){
                status = "Activado";
            }
            
            else{
                status = "Desactivado";
            }
            
            try {
                input = JOptionPane.showInputDialog(null, "Nueva Comuna", fila.get(1));
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

            input = JOptionPane.showConfirmDialog(null,"¿Activar esta Comuna? ","Estado Actual: " + status, JOptionPane.YES_NO_OPTION);
            if((int)input == JOptionPane.CLOSED_OPTION){
                JOptionPane.showMessageDialog(null, "Edición Cancelada", null, JOptionPane.INFORMATION_MESSAGE);
                return;
            }  
            flagStatus = (int)input == 0;
            
//            tabla.setValueAt(id, pos, 0);
            tabla.setValueAt(nombre, pos, 1);
            tabla.setValueAt(flagStatus, pos, 2);
            
            
                                            //cambiar por id
            manager.update((int)fila.get(0), (int)fila.get(0), nombre, flagStatus);
            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
            JOptionPane.showMessageDialog(null, "No hay fila seleccionada");
        }
    }    
    
}
