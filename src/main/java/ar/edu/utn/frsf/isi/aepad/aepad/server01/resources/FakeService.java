/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.isi.aepad.aepad.server01.resources;

import ar.edu.utn.frsf.isi.aepad.aepad.server01.modelo.Empleado;
import ar.edu.utn.frsf.isi.aepad.aepad.server01.modelo.InfoResult;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author mdominguez
 */
@Path("fake")
@Stateless
public class FakeService {
    
    @PersistenceContext(unitName = "AEPAD_PU")
    private EntityManager em;
    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    @Path("metodo1")
    public Response doAlgo(){
        Empleado e1 = new Empleado();
        e1.setApellido("asdasdf");
        em.persist(e1);
        InfoResult resultado;
        Long inicio = System.currentTimeMillis();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FakeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        Long fin = System.currentTimeMillis();
        resultado = new InfoResult(inicio,fin,(fin-inicio),Thread.currentThread().getName());
        System.out.println(resultado.toString());
        return Response.ok(resultado,MediaType.APPLICATION_JSON).build();
    }
    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    @Path("metodo2")
    public Response doAlgo2(){
        InfoResult resultado;
        Long inicio = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FakeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        Long fin = System.currentTimeMillis();
        resultado = new InfoResult(inicio,fin,(fin-inicio),Thread.currentThread().getName());
        System.out.println(resultado.toString());
        return Response.ok(resultado,MediaType.APPLICATION_JSON).build();
    }

}
