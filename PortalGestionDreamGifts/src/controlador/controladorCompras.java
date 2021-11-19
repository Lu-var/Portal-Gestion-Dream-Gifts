/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ComprasManager;
import vista.Compras;
import vista.Maestro;

/**
 *
 * @author nmoli
 */
public class controladorCompras {

    ComprasManager manager = new ComprasManager();

    public void agregarSolicitud(Compras vista) {

        int idOrdenCompra = Integer.parseInt(vista.getTxtIdOrdenCompra().getText());
        int idArticulo = Integer.parseInt(vista.getTxtIdArticulo().getText());
        int Cantidad = Integer.parseInt(vista.getTxtCantidad().getText());
        int PrecioUnitario = Integer.parseInt(vista.getTxtPrecio().getText());

        manager.agregarSolicitud(idOrdenCompra, idArticulo, Cantidad, PrecioUnitario);

    }

    public void registrarCompra(Compras vista) {

        int idFactura = Integer.parseInt(vista.getTxtIdFactura().getText());
        int idArticulo = Integer.parseInt(vista.getTxtIdArticulo().getText());
        int Cantidad = Integer.parseInt(vista.getTxtCantidad().getText());
        int Total = Integer.parseInt(vista.getTxtTotal().getText());
        String FechaVencimiento = vista.getTxtFechaVencimiento().getText();

        manager.registrarCompra(idFactura, idArticulo, Cantidad, Total, FechaVencimiento);

    }

    public void showAll(Compras vista) {
        JTable tabla = vista.getTablaFactura();
        ArrayList<ArrayList<Object>> lista = manager.clientesSelectAllSQL();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        int i = 0;

        while (i < lista.size()) {
            model.addRow(lista.get(i).toArray());
            i++;
        }
    }
}
