package api.repository;

import api.domain.entities.object.Product;
import api.repository.mapper.ProductModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductFactory {
    private Product toProduct(ProductModel productModel) {
        return new Product(productModel.getProductName(), productModel.getBuyPrice());
    }

    public List<Product> toProductList(List<ProductModel> productModels) {
        return productModels.stream().map(this::toProduct).collect(Collectors.toList());
    }
}
