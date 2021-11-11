/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ArticuloManager;
import modelo.CatArticuloManager;
import vista.Maestro;

/**
 *
 * @author luvar
 */
public class ArticuloController {
    ArticuloManager manager = new ArticuloManager();
    CatArticuloManager catArtManager = new CatArticuloManager();
    
    public void agregarArticulo(Maestro vista){
        String nombre = vista.getTxtNombreArt().getText();
        
        Date fecha = vista.getDateFechaArt().getDate();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaStr = formato.format(fecha);
        
        int stock = Integer.parseInt(vista.getTxtUnidadesArt().getText());
        
        String categoria = (String)vista.getComboArtCat().getSelectedItem();
        int idCategoria = manager.selectIDArticuloSQL(categoria);
        manager.agregarArticuloSQL(nombre,fechaStr,stock,idCategoria);
    }
    
    public void showAll(Maestro master){
        
        JTable tabla = master.getTablaArticulos();
        ArrayList<ArrayList<Object>> lista = manager.articuloSelectAll();
        DefaultTableModel model =  (DefaultTableModel)tabla.getModel();
        
        int i = 0;
        
        while(i<lista.size()){
            model.addRow(lista.get(i).toArray());
            i++;
        }       
    }
    
    public void showAllCat(Maestro master){
        JComboBox<String> combo =  master.getComboArtCat();
        ArrayList<ArrayList<Object>> lista = catArtManager.categoriaSelectAll();
        
        int i = 0;
        
        while(i<lista.size()){
            combo.addItem((String)lista.get(i).get(1));
            i++;
        }
    }
    
    public void clearAll(Maestro master){
        JTable tabla = master.getTablaArticulos();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
        
        master.getComboArtCat().removeAllItems();
    }
}
