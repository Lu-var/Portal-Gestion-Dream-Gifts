/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import bd.Log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
    
    public void showDate(Maestro vista){
        if(vista.getCheckArticulo().isSelected()){
            vista.getDateFechaArt().setEnabled(false);
        }
        else{vista.getDateFechaArt().setEnabled(true);}
    }
    
    public void agregarArticulo(Maestro vista){
        String nombre = vista.getTxtNombreArt().getText();
        String fechaStr = "No Expira";
        
        if(!vista.getCheckArticulo().isSelected()){
            Date fecha = vista.getDateFechaArt().getDate();
            DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            fechaStr = formato.format(fecha);
        } else{vista.getDateFechaArt().setEnabled(false);}
        
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
    
    public void edit(Maestro master){
        
        int id;
        String nombre = new String();
        String catArt = new String();
        int stock = 0;
        String fecha = new String();
        String status;
        boolean flagStatus;        
        
        JTable tabla = master.getTablaArticulos();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        int i = 0;
        int pos = tabla.getSelectedRow();
        Object input;
        try {
            Vector fila = (Vector)model.getDataVector().elementAt(pos);
            
            if((boolean)fila.get(5)){
                status = "Activado";
            }
            
            else{
                status = "Desactivado";
            }
            
//            input = JOptionPane.showInputDialog(null, "Nuevo ID", fila.get(0));
//            id = Integer.valueOf((String)input);
//            for (int j = 0; j < model.getRowCount(); j++) {
//                int get = (int)model.getValueAt(j, 0);
//                if(get==id && id != (int)fila.get(0)){
//                    Log.seguir("ID Ocupado.");
//                    JOptionPane.showMessageDialog(null, "ID Ocupado.");
//                    return;
//                }
//            }
            try {
                input = JOptionPane.showInputDialog(null, "Nuevo Articulo", fila.get(1));
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

            try {
                
                ArrayList<Object> lista = new ArrayList<>();
                ArrayList<ArrayList<Object>> arregloCat = catArtManager.categoriaSelectAll();
                for (int j = 0; j < arregloCat.size(); j++) {
                    lista.add(arregloCat.get(j).get(1));
                }
                
                input = JOptionPane.showInputDialog(null, "Nueva Categoria", null, JOptionPane.INFORMATION_MESSAGE, null, lista.toArray(), fila.get(2));
                catArt = (String)input;
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

            try {
                input = JOptionPane.showInputDialog(null, "Nuevo Stock", fila.get(3));
                stock = Integer.parseInt((String)input);
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

            try {
                input = JOptionPane.showInputDialog(null, "Nueva Fecha Vencimiento", fila.get(4));
                fecha = (String)input;
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

            input = JOptionPane.showConfirmDialog(null,"¿Activar este articulo? ","Estado Actual: " + status, JOptionPane.YES_NO_OPTION);
            if((int)input == JOptionPane.CLOSED_OPTION){
                JOptionPane.showMessageDialog(null, "Edición Cancelada", null, JOptionPane.INFORMATION_MESSAGE);
                return;
            }  
            flagStatus = (int)input == 0;
            
            int idCat = catArtManager.selectCatByStr(catArt);
            
//            tabla.setValueAt(id, pos, 0);
            tabla.setValueAt(nombre, pos, 1);
            tabla.setValueAt(catArt, pos, 2);
            tabla.setValueAt(stock, pos, 3);
            tabla.setValueAt(fecha, pos, 4); 
            tabla.setValueAt(flagStatus, pos, 5);
            
            manager.update((int)fila.get(0),nombre,idCat,stock,fecha,flagStatus);
            
        } catch (Exception ex) {
            Log.seguir(ex.getMessage());
            JOptionPane.showMessageDialog(null, "No hay fila seleccionada");
        }
    }    
    
    public void clearAll(Maestro master){
        JTable tabla = master.getTablaArticulos();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
        
        master.getComboArtCat().removeAllItems();
    }
}
