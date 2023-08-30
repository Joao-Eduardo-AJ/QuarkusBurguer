package br.com.syonet.hamburguer.api;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import br.com.syonet.hamburguer.Entity.Customer;
import br.com.syonet.hamburguer.Repository.CustomerRepo;
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

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerRepo repo;

    @GET
    public Customer getCustomer(@QueryParam("id") Integer id, @QueryParam("idCard") Integer idCard) {
        if (idCard != null) {
            return repo.getCustomerByIdCard(idCard);
        }
        return repo.getCustomer(id);
    }

    @PUT
    public Response saveCustomer(Customer customer) {
        return repo.saveCustomer(customer);
    }

    @POST
    public Response updateCustomer(Customer customer) {
        return repo.updateCustomer(customer);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustome(@PathParam("id") Integer id) {
        return repo.deleteCustomer(id);
    }
}