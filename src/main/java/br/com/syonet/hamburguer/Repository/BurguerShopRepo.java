package br.com.syonet.hamburguer.Repository;

import java.util.HashMap;
import java.util.Map;

import br.com.syonet.hamburguer.Entity.BurguerShop;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class BurguerShopRepo implements PanacheRepository<BurguerShop> {

    @Transactional
    public BurguerShop getBurguerShop(Integer id) {
        Map<String, Object> params = new HashMap<>();
        params.put("idBurguerShop", id);
        PanacheQuery<BurguerShop> burguerShopQuery = this
                .find("select bs from BurguerShop bs where bs.id = :idBurguerShop", params);
        return burguerShopQuery.firstResult();
    }

    @Transactional
    public Response saveBurguerShop(BurguerShop burguerShop) {
        this.persist(burguerShop);
        return Response.ok(burguerShop).build();
    }

    @Transactional
    public Response updateBurguerShop(BurguerShop burguerShop) {
        Map<String, Object> params = new HashMap<>();
        params.put("idBurguerShop", burguerShop.getId());
        params.put("BurguerShop", burguerShop);
        this.update("update BurguerShop bs where bs.id = :idburguerShop", params);
        return Response.ok(burguerShop).build();
    }

    @Transactional
    public Response deleteBurguerShop(Integer idBurguerShop) {
        Map<String, Object> params = new HashMap<>();
        params.put("idBurguerShop", idBurguerShop);
        this.update("delete from BurguerShop bs where bs.id = :idburguerShop", params);
        return Response.ok().build();
    }
}
