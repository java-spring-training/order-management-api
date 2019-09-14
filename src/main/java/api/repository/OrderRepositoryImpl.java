package api.repository;

import api.domain.OrderRepository;
import api.domain.entities.object.Order;
import api.domain.entities.object.OrderDetail;
import api.domain.entities.object.Product;
import api.repository.mapper.OrderMapper;
import api.repository.mapper.OrderModel;
import api.repository.mapper.ProductMapper;
import api.repository.mapper.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl extends JdbcDaoSupport implements OrderRepository {
    private OrderMapper orderMapper;
    private OrderFactory orderFactory;
    private ProductMapper productMapper;
    private ProductFactory productFactory;

    @Autowired
    public OrderRepositoryImpl(DataSource dataSource, OrderMapper orderMapper, OrderFactory orderFactory, ProductMapper productMapper, ProductFactory productFactory) {
        this.setDataSource(dataSource);
        this.orderMapper = orderMapper;
        this.orderFactory = orderFactory;
        this.productMapper = productMapper;
        this.productFactory = productFactory;
    }

    @Override
    public List<OrderDetail> getOrdersByCustomerNumber(int id) {
        String sql =
                "SELECT " +
                    "orders.orderNumber, " +
                    "orders.orderDate, " +
                    "orders.status, orders.customerNumber, " +
                    "customers.customerNumber, " +
                    "customers.customerName, " +
                    "customers.phone, " +
                    "customers.country, " +
                    "employees.email " +
                    "FROM customers " +
                "INNER JOIN employees ON customers.salesRepEmployeeNumber=employees.employeeNumber " +
                "INNER JOIN orders ON customers.customerNumber = orders.customerNumber " +
                "WHERE customers.customerNumber = ?";

        List<OrderModel> orderModelList = this.getJdbcTemplate().query(sql, orderMapper, id);
        for (OrderModel orderModel : orderModelList) {
            getProductList(orderModel.getOrderNumber());
        }

        List<OrderDetail> orderDetailList = new ArrayList<>();
        List<Order> orderList = orderFactory.toOrderList(orderModelList);
        orderList.forEach(order -> {
            List<Product> productList = getProductList(order.getOrderNumber().getOrderNumber());
            OrderDetail orderDetail = new OrderDetail(order, productList);
            orderDetailList.add(orderDetail);
        });

        return orderDetailList;
    }

    private List<Product> getProductList(int orderId) {
        String sql =
                "SELECT " +
                    "productName, " +
                    "buyPrice " +
                "FROM orderdetails " +
                "INNER JOIN products " +
                "ON orderdetails.productCode = products.productCode " +
                "WHERE orderdetails.orderNumber = ?";

        List<ProductModel> productModelList = this.getJdbcTemplate().query(sql, productMapper, orderId);

        return productFactory.toProductList(productModelList);
    }
}
