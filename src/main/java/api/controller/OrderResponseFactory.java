package api.controller;

import api.domain.entities.object.Order;
import api.domain.entities.object.OrderDetail;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderResponseFactory {
    private OrderResult toOrderResult(OrderDetail orderDetail) {
        return new OrderResult(
                orderDetail.getOrder().getOrderNumber().getOrderNumber(),
                orderDetail.getOrder().getOrderDate(),
                orderDetail.getOrder().getStatus(),
                orderDetail.getProducts(),
                orderDetail.getOrder().getCustomer().getCustomerName(),
                orderDetail.getOrder().getCustomer().getPhone(),
                orderDetail.getOrder().getCustomer().getCountry(),
                orderDetail.getOrder().getCustomer().getEmployee().getEmail());
    }

    public List<OrderResult> toOrderResultList(List<OrderDetail> orderDetailList) {
        return orderDetailList.stream().map(this::toOrderResult).collect(Collectors.toList());
    }

    public OrderResponse toOrderResponse(List<OrderDetail> orderDetailList) {

        return new OrderResponse(toOrderResultList(orderDetailList));
    }
}
