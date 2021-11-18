/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import bd.Log;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ArticuloManager;
import modelo.PackManager;
import modelo.CatPackManager;
import vista.Maestro;

/**
 *
 * @author luvar
 */
public class PackController {
    
    PackManager manager = new PackManager();
    ArticuloManager artManager = new ArticuloManager();
    CatPackManager catPackManager = new CatPackManager();
    
    public void showArticulos(Maestro vista){
        
        ArrayList<ArrayList<Object>> lista = artManager.articulosEnabledSelectAll();
        JTable tabla = vista.getTablaPacksArt();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).remove(0);
            lista.get(i).remove(1);
            lista.get(i).remove(1);
            lista.get(i).remove(1);
            modelo.addRow(lista.get(i).toArray());
        }
            
    }
    
    public void showCatPacks(Maestro vista){
        ArrayList<ArrayList<Object>> lista = new ArrayList<>();
        JComboBox combo = vista.getComboPacksCatArt();
        lista = catPackManager.categoriasEnabledSelectAll();
        
        for (int i = 0; i < lista.size(); i++) {
            combo.addItem(lista.get(i).get(1));
        }
    }
    
    public void showPacks(Maestro vista){
        JTable tabla = vista.getTablaPacks();
        ArrayList<ArrayList<Object>> lista = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        lista = manager.selectAllPackSQL();
        
        for (int i = 0; i < lista.size(); i++) {
            
        }
        
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(lista.get(i).toArray());
        }
    }
    
    public void showAll(Maestro vista){
        showArticulos(vista);
        showCatPacks(vista);
        showPacks(vista);
    }
    
    public void clearAll(Maestro vista){
        JComboBox combo = vista.getComboPacksCatArt();
        DefaultTableModel modeloArt = (DefaultTableModel)vista.getTablaPacksArt().getModel();
        DefaultTableModel modelo = (DefaultTableModel)vista.getTablaPacks().getModel();
        
        modeloArt.setRowCount(0);
        modelo.setRowCount(0);
        combo.removeAllItems();
    }
    
    public void agregarArticulosPack(Maestro vista){
        
        try {
            String articulo = "";
            articulo = (String)vista.getTablaPacksArt().getModel().getValueAt(vista.getTablaPacksArt().getSelectedRow(),0);
            
            if(articulo.isEmpty()){
                JOptionPane.showMessageDialog(null, "Seleccione un articulo.", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(vista.getTxtCantPackArt().getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad a agregar.", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            int cantidad = Integer.parseInt(vista.getTxtCantPackArt().getText());
            int idArticulo = artManager.selectArticuloSQL(articulo);
            
            JTable tablaPack = vista.getTablaPacksSelected();
            DefaultTableModel modelo = (DefaultTableModel) tablaPack.getModel();
            Object[] data = {idArticulo,cantidad,articulo};
        
            modelo.addRow(data);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Seleccione un articulo.", "", JOptionPane.INFORMATION_MESSAGE);
            Log.seguir(ex.getMessage());
        }
    }
    
    public void deleteArticulosPack(Maestro vista){

        JTable tablaPack = vista.getTablaPacksSelected();
        DefaultTableModel modelo = (DefaultTableModel) tablaPack.getModel();

        int index = tablaPack.getSelectedRow();
        modelo.removeRow(index);
    }
    
    public void agregarPack(Maestro vista){
        String nombre = new String();
        String categoria = new String();
        int precio = -1;
        JComboBox combo = vista.getComboPacksCatArt();
        combo.setSelectedIndex(0);
        try{
            nombre = vista.getTxtPacksNombre().getText();
            precio = Integer.parseInt(vista.getTxtPacksPrecio().getText());
            categoria = (String)combo.getSelectedItem();
        } catch(Exception ex){
            Log.seguir(ex.toString());
        }
        if(nombre.isEmpty()){
            JOptionPane.showMessageDialog(null, "Introduzca un nombre.", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        
        if(vista.getTxtPacksPrecio().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Introduzca un precio.", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int stock = 0;
        
        
        int idCategoria = 0;
        ArrayList<ArrayList<Object>> listaCategorias = catPackManager.categoriasEnabledSelectAll();
        for (int i = 0; i < listaCategorias.size(); i++) {
            if(((String)listaCategorias.get(i).get(1)).equals(categoria)){
                idCategoria = (Integer)listaCategorias.get(i).get(0);
            }
        }
        
        if(idCategoria == 0) Log.seguir("ID Categoria desconocido.");
        
        ArrayList<ArrayList<Integer>> contenido = new ArrayList<>();
        JTable tabla = vista.getTablaPacksSelected();
        
        if(tabla.getModel().getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Introduzca un articulo.", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }        
        
        for (int i = 0; i < tabla.getModel().getRowCount(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add((Integer)tabla.getValueAt(i, 0));
            temp.add((Integer)tabla.getValueAt(i, 1));
            contenido.add(temp);
        }
        
        manager.agregarPackSQL(nombre, precio, stock, idCategoria);
        manager.agregarContenidosSQL(contenido);
    }    
    
}
