package api.domain.entities.object;

import java.util.List;

public class OrderDetail {
    private Order order;
    private List<Product> products;

    public OrderDetail(Order order, List<Product> products) {
        this.order = order;
        this.products = products;
    }

    public Order getOrder() {
        return order;
    }

    public List<Product> getProducts() {
        return products;
    }
}
