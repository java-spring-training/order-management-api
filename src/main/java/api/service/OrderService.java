package api.service;

import api.domain.OrderRepository;
import api.domain.entities.object.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDetail> getOrdersByCustomer(int id) {
        return orderRepository.getOrdersByCustomerNumber(id);
    }
}
