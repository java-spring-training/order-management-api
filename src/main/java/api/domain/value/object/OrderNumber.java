package api.domain.value.object;

import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.util.ObjectUtils;

public class OrderNumber {
    private int orderNumber;

    public OrderNumber(int orderNumber) {
        Preconditions.checkArgument(ObjectUtils.isEmpty(orderNumber) || orderNumber > 0, "OrderNumber is invalid");
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}
