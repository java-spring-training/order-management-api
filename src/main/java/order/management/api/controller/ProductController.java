package order.management.api.controller;

import order.management.api.config.ApiConfig;
import order.management.api.config.WordPressProperties;
import order.management.api.domain.entities.object.Products;
import order.management.api.exception.ParameterInvalidException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import order.management.api.service.ProductService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class ProductController {

    private Logger log = Logger.getLogger(ApiErrorHandler.class);

    private ProductService productService;
    private ProductResponseFactory factory;
    private ApiConfig apiConfig;
    private WordPressProperties wordPressProperties;

    @Autowired
    public ProductController(ProductService productService,
                             ProductResponseFactory factory,
                             ApiConfig apiConfig,
                             WordPressProperties wordPressProperties) {
        this.productService = productService;
        this.factory = factory;
        this.apiConfig = apiConfig;
        this.wordPressProperties = wordPressProperties;
    }

    /**
     * No parameter
     *
     */
    @GetMapping("/list")
    public ProductResponse listAllProduct() {

        String name = apiConfig.getName();

        List<Products> productList = productService.getAll();
        return factory.toProductResponse(productList);
    }

    /**
     * Request Parameters
     *
     * Check id not null
     * Check id > 0
     *
     * Check name not null
     * Check name max length 10
     * Check name chỉ chứa ký tự alphabet
     *
     */
    @GetMapping("/listWithRequestParameters")
    public ProductResponse listProductWithRequestParameters(
            @Valid @ModelAttribute ProductModelAttribute productModelAttribute,
            BindingResult bindingResult) throws ParameterInvalidException {

        if(bindingResult.hasErrors()) {
            throw new ParameterInvalidException(getErrorMessage(bindingResult));
        }

        log.info("API With Request Parameters");

        List<Products> productList = productService.getAll();
        return factory.toProductResponse(productList);
    }

    /**
     * Request Body
     *
     */
    @PostMapping("/listWithRequestBody")
    public ProductResponse listWithRequestBody(
            @RequestBody ProductRequestBody productRequestBody) {

        log.info("API With Request Body");

        List<Products> productList = productService.getAll();
        return factory.toProductResponse(productList);
    }

    /**
     * PathVariable
     *
     */
    @GetMapping("/listWithPathVariable/{id}/{name}")
    public ProductResponse listWithPathVariable(
            ProductRequest productRequest) {

        log.info("API With PathVariable");

        List<Products> productList = productService.getAll();
        return factory.toProductResponse(productList);
    }

    /**
     * Request Header
     *
     */
    @GetMapping("/listWithRequestHeader")
    public ProductResponse listWithRequestHeader(
            @Valid @NotNull(message = "thu afwebdksfw") @RequestHeader (name = "id") Integer id,
            @RequestHeader (name = "name") String name) {

        log.info("API With Request Header");

        List<Products> productList = productService.getAll();
        return factory.toProductResponse(productList);
    }

    private String getErrorMessage(BindingResult bindingResult) {

        // Create message from BindingResult
        // Ex: 'name': must not be empty
        StringBuilder message = new StringBuilder();
        bindingResult.getFieldErrors().forEach(fieldError -> message
                                                .append("'")
                                                .append(fieldError.getField())
                                                .append("'")
                                                .append(": ")
                                                .append(fieldError.getDefaultMessage())
                                                .append(", "));
        return message.toString();
    }
}
