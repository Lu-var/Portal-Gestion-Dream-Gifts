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
import modelo.ConfirmacionManager;
import vista.Ventas;

/**
 *
 * @author luvar
 */
public class ConfirmacionController {
    
    ConfirmacionManager conManager = new ConfirmacionManager();
    BancoManager bancoManager = new BancoManager();
    
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
    
    public void showAll(Ventas vista){
        showBancos(vista);
    }
    
    public void clearAll(Ventas vista){
        vista.getComboBanco().removeAllItems();
        vista.getTxtCodigo().setText(null);
        vista.getFechaPago().setDate(null);
        DefaultTableModel modelo = (DefaultTableModel)vista.getTablaPendientes().getModel();
        modelo.setRowCount(0);
    }
    
}
