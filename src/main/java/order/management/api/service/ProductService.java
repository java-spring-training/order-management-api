package order.management.api.service;

import order.management.api.domain.ProductRepository;
import order.management.api.domain.entities.object.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Products> getAll() {

        return productRepository.getAll();
    }
}
