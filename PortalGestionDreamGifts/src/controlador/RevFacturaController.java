/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ArticuloManager;
import deprecated.modelos.ComprasManager;
import vista.Compras;

/**
 *
 * @author luvar
 */
public class RevFacturaController {
    ArticuloManager artManager = new ArticuloManager();
    ComprasManager compManager = new ComprasManager();
    private Object manager;

    
    public void ShowFactura(Compras vista){
        
        ArrayList<ArrayList<Object>> lista = ComprasManager.FacturasEnabledSelectAll();
        JTable tabla = vista.getTablaFacturasRevision();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).remove(0);
            lista.get(i).remove(1);
            lista.get(i).remove(1);
            lista.get(i).remove(1);
            modelo.addRow(lista.get(i).toArray());
        }

        manager.BuscarFacturaSQL(pedido);
        manager.BuscarDetalleFSQL(detalleP);            
    }
}
