package br.com.syonet.hamburguer.Repository;

import java.util.HashMap;
import java.util.Map;

import br.com.syonet.hamburguer.Entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class CustomerRepo implements PanacheRepository<Customer> {

    @Transactional
    public Customer getCustomer(Integer id) {
        Map<String, Object> params = new HashMap<>();
        params.put("idCustomer", id);
        PanacheQuery<Customer> customerQuery = this.find("select c from Customer c where c.id = :idCustomer", params);
        return customerQuery.firstResult();
    }

    @Transactional
    public Customer getCustomerByIdCard(Integer idCard) {
        Map<String, Object> params = new HashMap<>();
        params.put("idCard", idCard);
        PanacheQuery<Customer> customerQuery = this.find("select c from Customer c where c.id_card = :idCard", params);
        return customerQuery.firstResult();
    }

    @Transactional
    public Response saveCustomer(Customer customer) {
        Customer newCustomer = this.getCustomer(customer.getId());
        if (newCustomer == null) {
            this.persist(customer);
            return Response.ok(customer).build();
        } else {
            return updateCustomer(customer);
        }
    }

    @Transactional
    public Response updateCustomer(Customer customer) {
        Map<String, Object> params = new HashMap<>();
        params.put("idCustomer", customer.getId());
        params.put("Customer", customer);
        this.update("update Customer c where c.id = :idCustomer", params);
        return Response.ok(customer).build();
    }

    @Transactional
    public Response deleteCustomer(Integer idCustomer) {
        Map<String, Object> params = new HashMap<>();
        params.put("idCustomer", idCustomer);
        this.update("delete from Customer c where c.id = :idCustomer", params);
        return Response.ok().build();
    }
}
