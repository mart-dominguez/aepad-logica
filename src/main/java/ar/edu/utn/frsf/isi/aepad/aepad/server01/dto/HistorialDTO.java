/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.isi.aepad.aepad.server01.dto;

import ar.edu.utn.frsf.isi.aepad.aepad.server01.modelo.Empleado;
import ar.edu.utn.frsf.isi.aepad.aepad.server01.modelo.Salarios;
import java.util.List;

/**
 *
 * @author martdominguez
 */

public class HistorialDTO {

    public Empleado empleado;
    public List<Salarios> sueldos;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Salarios> getSueldos() {
        return sueldos;
    }

    public void setSueldos(List<Salarios> sueldos) {
        this.sueldos = sueldos;
    }

    public HistorialDTO(Empleado empleado, List<Salarios> sueldos) {
        this.empleado = empleado;
        this.sueldos = sueldos;
    }

    public HistorialDTO() {
    }
    
}
