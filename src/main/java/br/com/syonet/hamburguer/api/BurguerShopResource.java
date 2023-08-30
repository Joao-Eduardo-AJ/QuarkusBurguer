package br.com.syonet.hamburguer.api;

import jakarta.ws.rs.Produces;

import br.com.syonet.hamburguer.Entity.BurguerShop;
import br.com.syonet.hamburguer.Repository.BurguerShopRepo;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/burguershop")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BurguerShopResource {

    @Inject
    BurguerShopRepo repo;

    @GET
    @Path("/{id}")
    public BurguerShop getBurguerShop(@PathParam("id") Integer id) {
        return repo.getBurguerShop(id);
    }

    @PUT
    public Response saveBurguerShop(BurguerShop burguerShop) {
        return repo.saveBurguerShop(burguerShop);
    }

    @POST
    public Response updateBurguerShop(BurguerShop burguerShop) {
        return repo.updateBurguerShop(burguerShop);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBurguerShop(@PathParam("id") Integer id) {
        return repo.deleteBurguerShop(id);
    }
}