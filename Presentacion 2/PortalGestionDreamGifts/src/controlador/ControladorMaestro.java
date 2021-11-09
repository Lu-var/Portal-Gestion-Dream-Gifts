/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JFrame;
import vista.Compras;
import vista.Informes;
import vista.Maestro;
import vista.Ventas;

/**
 *
 * @author luvar
 */
public class ControladorMaestro {
    
    public void openVentas(JFrame vista){
        Ventas ventas = new Ventas();
        vista.dispose();
        ventas.setVisible(true);
    }
    
    public void openCompras(JFrame vista){
        Compras compras = new Compras();
        vista.dispose();
        compras.setVisible(true);
    }
    
    public void openInformes(JFrame vista){
        Informes informes = new Informes();
        vista.dispose();
        informes.setVisible(true);
    }
    
    public void openMaestro(JFrame vista){
        Maestro maestro = new Maestro();
        vista.dispose();
        maestro.setVisible(true);
    }
    
    
}
