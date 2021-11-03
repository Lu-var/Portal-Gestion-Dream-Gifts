
package controlador;

import vista.ADM;
import vista.login;

/**
 *
 * @author Usuario
 */
public class controlarLogin {
    //Instancia login
    
    login v  = new login();
    
    String user = "todos";
    String clave = "clave";
    String usuario  = v.getTxtUsuario().getText();
    String pass = new String(v.getTxtClave().getPassword()); 

 
    
    public void controlarLogin(){
              
                ADM a = new ADM();
                 a.setVisible(true);
                 v.dispose();   
           
    }
    
    
    
}
