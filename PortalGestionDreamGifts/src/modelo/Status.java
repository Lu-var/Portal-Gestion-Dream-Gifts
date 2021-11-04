/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

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
    
    
}
