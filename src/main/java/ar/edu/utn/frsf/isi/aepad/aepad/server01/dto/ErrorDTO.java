/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.isi.aepad.aepad.server01.dto;

/**
 *
 * @author mdominguez
 */
public class ErrorDTO {
    private String mensaje;
    private String detalle;
    private String pila;

    public ErrorDTO() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getPila() {
        return pila;
    }

    public void setPila(String pila) {
        this.pila = pila;
    }
    
    
}
