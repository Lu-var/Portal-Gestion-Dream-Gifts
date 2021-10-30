package modelo;

import java.sql.*;
import java.lang.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;

/**
 *
 * @author luvar
 */
//            -----[DEBUG] Codigo para preguntar input de cada credencial-----
//            address = JOptionPane.showInputDialog(null,"IP Base de Datos","localhost");
//            if(address.isEmpty()|| address == null) throw new Exception("Dirección Incorrecta");
//            
//            database = JOptionPane.showInputDialog("Nombre Base de Datos");
//            if(database.isEmpty()|| database == null) throw new Exception("Base de Datos Incorrecta");
//            
//            user = JOptionPane.showInputDialog("Usuario");
//            if(user.isEmpty()|| user == null) throw new Exception("Usuario Incorrecto");
//            
//            JPasswordField pwd = new JPasswordField(20);
//            pass = "";
//            int action = JOptionPane.showConfirmDialog(null, pwd,"Introducir Contraseña",JOptionPane.OK_CANCEL_OPTION);
//            if(action < 0| action == 2) throw new Exception("Contraseña Incorrecta");
//            else pass = new String(pwd.getPassword());
public class ConexionRequest {

    public Connection conectar() {

        Connection connect = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Whoops! Error: " + e.getMessage());
        }
        try {

            connect = DriverManager.getConnection("jdbc:mysql://localhost/DreamGifts_db", "root", "HelloWorld");

            JOptionPane.showMessageDialog(null, "Conexion Establecida OK.");

//            try{
//            Statement request = conectar.createStatement();
//            
//            int solicitud = request.executeUpdate("INSERT INTO `DreamGifts_db`.`Cliente` (`RUT`, `Nombre`, `Fecha Nacimiento`, `Celular`, `Email`, `Direccion`) VALUES ('3.892.711-K', 'Lucas Vargas', '1998/06/20', '+56 9 95897686', 'mail.com', 'La Llaveria Norte 5404');");
//            System.out.println(solicitud);
//            
//            } catch(Exception e){
//            JOptionPane.showMessageDialog(null,"Error Solicitud: \n"+e.getMessage());
//            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error Conexion: \n" + e.getMessage());
        }

        return connect;
    }
}
