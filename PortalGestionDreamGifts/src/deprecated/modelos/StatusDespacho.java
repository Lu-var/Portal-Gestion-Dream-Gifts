/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class StatusDespacho {
   
    private int idStatusDespacho;
    private String descripcionStatus;

    public StatusDespacho() {
    }

    public StatusDespacho(int idStatusDespacho, String descripcionStatus) {
        this.idStatusDespacho = idStatusDespacho;
        this.descripcionStatus = descripcionStatus;
    }

    @Override
    public String toString() {
        return "StatusDespacho{" + "idStatusDespacho=" + idStatusDespacho + ", descripcionStatus=" + descripcionStatus + '}';
    }

    public int getIdStatusDespacho() {
        return idStatusDespacho;
    }

    public void setIdStatusDespacho(int idStatusDespacho) {
        this.idStatusDespacho = idStatusDespacho;
    }

    public String getDescripcionStatus() {
        return descripcionStatus;
    }

    public void setDescripcionStatus(String descripcionStatus) {
        this.descripcionStatus = descripcionStatus;
    }
    
    public boolean agregarStatusDespacho(String descripcionStatus)
    {
        Consulta con = new Consulta();
        
        String query = "INSERT INTO `statusDespacho`(`descripcionEstado`) VALUES ('"+descripcionStatus+"')";
        Log.seguir("estoy en insert"+query);
        return con.ejecutar(query);
    }
    
    public boolean borrarStatusDespacho(String descripcionStatus)
    {
        Consulta con = new Consulta();
        
        String query = String.format("Delete from 'statusDespacho' " + "where descripcionStatus= '%s'",descripcionStatus);
        Log.seguir("estoy en delete"+query);
        return con.ejecutar(query);
    }
    
    public static List<StatusDespacho> listarRRSS() throws SQLException
    {
        List<StatusDespacho> lista =new ArrayList<>();
          String query = String.format("select * from Status");
        Log.seguir("termine de listar");
        ResultSet curSta= bd.Consulta.getInstance().select(query);
        try {
            while(curSta.next())
            {
                StatusDespacho status =new StatusDespacho(curSta.getInt("idStatusDespacho"), curSta.getString("descripcionStatus"));
                lista.add(status);    
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(StatusDespacho.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
