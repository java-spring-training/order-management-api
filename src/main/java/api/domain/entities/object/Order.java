package api.domain.entities.object;

import api.domain.value.object.OrderNumber;
import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;

public class Order {
    private OrderNumber orderNumber;
    private Date orderDate;
    private String status;
    private Customer customer;

    public Order(OrderNumber orderNumber, Date orderDate, String status, Customer customer) {
        Preconditions.checkArgument(!ObjectUtils.isEmpty(orderDate), "CustomerNumber must be not empty");
        Preconditions.checkArgument(!StringUtils.isEmpty(status), "Status must be not empty");
        Preconditions.checkArgument(!ObjectUtils.isEmpty(customer), "Customer must be not empty");

        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.status = status;
        this.customer = customer;
    }

    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }
}
