/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

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
    
    
}
