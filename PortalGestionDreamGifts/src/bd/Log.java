/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;  
import java.util.Date;

/**
 *
 * @author Starlog
 */
public class Log {
    public static void seguir(String msg) {
        try(FileWriter fw = new FileWriter("C:\\logs\\log.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)){
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date fecha = new Date();
            msg = formato.format(fecha) +": " +msg;
            out.println(msg);
            System.out.println(msg);
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}


