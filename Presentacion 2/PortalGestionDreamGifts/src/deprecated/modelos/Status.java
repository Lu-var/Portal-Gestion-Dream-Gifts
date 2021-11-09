package deprecated.modelos;

import bd.Consulta;
import bd.Log;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Status {
   
    private int idStatus;
    private String descripcionEstado;

    public Status() {
    }

    public Status(int idStatus, String descripcionEstado) {
        this.idStatus = idStatus;
        this.descripcionEstado = descripcionEstado;
    }

    @Override
    public String toString() {
        return "Status{" + "idStatus=" + idStatus + ", descripcionEstado=" + descripcionEstado + '}';
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }
    
    public boolean agregarStatus(String descripcionEstado)
    {
        Consulta con = new Consulta();
        
        String query = "INSERT INTO `status`(`DescripcionEstado`) VALUES ('"+descripcionEstado+"')";
        Log.seguir("estoy en insert"+query);
        return con.ejecutar(query);
    }
    
    public boolean borrarStatus(String descripcionEstado)
    {
        Consulta con = new Consulta();
        
        String query = String.format("Delete from 'status' " + "where descripcionEstado= '%s'",descripcionEstado);
        Log.seguir("estoy en delete"+query);
        return con.ejecutar(query);
    }
    
    public static List<Status> listarRRSS() throws SQLException
    {
        List<Status> lista =new ArrayList<>();
          String query = String.format("select * from Status");
        Log.seguir("termine de listar");
        ResultSet curSta= bd.Consulta.getInstance().select(query);
        try {
            while(curSta.next())
            {
                Status status =new Status(curSta.getInt("idStatus"), curSta.getString("descripcionEstado"));
                lista.add(status);    
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
