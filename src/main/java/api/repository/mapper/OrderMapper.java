package api.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Component
public class OrderMapper implements RowMapper<OrderModel> {

    @Override
    public OrderModel mapRow(ResultSet resultSet, int i) throws SQLException {
        int orderNumber = resultSet.getInt("orderNumber");
        Date orderDate = resultSet.getDate("orderDate");
        String status = resultSet.getString("status");
        String customerName = resultSet.getString("customerName");
        String phone = resultSet.getString("phone");
        String country = resultSet.getString("country");
        String employeeEmail = resultSet.getString("email");

        return new OrderModel(orderNumber, orderDate, status, customerName, phone, country, employeeEmail);
    }
}
