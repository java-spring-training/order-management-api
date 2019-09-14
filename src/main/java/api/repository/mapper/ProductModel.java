package api.repository.mapper;

import java.math.BigDecimal;

public class ProductModel {
    private String productName;
    private BigDecimal buyPrice;

    public ProductModel(String productName, BigDecimal buyPrice) {
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
