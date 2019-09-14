package api.repository.mapper;

import java.util.Date;

public class OrderModel {
    private int orderNumber;
    private Date orderDate;
    private String status;
    private String customerName;
    private String phone;
    private String country;
    private String employeeEmail;
    private int customerNumber;

    public OrderModel(int orderNumber, Date orderDate, String status, String customerName, String phone, String country, String employeeEmail) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.status = status;
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

    public int getCustomerNumber() {
        return customerNumber;
    }
}
