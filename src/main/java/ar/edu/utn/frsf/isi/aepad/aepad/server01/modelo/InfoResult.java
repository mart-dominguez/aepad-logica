/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.isi.aepad.aepad.server01.modelo;

import java.io.Serializable;

/**
 *
 * @author mdominguez
 */
public class InfoResult implements Serializable{
    private Long inicio;
    private Long fin;
    private Long duracion;
    private String hilo;

    public InfoResult(Long inicio, Long fin, Long duracion, String hilo) {
        this.inicio = inicio;
        this.fin = fin;
        this.duracion = duracion;
        this.hilo = hilo;
    }

    
    
    public InfoResult() {
    }

    @Override
    public String toString() {
        return "InfoResult{" + "inicio=" + inicio + ", fin=" + fin + ", duracion=" + duracion + ", hilo=" + hilo + '}';
    }

    public Long getInicio() {
        return inicio;
    }

    public void setInicio(Long inicio) {
        this.inicio = inicio;
    }

    public Long getFin() {
        return fin;
    }

    public void setFin(Long fin) {
        this.fin = fin;
    }

    public Long getDuracion() {
        return duracion;
    }

    public void setDuracion(Long duracion) {
        this.duracion = duracion;
    }

    public String getHilo() {
        return hilo;
    }

    public void setHilo(String hilo) {
        this.hilo = hilo;
    }
    
    
    
}
