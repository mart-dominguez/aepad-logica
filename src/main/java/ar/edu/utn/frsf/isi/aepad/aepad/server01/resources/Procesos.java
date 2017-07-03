/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.isi.aepad.aepad.server01.resources;

import ar.edu.utn.frsf.isi.aepad.aepad.server01.dto.HistorialDTO;
import ar.edu.utn.frsf.isi.aepad.aepad.server01.modelo.Empleado;
import ar.edu.utn.frsf.isi.aepad.aepad.server01.modelo.InfoResult;
import ar.edu.utn.frsf.isi.aepad.aepad.server01.modelo.Salarios;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author mdominguez
 */
@Path("rrhh")
@Stateless
public class Procesos {

    @PersistenceContext(unitName = "AEPAD_PU")
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/historial/{id}")
    public Response historialSueldo(@PathParam("id") Integer idEmpleado) {
        Map<String, String> resultado = new HashMap<>();
        resultado.put("mensaje", "ok");
        HistorialDTO historial = null;
        try {
        Empleado emp = em.find(Empleado.class, idEmpleado);
        historial = new HistorialDTO(emp, emp.getSalarios());
           } catch (Exception e) {
            resultado.put("mensaje", e.getMessage());
            resultado.put("detalle", e.getLocalizedMessage());
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            resultado.put("pila", errors.toString());
            return Response.ok(resultado, MediaType.APPLICATION_JSON).build();
        }
        return Response.ok(historial, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/liquidar/{id}")
    public Response doAlgo2(@PathParam("id") Integer idEmpleado) {
        Map<String, String> resultado = new HashMap<>();
        resultado.put("mensaje", "ok");
        try {
            Random r = new Random();
            Calendar d1 = Calendar.getInstance();
            Empleado emp = em.find(Empleado.class, idEmpleado);
            Salarios sal1 = new Salarios();
            sal1.setSalario(10000 + r.nextInt(1000));
            sal1.setFechaDesde(d1.getTime());
            d1.add(Calendar.MONTH, 1);
            sal1.setFechaHasta(d1.getTime());
            sal1.setEmpleado(emp);
            Salarios sal2 = new Salarios();
            sal2.setSalario(10000 + r.nextInt(1000));
            sal2.setFechaDesde(d1.getTime());
            d1.add(Calendar.MONTH, 1);
            sal2.setFechaHasta(d1.getTime());
            sal2.setEmpleado(emp);
            em.persist(sal1);
            em.persist(sal2);
            emp.getSalarios().add(sal1);
            emp.getSalarios().add(sal2);
            Empleado emp2 = em.merge(emp);
        } catch (Exception e) {
            resultado.put("mensaje", e.getMessage());
            resultado.put("detalle", e.getLocalizedMessage());
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            resultado.put("pila", errors.toString());
        }
        return Response.ok(resultado).build();
    }

}
