package br.com.syonet.hamburguer.api;

import jakarta.ws.rs.Produces;

import br.com.syonet.hamburguer.Entity.Order;
import br.com.syonet.hamburguer.Repository.OrderRepo;
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

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    OrderRepo repo;

    @GET
    @Path("/{id}")
    public Order getOrder(@PathParam("id") Integer id) {
        return repo.getOrder(id);
    }

    @PUT
    public Response saveOrder(Order order) {
        return repo.saveOrder(order);
    }

    @POST
    public Response updateOrder(Order order) {
        return repo.updateOrder(order);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrder(@PathParam("id") Integer id) {
        return repo.deleteOrder(id);
    }
}