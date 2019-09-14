package api.domain.value.object;

import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.util.ObjectUtils;

public class CustomerNumber {
    private int customerNumber;

    public CustomerNumber(int customerNumber) {
        Preconditions.checkArgument(customerNumber > 0 || !ObjectUtils.isEmpty(customerNumber), "Invalid CustomerNumber");
        this.customerNumber = customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }
}
