/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.Maestro;
import vista.Ventas;

/**
 *
 * @author luvar
 */
public class ControladorVentas {
    
    public void openMaestro(Ventas vistaVentas){
        Maestro maestro = new Maestro();
        vistaVentas.dispose();
        maestro.setVisible(true);
    }
}
