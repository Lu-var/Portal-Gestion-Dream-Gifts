/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.CategoriaArticulo;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.Maestro;

/**
 *
 * @author luvar
 */
public class CatArtController {

    
    public void showCategorias(Maestro master){
        
        CategoriaArticulo mngr = new CategoriaArticulo(); 
        
        JTable tabla = master.getTablaCatArt();
        ArrayList<ArrayList<Object>> lista = mngr.categoriaSelectAll();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        Object[] listaAux;
        
    }
    
}
