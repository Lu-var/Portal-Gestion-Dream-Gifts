package modelo;

import bd.Log;
import java.sql.*;
import java.lang.*;

/**
 *
 * @author luvar
 */

public class ConexionRequest {

    public Connection conectar() {

        Connection connect = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {
            Log.seguir("Error: " + e.getMessage());
        }
        try {

            connect = DriverManager.getConnection("jdbc:mysql://186.104.113.169:65535/DreamGifts_db", "root", "Hello.World@5");

            Log.seguir("Conexion Establecida OK.");

        } catch (Exception e) {

            Log.seguir("Error Conexion: " + e.getMessage());
        }

        return connect;
    }
}
