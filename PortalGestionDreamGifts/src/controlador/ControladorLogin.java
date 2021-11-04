package controlador;
import java.util.Arrays;
import vista.Login;
import modelo.UsuarioManager;
import vista.Maestro;
/**
 *
 * @author luvar
 */
public class ControladorLogin {
    
    public void ocultar(Login vistaLogin){
        vistaLogin.setVisible(false);
    }
    
    public void menu(){
        Maestro master = new Maestro();
        master.setVisible(true);
    }
    
    public void login(Login vistaLogin){
        String usuario = vistaLogin.getTxtUsuario().getText();
        String clave = String.valueOf(vistaLogin.getTxtContrasena());

        UsuarioManager check = new UsuarioManager();
        try{
            boolean auth = check.loginCheck(usuario, clave);
            if(auth){
                usuario = null;
                clave = null;
                ocultar(vistaLogin);
                menu();
            }
            
        } catch(Exception ex){
            usuario = null;
            clave = null;
            System.out.println(ex.getMessage());
        }
    }
}