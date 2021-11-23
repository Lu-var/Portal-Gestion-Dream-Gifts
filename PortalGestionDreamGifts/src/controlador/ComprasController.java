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
import modelo.ComprasManager;
import vista.Maestro;
import vista.Compras;
/**
 *
 * @author Longares
 */
public class ComprasController {
    
    ArticuloManager artManager = new ArticuloManager();
    ComprasManager compManager = new ComprasManager();
    private Object manager;
    
    public void showArticulos(Maestro vista){
        
        ArrayList<ArrayList<Object>> lista = artManager.articulosEnabledSelectAll();
        JTable tabla = vista.getjTableArtSolPed();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).remove(0);
            lista.get(i).remove(1);
            lista.get(i).remove(1);
            lista.get(i).remove(1);
            modelo.addRow(lista.get(i).toArray());
        }
            
    }

    public void agregarArticulos(Maestro vista){
        
        try {
            String articulo = "";
            articulo = (String)vista.getjTableArtSolPed().getModel().getValueAt(vista.getjTableArtSolPed().getSelectedRow(),0);
            
            if(articulo.isEmpty()){
                JOptionPane.showMessageDialog(null, "Seleccione un articulo.", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(vista.getjTxt_Cant_Art_Sol_Ped().getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad a agregar.", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            int cantidad = Integer.parseInt(vista.getjTxt_Cant_Art_Sol_Ped().getText());
            int idArticulo = artManager.selectArticuloSQL(articulo);
            
            JTable tablaPedido = vista.getjTableArtIDCant();
            DefaultTableModel modelo = (DefaultTableModel) tablaPedido.getModel();
            Object[] data = {idArticulo,cantidad,articulo};
        
            modelo.addRow(data);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Seleccione un articulo.", "", JOptionPane.INFORMATION_MESSAGE);
            Log.seguir(ex.getMessage());
        }
    }
    
    public void deleteArticulos(Maestro vista){

        JTable tablaPedido = vista.getjTableArtIDCant();
        DefaultTableModel modelo = (DefaultTableModel) tablaPedido.getModel();

        int index = tablaPedido.getSelectedRow();
        modelo.removeRow(index);
    }

    public void agregarPedido(Maestro vista){
        
        String Fpedido=datePedSolPed.getDate().toString();
        datePedSolPed.setText(Fpedido);

        try{

            Fpedido = vista.getdatePedSolPed().getText();
        } catch(Exception ex){
            Log.seguir(ex.toString());
        }
             
        if(Fpedido.isEmpty()){
            JOptionPane.showMessageDialog(null, "Introduzca fecha de pedido: dd/mm/aaaa.", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int stock = 0;
        
        
        int idPedido = 0;
        ArrayList<ArrayList<Object>> listaPedido = ComprasManager.PedidosEnabledSelectAll();
        for (int i = 0; i < listaPedido.size(); i++) {
            if(((String)listaPedido.get(i).get(1)).equals(pedido)){
                idPedido = (Integer)listaPedido.get(i).get(0);
            }
        }
        
        if(idPedido == 0) Log.seguir("ID Pedido desconocido.");
        
        ArrayList<ArrayList<Integer>> DetalleP = new ArrayList<>();
        JTable tabla = vista.getjTableArtIDCant();
        
        if(tabla.getModel().getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Introduzca un articulo.", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }        
        
        for (int i = 0; i < tabla.getModel().getRowCount(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add((Integer)tabla.getValueAt(i, 0));
            temp.add((Integer)tabla.getValueAt(i, 1));
            DetalleP.add(temp);
        }
        
        manager.agregarPedidoSQL(Pedido, Fpedido, articulo, stock, activo);
        manager.agregarDetallePSQL(DetalleP);
    }

    public void ShowPedido(Maestro vista){
        
        ArrayList<ArrayList<Object>> lista = ComprasManager.PedidosEnabledSelectAll();
        JTable tabla = vista.getjTableArtSolPed();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).remove(0);
            lista.get(i).remove(1);
            lista.get(i).remove(1);
            lista.get(i).remove(1);
            modelo.addRow(lista.get(i).toArray());
        }

        manager.BuscarPedidoSQL(Pedido);
        manager.BuscarDetallePSQL(DetalleP);            
    }

   
    public void showAll(Maestro vista){
        showArticulos(vista);
        showPedido(vista);
    }
    
    public void clearAll(Maestro vista){
        DefaultTableModel modeloArt = (DefaultTableModel)vista.getTablaPacksArt().getModel();
        DefaultTableModel modelo = (DefaultTableModel)vista.getTablaPacks().getModel();
        
        modeloArt.setRowCount(0);
        modelo.setRowCount(0);

    }
    
    public void ShowFactura(Maestro vista){
        
        ArrayList<ArrayList<Object>> lista = ComprasManager.FacturasEnabledSelectAll();
        JTable tabla = vista.getjTable1();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).remove(0);
            lista.get(i).remove(1);
            lista.get(i).remove(1);
            lista.get(i).remove(1);
            modelo.addRow(lista.get(i).toArray());
        }

        manager.BuscarFacturaSQL(Pedido);
        manager.BuscarDetalleFSQL(DetalleP);            
    }
    

}
