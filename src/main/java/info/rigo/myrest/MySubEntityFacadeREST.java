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
import org.jboss.logging.Logger;
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
import org.jboss.logging.Logger.Level;

/**
 *
 * @author mcree
 */
@Stateless
@Path("mysubentity/")
@Api(value="mysubentity", description = "My SubEntity API")
public class MySubEntityFacadeREST extends AbstractFacade<MySubEntity> {
    @PersistenceContext(unitName = "MyRESTPU")
    private EntityManager em;

    public MySubEntityFacadeREST() {
        super(MySubEntity.class);
    }

    private static final Logger LOG = Logger.getLogger(MySubEntityFacadeREST.class.getName());

    @POST
    @Override
    @Consumes({"application/json"})
    @ApiOperation("Create entity")
    public void create(MySubEntity entity) {
        LOG.log(Level.ERROR, "+++++++++ create");

        super.create(entity);        
    }
    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    @ApiOperation("Edit entity")
    public void edit(@PathParam("id") Long id, MySubEntity entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    @ApiOperation("Remove entity")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    @ApiOperation("Find entity")
    public MySubEntity find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    @ApiOperation("Find all entities")
    public List<MySubEntity> findAll(@QueryParam("expand") String[] expand) {
        return super.findAll(expand);
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    @ApiOperation("Page entities")
    public List<MySubEntity> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    @ApiOperation("Count entities")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
