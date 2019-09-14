package api.controller;

import api.domain.entities.object.Product;
import java.util.Date;
import java.util.List;

public class OrderResult {
    private int orderNumber;
    private Date orderDate;
    private String status;
    private List<Product> products;
    private String customerName;
    private String phone;
    private String country;
    private String employeeEmail;

    public OrderResult(int orderNumber, Date orderDate, String status, List<Product> products, String customerName, String phone, String country, String employeeEmail) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.status = status;
        this.products = products;
        this.customerName = customerName;
        this.phone = phone;
        this.country = country;
        this.employeeEmail = employeeEmail;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
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

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
