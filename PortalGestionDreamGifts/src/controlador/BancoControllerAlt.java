/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.BancoManagerAlt;
import vista.Maestro;

/**
 *
 * @author luvar
 */
public class BancoControllerAlt {
    BancoManagerAlt manager = new BancoManagerAlt();
    
    public void agregarBanco(Maestro vista){
        String nombre = vista.getTxtBanco().getText();
        manager.agregarBancoSQL(nombre);
    }
    
    public void showAll(Maestro master){
        
        JTable tabla = master.getTablaBanco();
        ArrayList<ArrayList<Object>> lista = manager.bancoSelectAll();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        
        int i = 0;
        
        while(i<lista.size()){
            model.addRow(lista.get(i).toArray());
            i++;
        }       
    }  
    
    public void clearAll(Maestro master){
        JTable tabla = master.getTablaBanco();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
    }
}
