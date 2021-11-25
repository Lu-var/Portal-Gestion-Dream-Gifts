/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.ArrayList;
import javax.swing.JComboBox;
import modelo.PackManager;
import vista.Ventas;
/**
 *
 * @author luvar
 */
public class VentaController {
    
    PackManager packManager = new PackManager();
    
    public void showPacks(Ventas vista){
        JComboBox combo = vista.getComboPack();
        ArrayList<ArrayList<Object>> lista = packManager.selectAllPackEnabled();
        for (ArrayList<Object> columna : lista) {
            combo.addItem(columna.get(1));
        }
    }
    
}
