/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ComunaManager;
import modelo.ConfirmadasManager;
import modelo.DespachoManager;
import modelo.EstadoDespachoManager;
import modelo.PackManager;
import vista.Ventas;

/**
 *
 * @author luvar
 */
public class DespachoController {
    
    EstadoDespachoManager estadoManager = new EstadoDespachoManager();
    ConfirmadasManager confirmadasManager = new ConfirmadasManager();
    PackManager packManager = new PackManager();
    ComunaManager comunaManager = new ComunaManager();
    DespachoManager despachoManager = new DespachoManager();
    
    public void showEstados(Ventas vista){
        ArrayList<ArrayList<Object>> lista = estadoManager.estadoSelectAllEnabled();
        JComboBox combo = vista.getComboEstadoDespacho();
        lista.forEach(columna -> {
            combo.addItem(columna.get(1));
        });
    }
    
    public void showVentas(Ventas vista){
        ArrayList<ArrayList<Object>> lista = confirmadasManager.selectVentasConfirmadas();
        
        DefaultTableModel modelo = (DefaultTableModel)vista.getTablaEstadoDespacho().getModel();
        
        lista.forEach(columna -> {
            String hora = (String)columna.get(16) + " a " + (String)columna.get(17);
            Object[] temp = {columna.get(0), packManager.selectPackByID((Integer)columna.get(5)).get(1), columna.get(12), columna.get(11),comunaManager.comunaSelectByID((Integer)columna.get(15)).get(1), hora, estadoManager.estadoSelectByID((Integer)columna.get(18)).get(1)};
            modelo.addRow(temp);
        });
    }
    
    public void showAll(Ventas vista){
        showVentas(vista);
        showEstados(vista);
    }
    
    public void clearAll(Ventas vista){
        DefaultTableModel modelo = (DefaultTableModel)vista.getTablaEstadoDespacho().getModel();
        modelo.setRowCount(0);
        vista.getComboEstadoDespacho().removeAllItems();
    }
    
    public void actualizarDespacho(Ventas vista){
        JTable tabla = vista.getTablaEstadoDespacho();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        String estado = (String)vista.getComboEstadoDespacho().getSelectedItem();
        
        int pos = tabla.getSelectedRow();
        int idVenta = (Integer)tabla.getValueAt(pos, 0);
        tabla.setValueAt(estado, pos, 6);
        
        int idEstado = (Integer)estadoManager.estadoSelectByName(estado).get(0);
        
        despachoManager.updateEstado(idVenta,idEstado);
    }
    
}
