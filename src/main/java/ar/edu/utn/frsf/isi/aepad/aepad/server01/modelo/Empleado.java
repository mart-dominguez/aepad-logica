/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.isi.aepad.aepad.server01.modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author martdominguez
 */
@Entity
@Table(name="AEPAD_EMPLEADO")
@XmlRootElement
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    
    private Integer nro;
    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_NACIMIENTO")
    private Date fechaNacimiento;
    private String nombre;
    private String apellido;
    private String genero;
    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_CONTRATACION")
    private Date fechaContratacion;
    
    @OneToMany(mappedBy = "empleado")
    private List<Salarios> salarios;
    @OneToMany(mappedBy = "empleado")
    private List<AdministradorDepto> deptosAdministrados;
    @OneToMany(mappedBy = "empleado")
    private List<EmpleadoDepto> deptosAsignados;
    @OneToMany(mappedBy = "empleado")
    private List<Cargos> cargo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNro() {
        return nro;
    }

    public void setNro(Integer nro) {
        this.nro = nro;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @XmlTransient
    public List<Salarios> getSalarios() {
        return salarios;
    }

    public void setSalarios(List<Salarios> salarios) {
        this.salarios = salarios;
    }

    @XmlTransient
    public List<AdministradorDepto> getDeptosAdministrados() {
        return deptosAdministrados;
    }

    public void setDeptosAdministrados(List<AdministradorDepto> deptosAdministrados) {
        this.deptosAdministrados = deptosAdministrados;
    }

    @XmlTransient
    public List<EmpleadoDepto> getDeptosAsignados() {
        return deptosAsignados;
    }

    public void setDeptosAsignados(List<EmpleadoDepto> deptosAsignados) {
        this.deptosAsignados = deptosAsignados;
    }

    @XmlTransient
    public List<Cargos> getCargo() {
        return cargo;
    }

    public void setCargo(List<Cargos> cargo) {
        this.cargo = cargo;
    }
    
    

}
