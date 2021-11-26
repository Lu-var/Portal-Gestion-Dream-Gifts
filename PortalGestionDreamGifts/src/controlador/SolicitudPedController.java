    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import bd.Log;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ArticuloManager;
import modelo.SolicitudPedManager;
import deprecated.modelos.ComprasManager;
import vista.Compras;
/**
 *
 * @author longares
 */
public class SolicitudPedController {
    ArticuloManager artManager = new ArticuloManager();
    SolicitudPedManager solpedManager = new SolicitudPedManager();
    private Object manager;
    
    public void showArticulos(Compras vista){
        
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
    
    public void agregarArticulos(Compras vista){
        
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
    
    public void deleteArticulos(Compras vista){

        JTable tablaPedido = vista.getjTableArtIDCant();
        DefaultTableModel modelo = (DefaultTableModel) tablaPedido.getModel();

        int index = tablaPedido.getSelectedRow();
        modelo.removeRow(index);
    }
    
    public void agregarPedido(Compras vista){
        Date datePedSolPed = vista.getdatePedSolPed().getDate();
        String fPedido = datePedSolPed.toString();
        int idArticulo = 0;
        int cantidad = 0;

        if(fPedido.isEmpty()){
            JOptionPane.showMessageDialog(null, "Introduzca fecha de pedido: dd/mm/aaaa.", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }


        ArrayList<ArrayList<Object>> listaArt = solpedManager.articulosEnabledSelectAll();
        for (int i = 0; i < listaArt.size(); i++) {
            if(((String)listaArt.get(i).get(1)).equals(cantidad)){
                idArticulo = (Integer)listaArt.get(i).get(0);
            }
        }
        
        if(idArticulo == 0) Log.seguir("ID Pedido desconocido.");
        
        ArrayList<ArrayList<Integer>> detalleP = new ArrayList<>();
        JTable tabla = vista.getjTableArtIDCant();
        
        if(tabla.getModel().getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Introduzca un articulo.", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }        
        
        for (int i = 0; i < tabla.getModel().getRowCount(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add((Integer)tabla.getValueAt(i, 0));
            temp.add((Integer)tabla.getValueAt(i, 1));
            detalleP.add(temp);
        }
        
        solpedManager.agregarPedidoSQL(fPedido);
        solpedManager.agregarDetallePSQL(detalleP);
    }

   
    public void ShowPedido(Compras vista){
 
        try{
        int pedidoNum = 0;
            pedidoNum = Integer.parseInt(vista.getjTxt_Num_Ped_Sol_Ped().getText());        

        } catch(Exception ex){
            Log.seguir(ex.toString());
        }       
            if(vista.getjTxt_Num_Ped_Sol_Ped().getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Escriba Número de Pedido.", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            } 

        ArrayList<ArrayList<Object>> lista = solpedManager.articulosEnabledSelectAll();
        JTable tabla = vista.getjTableDetPed();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).remove(0);
            lista.get(i).remove(1);
            lista.get(i).remove(1);
            lista.get(i).remove(1);
            modelo.addRow(lista.get(i).toArray());
        }
        solpedManager.BuscarPedidoSQL(pedidoNum);

    }

   
    public void showAll(Compras vista){
        showArticulos(vista);
        showdetalleP(vista);
    }
    
    public void clearAll(Compras vista){
        DefaultTableModel modeloArt = (DefaultTableModel)vista.getjTableArtIDCant().getModel();
        DefaultTableModel modelo = (DefaultTableModel)vista.getjTableDetPed().getModel();
        
        modeloArt.setRowCount(0);
        modelo.setRowCount(0);

    }
}
