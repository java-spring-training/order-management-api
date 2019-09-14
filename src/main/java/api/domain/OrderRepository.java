package api.domain;

import api.domain.entities.object.OrderDetail;

import java.util.List;

public interface OrderRepository {
    List<OrderDetail> getOrdersByCustomerNumber(int id);
}
