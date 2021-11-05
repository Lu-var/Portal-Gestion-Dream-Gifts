/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;


/**
 *
 * @author PC
 */
public class CatArticuloManager {

    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();

    PreparedStatement comando = null;
    boolean resultadoBool;
    ResultSet resultadoSet = null;
    

    public ArrayList<ArrayList<Object>> categoriaSelectAll(){
        ArrayList<ArrayList<Object>> matriz = new ArrayList<ArrayList<Object>>();
        try{
            comando = conexion.prepareStatement("SELECT * FROM CategoriaArticulo");
            resultadoSet = comando.executeQuery();

            int id;
            int status;
            String desc;
            while(resultadoSet.next()){
                ArrayList<Object> fila = new ArrayList<Object>();

                id = resultadoSet.getInt("idCategoriaArticulo");
                status = resultadoSet.getInt("Enabled");
                desc = resultadoSet.getString("Descripcion");

                switch(status){
                    case 0:
                        resultadoBool = false;
                    case 1:
                        resultadoBool = true;

                    default:
                        break;
                }

                fila.add(id);
                fila.add(desc);
                fila.add(resultadoBool);
                
                matriz.add(fila);
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex);
        }
        
        return matriz;
    }

    public void agregarCategoriaSQL(){
        PreparedStatement comando = null;
        int status = 1;
        String descripcion = JOptionPane.showInputDialog("Descripcion: ");
        if(descripcion.equals("")){
            return;
        }

        try{
            comando = conexion.prepareStatement("INSERT INTO CategoriaArticulo (Descripcion,Enabled) VALUES (?,?)");
            comando.setString(1, descripcion);
            comando.setInt(2, status);
            comando.execute();
            

        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }  
    }
    
//    public static void main(String[] args) {
//       CatArticuloManager catArt = new CatArticuloManager();
//       catArt.categoriaSelectAll();
//       catArt.agregarCategoriaSQL();
//       catArt.categoriaSelectAll();
//    }
}