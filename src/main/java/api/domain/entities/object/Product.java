package api.domain.entities.object;

import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class Product {
    private String productName;
    private BigDecimal buyPrice;

    public Product(String productName, BigDecimal buyPrice) {
        Preconditions.checkArgument(!StringUtils.isEmpty(productName), "productName must be not empty");
        Preconditions.checkArgument(!ObjectUtils.isEmpty(buyPrice), "buyPrice must be not empty");
        this.productName = productName;
        this.buyPrice = buyPrice;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }
}
