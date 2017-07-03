/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.isi.aepad.aepad.server01.modelo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author martdominguez
 */

@Entity
@Table(name="AEPAD_DEPTO")
@XmlRootElement
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;    
    private String codigo;
    
    @OneToMany(mappedBy = "departamento")
    private List<AdministradorDepto> administradores;
    @OneToMany(mappedBy = "departamento")
    private List<EmpleadoDepto> empleados;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public List<AdministradorDepto> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<AdministradorDepto> administradores) {
        this.administradores = administradores;
    }

    @XmlTransient
    public List<EmpleadoDepto> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoDepto> empleados) {
        this.empleados = empleados;
    }

    
}
