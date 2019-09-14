package api.domain.entities.object;

import api.domain.value.object.CustomerNumber;
import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class Customer {
    private CustomerNumber customerNumber;
    private String customerName;
    private String phone;
    private String country;
    private Employee employee;

    public Customer(CustomerNumber customerNumber, String customerName, String phone, String country, Employee employee) {

        Preconditions.checkArgument(!ObjectUtils.isEmpty(customerName), "CustomerNumber must be not empty");
        Preconditions.checkArgument(!StringUtils.isEmpty(phone), "Phone must be not empty");
        Preconditions.checkArgument(!StringUtils.isEmpty(country), "Country must be not empty");
        Preconditions.checkArgument(!ObjectUtils.isEmpty(employee), "Employee must be not empty");

        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.phone = phone;
        this.country = country;
        this.employee = employee;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public Employee getEmployee() {
        return employee;
    }
}
