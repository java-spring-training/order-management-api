package order.controller;

import order.config.ApiConfig;
import order.domain.entities.object.Order;
import order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;
    private OrderResponseFactory factory;
    private ApiConfig apiConfig;

    @Autowired
    public OrderController(OrderService orderService,
                           OrderResponseFactory factory,
                           ApiConfig apiConfig) {
        this.orderService = orderService;
        this.factory = factory;
        this.apiConfig = apiConfig;
    }

    @GetMapping("/orders")
    public OrderResponse listAllOrder() {
        List<Order> orderList = orderService.getAll();
        return factory.toOrderResponse(orderList);
    }
}
