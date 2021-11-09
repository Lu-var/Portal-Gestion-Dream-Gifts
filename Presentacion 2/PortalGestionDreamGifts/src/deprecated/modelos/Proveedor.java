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
public class Proveedor {
   
    private String rut;
    private String razonSocial;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private int enabled;

    public Proveedor() {
    }
    
    public Proveedor(String rut, String razonSocial, String nombre, String telefono, String direccion, String email) {
        setRut(rut);
        setRazonSocial(razonSocial);
        setNombre(nombre);
        setTelefono(telefono);
        setDireccion(direccion);
        setEmail(email);
    }
    
    public Proveedor(String rut){
        setRut(rut);
    }
    
    public Proveedor(String rut, String razonSocial, String nombre, String telefono, String direccion, String email,int enable) {
        this.rut = rut;
        this.razonSocial = razonSocial;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "rut=" + rut + ", razonSocial=" + razonSocial + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", email=" + email + ", enabled=" + enabled + '}';
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    
    public boolean agregarproveedor(String rut, String razonSocial, String nombre, String telefono, String direccion, String email)
    {
        Consulta con = new Consulta();
        
        String query = "INSERT INTO `proveedor`(`RUT`, `RazonSocial`, `Nombre`, `Telefono`, `Direccion`, `Email`) "
                     + "VALUES ('"+rut+"','"+razonSocial+"','"+nombre+"','"+telefono+"','"+direccion+"','"+email+"')";
        Log.seguir("estoy en insert"+query);
        return con.ejecutar(query);
    }
    
    public boolean actualizarproveedor(String rut, String razonSocial, String nombre, String telefono, String direccion, String email)
    {
        Consulta con = new Consulta();
        
        String query = String.format("UPDATE `proveedor` SET `RUT`='"+rut+"',`RazonSocial`='"+razonSocial+"',`Nombre`='"+nombre+"',`Telefono`='"+telefono+"',`Direccion`='"+direccion+"',`Email`='"+email+"' WHERE 1");
        Log.seguir("estoy en update"+query);
        return con.ejecutar(query);
    }
     
    public boolean borrarproveedor(String nombre)
    {
        Consulta con = new Consulta();
        
        String query = String.format("Delete from 'proveedor' " + "where nombre= '%s'",nombre);
        Log.seguir("estoy en delete"+query);
        return con.ejecutar(query);
    }
    
    public static List<Proveedor> listarProveedor() throws SQLException
    {
        List<Proveedor> lista =new ArrayList<>();
          String query = String.format("select * from ´proveedor");
        Log.seguir("termine de listar");
        ResultSet curPro= bd.Consulta.getInstance().select(query);
        try {
            while(curPro.next())
            {
                Proveedor pro =new Proveedor(curPro.getString("rut"), curPro.getString("razonSocial"), curPro.getString("nombre"), curPro.getString("telefono"), curPro.getString("direccion"), curPro.getString("email"));
                lista.add(pro);    
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static Proveedor leerProveedor(String rut) throws SQLException
    {
          String query = String.format("Select * from proveedor "+ "where rut = %s",rut);
        Log.seguir("termine de listar");
        ResultSet curPro= bd.Consulta.getInstance().select(query);
        try {
            if(!curPro.next() ) return null;
            
                Proveedor pro =new Proveedor(curPro.getString("rut"));
       
            return pro;
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
