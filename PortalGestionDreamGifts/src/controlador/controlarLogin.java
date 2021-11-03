
package controlador;

import vista.ADM;
import vista.loginOld;

/**
 *
 * @author Usuario
 */
public class controlarLogin {
    //Instancia loginOld
    
    loginOld v  = new loginOld();
    
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
