/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.BancoManager;
import modelo.ClienteManager;
import modelo.ComunaManager;
import modelo.PackManager;
import modelo.RedSocialManager;
import modelo.VentaManager;
import vista.Ventas;
/**
 *
 * @author luvar
 */
public class VentaController {
    
    PackManager packManager = new PackManager();
    ComunaManager comunaManager = new ComunaManager();
    ClienteManager clienteManager = new ClienteManager();
    VentaManager ventaManager = new VentaManager();
    RedSocialManager rrssManager = new RedSocialManager();
    BancoManager bancoManager = new BancoManager();
    
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
        int idPack = (Integer)packManager.selectPackByName(pack).get(0);
        ArrayList<ArrayList<Object>> lista = packManager.selectAllPackEnabled();
        for (int i = 0; i < lista.size(); i++) {
            if(idPack == (Integer)lista.get(i).get(0) && ((String)lista.get(i).get(1)).equals(pack)){
                subtotal.setText(((Integer)lista.get(i).get(2)).toString());
            }
        }
    }
    
    public void showRRSS(Ventas vista){
        JComboBox combo = vista.getComboRRSS();
        ArrayList<ArrayList<Object>> lista = rrssManager.rrssSelectAllEnabled();
        lista.forEach(columna -> {
            combo.addItem(columna.get(1));
        });
    }
    
    public void showAll(Ventas vista){
        showComunas(vista);
        showPacks(vista);
        showRRSS(vista);
        showPrecioPack(vista);
        
    }
    
    public void clearAll(Ventas vista){
        vista.getTxtCelTarget().setText(null);
        vista.getTxtDireccion().setText(null);
        vista.getTxtEmailCliente().setText(null);
        vista.getTxtEnvio().setText(null);
        vista.getTxtFechaEntrega().setDate(null);
        vista.getTxtNDestinatario().setText(null);
        vista.getTxtNombreCliente().setText(null);
        vista.getTxtRUTcliente().setText(null);
        vista.getTxtSaludo().setText(null);
        vista.getTxtSubtotal().setText(null);
        vista.getTxtTelefonoCliente().setText(null);
        vista.getTxtTotal().setText(null);
        vista.getComboComuna().removeAllItems();
        vista.getComboFinEntrega().setSelectedIndex(0);
        vista.getComboIniEntrega().setSelectedIndex(0);
        vista.getComboPack().removeAllItems();
        vista.getComboRRSS().removeAllItems();
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
    
    public void agregarVenta(Ventas vista){
        
        String RUT = vista.getTxtRUTcliente().getText();
        boolean flagClienteExists = false; 
        if(clienteManager.clientesFindByRUT(RUT)){
            flagClienteExists = true;
        }
        String nombre = vista.getTxtNombreCliente().getText();
        String celular = vista.getTxtTelefonoCliente().getText();
        String email = vista.getTxtEmailCliente().getText();
        int status = 1;
        int idRRSS = (Integer)rrssManager.rrssSelectByName((String)vista.getComboRRSS().getSelectedItem()).get(0);
        int idPack = (Integer)packManager.selectPackByName((String)vista.getComboPack().getSelectedItem()).get(0);
        
//        if(packManager.checkStock(idPack)){
//            JOptionPane.showMessageDialog(null, "No existen packs o articulos en stock para completar la solicitud");
//            return;
//        }
        
        String msg = vista.getTxtSaludo().getText();
        int valor = Integer.parseInt(vista.getTxtTotal().getText());
        Date dateStart = Date.from(Instant.now());
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaStart = formato.format(dateStart);
        String fechaEntrega = formato.format(vista.getTxtFechaEntrega().getDate());
        String fechaNacimiento = formato.format(vista.getDateNacimiento().getDate());
        String despachoIni = (String)vista.getComboIniEntrega().getSelectedItem();
        String despachoFin = (String)vista.getComboFinEntrega().getSelectedItem();
        String nombreTarget = vista.getTxtNDestinatario().getText();
        String celularTarget = vista.getTxtCelTarget().getText();
        String direccionTarget = vista.getTxtDireccion().getText();
        int idComuna = (Integer)comunaManager.comunaSelectByName((String)vista.getComboComuna().getSelectedItem()).get(0);
        if(!flagClienteExists){
            clienteManager.agregarClienteSQL(RUT, nombre, fechaNacimiento, celular, email);
        }
        ventaManager.agregarVentaSQL(RUT, nombre, fechaNacimiento, celular, email, status, idRRSS, idPack, msg, valor, fechaStart, fechaEntrega, despachoIni, despachoFin, nombreTarget, celularTarget, direccionTarget, idComuna);
        
    }
    
    
    
    
    
}
