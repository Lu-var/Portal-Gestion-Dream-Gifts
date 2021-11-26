/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.BancoManager;
import modelo.ClienteManager;
import modelo.ConfirmacionManager;
import modelo.PackManager;
import vista.Ventas;

/**
 *
 * @author luvar
 */
public class ConfirmacionController {
    
    ConfirmacionManager conManager = new ConfirmacionManager();
    BancoManager bancoManager = new BancoManager();
    ClienteManager clienteManager = new ClienteManager();
    PackManager packManager = new PackManager();
    
    public void confirmarVenta(Ventas vista){
        
        JComboBox comboBanco = vista.getComboBanco();
        JTable tabla = vista.getTablaPendientes();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formato.format(vista.getFechaPago().getDate());
        int codigo = Integer.parseInt(vista.getTxtCodigo().getText());
        String banco = (String)comboBanco.getSelectedItem();
        int idBanco = (Integer)bancoManager.bancoSelectByName(banco).get(0);
        
        int pos = tabla.getSelectedRow();
        int idVenta = (Integer)tabla.getValueAt(pos, 0);
        
        conManager.confirmarVentaSQL(idVenta, idBanco, codigo, fecha);
    }
    
    public void showBancos(Ventas vista){
        JComboBox combo = vista.getComboBanco();
        ArrayList<ArrayList<Object>> lista = bancoManager.bancoSelectAllEnabled();
        lista.forEach(columna -> {
            combo.addItem(columna.get(1));
        });
    }
    
    public void showVentasPendientes(Ventas vista){
        ArrayList<ArrayList<Object>> listaVentas = conManager.selectVentasPendientes();
        
        JTable tabla = vista.getTablaPendientes();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        listaVentas.forEach(columna -> {
            Object[] temp = {columna.get(0),columna.get(9),clienteManager.clientesSelectByRUT((String)columna.get(1)).get(1),clienteManager.clientesSelectByRUT((String)columna.get(1)).get(3), columna.get(7),packManager.selectPackByID((Integer)columna.get(5)).get(1)};
            modelo.addRow(temp);
        });
    }
    
    
    public void showAll(Ventas vista){
        showBancos(vista);
        showVentasPendientes(vista);
    }
    
    public void clearAll(Ventas vista){
        vista.getComboBanco().removeAllItems();
        vista.getTxtCodigo().setText(null);
        vista.getFechaPago().setDate(null);
        DefaultTableModel modelo = (DefaultTableModel)vista.getTablaPendientes().getModel();
        modelo.setRowCount(0);
    }
    
}
