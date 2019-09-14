package api.controller;

import javax.validation.constraints.NotNull;

public class OrderModelAttribute {

    @NotNull(message = " is required!")
    private Integer customerNumber;

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }
}
