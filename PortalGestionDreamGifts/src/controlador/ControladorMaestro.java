/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.UsuarioManager;
import vista.Login;
import vista.Maestro;
import vista.Ventas;

/**
 *
 * @author luvar
 */
public class ControladorMaestro {
    
    public void openVentas(Maestro vistaMaestro){
        Ventas ventas = new Ventas();
        vistaMaestro.dispose();
        ventas.setVisible(true);
    }
}
