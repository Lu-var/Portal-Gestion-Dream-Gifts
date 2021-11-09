package deprecated.modelos;

import bd.Log;
import bd.Consulta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Crowstone
 */
public class RRSS {
    private int idRRSS;
    private String nombre;
    private int enabled;

    public RRSS() {
    }

    public RRSS(int idRRSS){
        setIdRRSS(idRRSS);
    }
    
    public RRSS(String nombre){
        setNombre(nombre);
    }
    
    public RRSS(int idRRSS, String nombre) {
        this.idRRSS = idRRSS;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "RRSS{" + "isRRSS=" + idRRSS + ", nombre=" + nombre + ", enabled=" + enabled + '}';
    }

    public int getIdRRSS() {
        return idRRSS;
    }

    public void setIdRRSS(int idRRSS) {
        this.idRRSS = idRRSS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
   
    public boolean agregarRRSS(String nombre)
    {
        Consulta con = new Consulta();
        
        String query = "INSERT INTO `RRSS`(`Nombre`) VALUES ('"+nombre+"')";
        Log.seguir("estoy en insert"+query);
        return con.ejecutar(query);
    }
    
    public boolean actualizarRRSS(String nombre)
    {
        Consulta con = new Consulta();
        
        String query = String.format("UPDATE `RRSS` SET =`Nombre`='"+nombre+"' WHERE 1");
        Log.seguir("estoy en update"+query);
        return con.ejecutar(query);
    }
     
    public boolean borrarRRSS(String nombre)
    {
        Consulta con = new Consulta();
        
        String query = String.format("Delete from 'RRSS' " + "where nombre= '%s'",nombre);
        Log.seguir("estoy en delete"+query);
        return con.ejecutar(query);
    }
    
    public static List<RRSS> listarRRSS() throws SQLException
    {
        List<RRSS> lista =new ArrayList<>();
          String query = String.format("select * from RRSS");
        Log.seguir("termine de listar");
        ResultSet curRS= bd.Consulta.getInstance().select(query);
        try {
            while(curRS.next())
            {
                RRSS rrss =new RRSS(curRS.getInt("idRRSS"), curRS.getString("nombre"));
                lista.add(rrss);    
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(RRSS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
   
    public static RRSS leerRRSS(int idRRSS) throws SQLException
    {
          String query = String.format("Select * from RRSS "+ "where idRRSS = %d",idRRSS);
        Log.seguir("termine de listar");
        ResultSet curRS= bd.Consulta.getInstance().select(query);
        try {
            if(!curRS.next() ) return null;
            
                RRSS rrss =new RRSS(curRS.getInt("idRRSS"));
       
            return rrss;
        } catch (SQLException ex) {
            Logger.getLogger(RRSS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}