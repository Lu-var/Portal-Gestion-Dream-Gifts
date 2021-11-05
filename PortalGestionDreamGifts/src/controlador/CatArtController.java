/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.CatArticuloManager;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.Maestro;

/**
 *
 * @author luvar
 */
public class CatArtController {

    
    public void showAll(Maestro master){
        
        CatArticuloManager mngr = new CatArticuloManager(); 
        
        JTable tabla = master.getTablaCatArt();
        ArrayList<ArrayList<Object>> lista = mngr.categoriaSelectAll();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        
        int i = 0;
        
        while(i<lista.size()){
            model.addRow(lista.get(i).toArray());
            i++;
        }
        
        
    }
    
}
