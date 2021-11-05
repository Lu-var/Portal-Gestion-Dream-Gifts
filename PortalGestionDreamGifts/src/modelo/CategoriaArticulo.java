/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class CategoriaArticulo {

    ConexionRequest intentoConexion = new ConexionRequest();
    Connection conexion = intentoConexion.conectar();

    PreparedStatement comando = null;
    boolean resultadoBool;
    ResultSet resultadoSet = null;

        public boolean categoriaSelectAll(){
            try{
                comando = conexion.prepareStatement("SELECT * FROM CategoriaArticulo");
                resultadoSet = comando.executeQuery();
                
                while(resultadoSet.next()){
                    String status;
                    if(resultadoSet.getInt("Enabled") == 1){
                        status = "Si";
                    } else 
                        status = "No";
                    
                    String msg = String.format("ID Categoria: %d | Descripcion: %s | Activo: %s",
                           resultadoSet.getInt("idCategoriaArticulo"),resultadoSet.getString("Descripcion"),status);
                    
                    System.out.println(msg);
                    System.out.println("\n==========================================\n");
                }
                
                return true;
                
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Error: "+ex);
            }

            return false;
        }
        
        public void AgregarCategoria(){
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

            } catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex);
            }  
        }
    
    public static void main(String[] args) {
       CategoriaArticulo catArt = new CategoriaArticulo();
       catArt.categoriaSelectAll();
       catArt.AgregarCategoria();
       catArt.categoriaSelectAll();
    }
}