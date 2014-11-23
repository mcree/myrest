/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.rigo.myrest;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import java.util.List;
import java.util.SortedSet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

/**
 *
 * @author mcree
 */
@Stateless
@Path("myentity/")
@Api(value="myentity", description = "My Entity API")
public class MyEntityFacadeREST extends AbstractFacade<MyEntity> {
    @PersistenceContext(unitName = "MyRESTPU")
    private EntityManager em;

    public MyEntityFacadeREST() {
        super(MyEntity.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    @ApiOperation("Create entity")
    public void create(MyEntity entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    @ApiOperation("Update entity")
    public void edit(@PathParam("id") Long id, MyEntity entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    @ApiOperation("Delete entity")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    @ApiOperation(value="Get entity by id", response=MyEntity.class)
    public MyEntity find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    @ApiOperation("List all entities")
    public List<MyEntity> findAll(@ApiParam(allowMultiple = true) @QueryParam("expand") String[] expand) {
        return super.findAll(expand);
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    @ApiOperation("List all entities in a range - can be used for paging")
    public List<MyEntity> findRange(@ApiParam("first result index") @PathParam("from") Integer from, @ApiParam("last result index") @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    @ApiOperation("Gets count of entities")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
