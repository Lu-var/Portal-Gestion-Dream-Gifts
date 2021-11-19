/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.ComprasManager;
import vista.Compras;

/**
 *
 * @author nmoli
 */
public class controladorCompras {
    ComprasManager manager = new ComprasManager();
    
    public void agregarSolicitud(Compras vista){

        int idOrdenCompra = Integer.parseInt(vista.getTxtIdOrdenCompra().getText());
        int idArticulo = Integer.parseInt(vista.getTxtIdArticulo().getText());
        int Cantidad = Integer.parseInt(vista.getTxtCantidad().getText());
        int PrecioUnitario = Integer.parseInt(vista.getTxtPrecio().getText());
       
        
        manager.agregarSolicitud(idOrdenCompra, idArticulo, Cantidad, PrecioUnitario);
        
        
    }

    
}