package br.com.syonet.hamburguer.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.syonet.hamburguer.Entity.Order;
import br.com.syonet.hamburguer.Entity.Status;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class OrderRepo implements PanacheRepository<Order> {

    @Transactional
    public Order getOrder(Integer id) {
        Map<String, Object> params = new HashMap<>();
        params.put("idOrder", id);
        PanacheQuery<Order> orderQuery = this.find("select o from Order o where o.id = :idOrder", params);
        return orderQuery.firstResult();
    }

    @Transactional
    public List<Order> getOrdersByStatus(Status status) {
        Map<String, Object> params = new HashMap<>();
        params.put("status", status);
        List<Order> orderList = this.list("select o from Order o where o.status = :status", params);
        return orderList;
    }

    @Transactional
    public Response saveOrder(Order Order) {
        this.persist(Order);
        return Response.ok(Order).build();
    }

    @Transactional
    public Response updateOrder(Order order) {
        Map<String, Object> params = new HashMap<>();
        params.put("idOrder", order.getId());
        params.put("Order", order);
        this.update("update Order o where o.id = :idOrder", params);
        return Response.ok(order).build();
    }

    @Transactional
    public Response deleteOrder(Integer idOrder) {
        Map<String, Object> params = new HashMap<>();
        params.put("idOrder", idOrder);
        this.update("delete from Order o where o.id = :idOrder", params);
        return Response.ok().build();
    }
}
