/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import modelo.ComunaManager;
import modelo.PackManager;
import vista.Ventas;
/**
 *
 * @author luvar
 */
public class VentaController {
    
    PackManager packManager = new PackManager();
    ComunaManager comunaManager = new ComunaManager();
    
    public void showPacks(Ventas vista){
        JComboBox combo = vista.getComboPack();
        ArrayList<ArrayList<Object>> lista = packManager.selectAllPackEnabled();
        lista.forEach(columna -> {
            combo.addItem(columna.get(1));
        });
    }
    
    public void showComunas(Ventas vista){
        JComboBox combo = vista.getComboComuna();
        ArrayList<ArrayList<Object>> lista = comunaManager.comunaSelectAllEnabled();
        lista.forEach(columna -> {
            combo.addItem(columna.get(1));
        });
    }
    
    public void showPrecioPack(Ventas vista){
        JTextField subtotal = vista.getTxtSubtotal();
        JComboBox combo = vista.getComboPack();
        String pack = (String)combo.getSelectedItem();
        int idPack = (Integer)combo.getSelectedIndex() + 1;
        ArrayList<ArrayList<Object>> lista = packManager.selectAllPackEnabled();
        for (int i = 0; i < lista.size(); i++) {
            if(idPack == (Integer)lista.get(i).get(0) && ((String)lista.get(i).get(1)).equals(pack)){
                subtotal.setText(((Integer)lista.get(i).get(2)).toString());
            }
        }
    }
    
    public void calcularPrecio(Ventas vista){
        
        JTextField subtotal = vista.getTxtSubtotal();
        JTextField envios = vista.getTxtEnvio();
        JTextField total = vista.getTxtTotal();

        String subtotalStr = subtotal.getText();
        String enviosStr = envios.getText();
        
        Pattern pattern = Pattern.compile("\\D");
        Matcher strMatch = pattern.matcher(enviosStr);
        if(strMatch.find()){
            total.setText("");
            return;
        }

        
        if(envios.getText().isEmpty() || subtotalStr.isEmpty()){
            return;
        }
        
        int subtotalPack = Integer.parseInt(subtotalStr);
        
        int suma = subtotalPack + Integer.parseInt(enviosStr);
        total.setText(String.valueOf(suma));            

    }
    
}
