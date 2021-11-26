/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ComunaManager;
import modelo.ConfirmadasManager;
import modelo.PackManager;
import vista.Ventas;

/**
 *
 * @author luvar
 */
public class ConfirmadasController {
    
    ConfirmadasManager confirmadasManager = new ConfirmadasManager();
    PackManager packManager = new PackManager();
    ComunaManager comunaManager = new ComunaManager();
    
    public void showVentasConfirmadas(Ventas vista){
        ArrayList<ArrayList<Object>> listaVentas = confirmadasManager.selectVentasConfirmadas();
       
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaDespachos().getModel();
        
        listaVentas.forEach(columna -> {
            String hora = (String)columna.get(16) + " a " + (String)columna.get(17);
            Object[] temp = {columna.get(0), packManager.selectPackByID((Integer)columna.get(5)).get(1), columna.get(12), columna.get(11),comunaManager.comunaSelectByID((Integer)columna.get(15)).get(1), columna.get(14), hora};
            modelo.addRow(temp);
        });
    }
    
    public void showAll(Ventas vista){
        showVentasConfirmadas(vista);
    }
    
    public void clearAll(Ventas vista){
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaDespachos().getModel();
        modelo.setRowCount(0);
    }
    
}
