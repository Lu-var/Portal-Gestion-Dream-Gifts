
package controlador;
import vista.Login;
import bd.Conexion;
import bd.Consulta;
import java.sql.Connection;
import java.sql.ResultSet;
/**
 *
 * @author StarxCrow
 */
public class LoginController {
    public static Login login = new Login();
    public static void mostrar(){ login.setVisible(true); }
    public static void ocultar(){ login.setVisible(false); }
    
    //public funcionDelControlador(usuario, contra){ 
        //Aca realizai la consulta a la base de datos y aplicando otras validaicones si fuese necesario
        //comparacion
        // select * from  dreamgifts_
    //}
    public void ingreso (String usuario, String password){

       
        
        try{
            
        Consulta con = new Consulta();
        
       
       String query = "SELECT `idUsuario`, `Nombre`, `Password` FROM `usuarios` WHERE  `Nombre` = '" + usuario + "' AND `Password` = '" + password + "'";
        //System.out.println(query);
        
            ResultSet rs = con.select(query);
        
            if(rs.next() ){
                //String idBd = rs.getString("idUsuario");
                //String nombreBd = rs.getString("Nombre");
                //String passwordBd = rs.getString("Password");
                
                //System.out.println("desde idBd" + idBd);
                //System.out.println("desde nombreBd" + nombreBd);
                //System.out.println("desde passwordBd" + passwordBd);
                System.out.println("bienvenido");
                PrincipalController.mostrar();
                LoginController.ocultar();
            }else{
                System.out.println("no puede entrar");
            }
            
            Conexion.cerrar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
        
    }
}
